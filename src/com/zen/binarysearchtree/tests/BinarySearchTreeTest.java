package com.zen.binarysearchtree.tests;

import com.zen.binarysearchtree.BinarySearchTree;
import com.zen.binarysearchtree.TraversalType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree;
    private ArrayList<Integer> inOrderList, preOrderList, postOrderList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        tree = new BinarySearchTree<Integer>();

        tree.add(4);
        tree.add(6);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(5);
        tree.add(3);

        inOrderList = new ArrayList<>();
        preOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();

        for (int i=1; i<=7; i++)
            inOrderList.add(i);

        preOrderList.add(4);
        preOrderList.add(2);
        preOrderList.add(1);
        preOrderList.add(3);
        preOrderList.add(6);
        preOrderList.add(5);
        preOrderList.add(7);

        postOrderList.add(1);
        postOrderList.add(3);
        postOrderList.add(2);
        postOrderList.add(5);
        postOrderList.add(7);
        postOrderList.add(6);
        postOrderList.add(4);
    }

    @org.junit.jupiter.api.Test
    void add() {

    }

    @org.junit.jupiter.api.Test
    void traverse() {
        assertTrue(tree.traverse(TraversalType.INORDER).equals(inOrderList));
        assertTrue(tree.traverse(TraversalType.PRE_ORDER).equals(preOrderList));
        assertTrue(tree.traverse(TraversalType.POST_ORDER).equals(postOrderList));
    }

    @org.junit.jupiter.api.Test
    void find() {
        assertTrue(tree.find(0) == null);
        for (int i=1; i<=7; i++) {
            assertTrue(tree.find(i) != null);
        }
        assertTrue(tree.find(192) == null);
    }
}