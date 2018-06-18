package com.zen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(4);
        bst.add(6);
        bst.add(2);
        bst.add(1);
        bst.add(7);
        bst.add(5);
        bst.add(3);

        System.out.println("\nINORDER");
        bst.traverse(TraversalType.INORDER).forEach(e -> System.out.print(e + ", "));
        System.out.println("\nPRE_ORDER");
        bst.traverse(TraversalType.PRE_ORDER).forEach(e -> System.out.print(e + ", "));
        System.out.println("\nPOST_ORDER");
        bst.traverse(TraversalType.POST_ORDER).forEach(e -> System.out.print(e + ", "));
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Value to find: ");
        int valueToFind = input.nextInt();
        System.out.println((bst.find(valueToFind) != null) ? "Value found" : "Value not found");
    }
}
