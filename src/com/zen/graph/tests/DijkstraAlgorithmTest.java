package com.zen.graph.tests;

import com.zen.graph.DijkstraAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraAlgorithmTest {

    private DijkstraAlgorithm algorithm;

    @BeforeEach()
    void setUp() {
        algorithm = new DijkstraAlgorithm();
    }

    @Test
    void findDistance1() {
        int[][] adjacencyMatrix = new int[][] {
                {0, 3, 0, 4, 0, 0, 0},
                {3, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {4, 0, 0, 0, 5, 7, 0},
                {0, 0, 1, 5, 0, 0, 2},
                {0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0},
        };

        assertEquals(7, algorithm.findShortestDistance(adjacencyMatrix, 0, adjacencyMatrix.length-1));
    }

    @Test
    void findDistance2() {
        int[][] adjacencyMatrix = new int[][] {
                {0, 5, 15, 0},
                {5, 0, 6, 0},
                {15, 6, 0, 2},
                {0, 0, 2, 0},
        };

        assertEquals(13, algorithm.findShortestDistance(adjacencyMatrix, 0, adjacencyMatrix.length-1));
    }

    @Test
    void findDistance3() {
        int[][] adjacencyMatrix = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        assertEquals(4, algorithm.findShortestDistance(adjacencyMatrix, 0, 1));
        assertEquals(12, algorithm.findShortestDistance(adjacencyMatrix, 0, 2));
        assertEquals(19, algorithm.findShortestDistance(adjacencyMatrix, 0, 3));
        assertEquals(21, algorithm.findShortestDistance(adjacencyMatrix, 0, 4));
        assertEquals(11, algorithm.findShortestDistance(adjacencyMatrix, 0, 5));
        assertEquals(9, algorithm.findShortestDistance(adjacencyMatrix, 0, 6));
        assertEquals(8, algorithm.findShortestDistance(adjacencyMatrix, 0, 7));
        assertEquals(14, algorithm.findShortestDistance(adjacencyMatrix, 0, 8));
    }
}