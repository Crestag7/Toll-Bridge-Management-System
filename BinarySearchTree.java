// Author: Aadarsha Shrestha
// Description: A generic binary search tree class with insert, search, delete, inorder traversal, and save-to-file.

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    BSTNode<T> root;

    // Add a node
    public void insert(T data) {
        root = insertRec(root, data);
    }

    // Recursive insert
    private BSTNode<T> insertRec(BSTNode<T> node, T data) {
        if (node == null) return new BSTNode<>(data);
        if (data.compareTo(node.data) < 0) node.left = insertRec(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = insertRec(node.right, data);
        return node;
    }

    // Search a node
    public T search(T data) {
        return searchRec(root, data);
    }

    // Recursive search
    private T searchRec(BSTNode<T> node, T data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node.data;
        if (cmp < 0) return searchRec(node.left, data);
        else return searchRec(node.right, data);
    }

    // Delete a node
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    // Recursive delete
    private BSTNode<T> deleteRec(BSTNode<T> node, T data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0) node.left = deleteRec(node.left, data);
        else if (cmp > 0) node.right = deleteRec(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.data = findMin(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    // Find minimum value
    private T findMin(BSTNode<T> node) {
        while (node.left != null) node = node.left;
        return node.data;
    }

    // Traverse and do something with each node
    public void inorder(Consumer<T> visit) {
        inorderRec(root, visit);
    }

    private void inorderRec(BSTNode<T> node, Consumer<T> visit) {
        if (node != null) {
            inorderRec(node.left, visit);
            visit.accept(node.data);
            inorderRec(node.right, visit);
        }
    }

    // Save all nodes in-order to a file
    public void saveToFile(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            inorder(driver -> {
                try {
                    writer.write(driver.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // Replace an existing object with a new one
    public void update(T oldData, T newData) {
        delete(oldData);
        insert(newData);
    }
}
