package com.zen.trie;

public class TrieNode {
    public TrieNode[] nodes;
    public int words;

    public TrieNode() {
        nodes = new TrieNode[26];   // since 26 possible characters
        words = 0;
    }
}
