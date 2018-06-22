package com.zen.graph;

public interface IShortestDistanceAlgorithm {
    long findShortestDistance(int[][] adjacencyMatrix, int fromNode, int toNode);
}
