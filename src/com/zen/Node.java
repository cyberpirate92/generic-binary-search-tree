package com.zen;

import java.util.ArrayList;

class Node<T extends Comparable<T>> {

    T value;
    Node<T> leftNode, rightNode;

    public Node() {
        this(null);
    }

    public Node(T t) {
        value = t;
        leftNode = null;
        rightNode = null;
    }

    public ArrayList<T> preorder(Node<T> node) {
        ArrayList<T> list = new ArrayList<T>();
        if (node == null)
            return list;
        list.add(node.value);
        list.addAll(preorder(node.leftNode));
        list.addAll(preorder(node.rightNode));
        return list;
    }

    public ArrayList<T> postorder(Node<T> node) {
        ArrayList<T> list = new ArrayList<T>();
        if (node == null)
            return list;
        list.addAll(postorder(node.leftNode));
        list.addAll(postorder(node.rightNode));
        list.add(node.value);
        return list;
    }

    public ArrayList<T> inorder(Node<T> node) {
        ArrayList<T> list = new ArrayList<T>();
        if (node == null)
            return list;
        list.addAll(inorder(node.leftNode));
        list.add(node.value);
        list.addAll(inorder(node.rightNode));
        return list;
    }
}