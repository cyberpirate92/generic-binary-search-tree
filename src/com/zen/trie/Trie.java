package com.zen.trie;

public class Trie {
    public TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    private void addWord(TrieNode node, String word) {
        if (word == null)
            return;

        word = word.trim();

        if (word.isEmpty())
            return;

        node.words++;
        int index = (int)(word.charAt(0) - 'a');

        if (index < 0 || index >= node.nodes.length)
            throw new IllegalArgumentException(String.format("Invalid character found '%s'", word.charAt(0)));

        if (node.nodes[index] == null)
            node.nodes[index] = new TrieNode();

        addWord(node.nodes[index], word.substring(1));
    }

    private boolean wordExists(TrieNode node, String word) {
        if (word == null)
            return false;

        word = word.trim();
        if (word.isEmpty())
            return true;

        int index = (int)(word.charAt(0) - 'a');

        if (index < 0 || index >= node.nodes.length)
            return false;

        if (node.nodes[index] == null)
            return false;
        return wordExists(node.nodes[index], word.substring(1));
    }

    private int getPossibleWordCount(TrieNode node, String prefix) {
        if (prefix == null)
            return 0;

        prefix = prefix.trim();
        if (prefix.isEmpty())
            return node.words;

        int index = (int)(prefix.charAt(0) - 'a');

        if (index < 0 || index >= node.nodes.length)
            return 0;

        if (node.nodes[index] == null)
            return 0;

        return getPossibleWordCount(node.nodes[index], prefix.substring(1));
    }

    public void addWord(String word) {
        addWord(rootNode, word);
    }

    public boolean wordExists(String word) {
        return (word != null && !word.trim().isEmpty()) ? wordExists(rootNode, word) : false;
    }

    public int getPossibleWordCount(String prefix) {
        return getPossibleWordCount(rootNode, prefix);
    }
}
