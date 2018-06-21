package com.zen.trie;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = new String[] {
                "The",
                "Apple",
                "Basketball",
                "Basin",
                "Base",
                "Ant",
                "Art",
                "Axe",
                "Axiom",
                "Tour",
                "Tourist",
                "To",
                "Tomb",
                "These",
                "That",
                "There"
        };
        Arrays.stream(words).forEach(word -> trie.addWord(word.toLowerCase()));
        boolean allWordsExist = Arrays.stream(words).allMatch(word -> trie.wordExists(word.toLowerCase()));
        System.out.println("Result: " + allWordsExist);

        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter any word to find or empty string to exit");
        String word = " ";
        while (!(word = input.nextLine()).isEmpty()) {
            System.out.println(word + (trie.wordExists(word) ? " found" : " not found"));
        }
        input.close();
    }
}
