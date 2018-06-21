package com.zen.binarysearchtree;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> rootNode;

    public BinarySearchTree() {
        rootNode = null;
    }

    public void add(T value) {
        rootNode = add(value, rootNode);
    }

    private Node<T> add(T newValue, Node<T> node) {
        if (node == null)
            node = new Node<T>(newValue);
        else if (newValue.compareTo(node.value) >= 0)
            node.rightNode = add(newValue, node.rightNode);
        else
            node.leftNode = add(newValue, node.leftNode);
        return node;
    }

    public ArrayList<T> traverse(TraversalType type) {
        if (type == TraversalType.INORDER)
            return rootNode.inorder(rootNode);
        else if (type == TraversalType.PRE_ORDER)
            return rootNode.preorder(rootNode);
        else
            return rootNode.postorder(rootNode);
    }

    private Node<T> find(T value, Node<T> node) {
        if (node == null)
            return node;

        int comparison = value.compareTo(node.value);
        if (comparison == 0)
            return node;
        return (comparison > 0) ? find(value, node.rightNode) : find(value, node.leftNode);
    }

    public Node<T> find(T value) {
        return find(value, rootNode);
    }
}
