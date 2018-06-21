package com.zen.trie.tests;

import com.zen.trie.Trie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private Trie trie;
    private String[] words;

    @BeforeEach
    void setUp() {
        trie = new Trie();
        words = new String[] {
                "the",
                "apple",
                "applied",
                "basketball",
                "basin",
                "base"
        };
        Arrays.stream(words).forEach(word -> trie.addWord(word));
    }

    @Test
    void addWord() {
        assertEquals(words.length, trie.rootNode.words);
    }

    @Test
    void wordExists() {
        assertTrue(Arrays.stream(words).allMatch(word -> trie.wordExists(word)));
        assertFalse(trie.wordExists(""));
        assertFalse(trie.wordExists(" "));
        assertFalse(trie.wordExists("!"));
        assertTrue(Arrays.stream(words).allMatch(word -> trie.wordExists(word + "x") == false));
    }

    @Test
    void getPossibleWordCount() {
        assertEquals(3, trie.getPossibleWordCount("bas") );
        assertEquals(2, trie.getPossibleWordCount("app") );
    }
}