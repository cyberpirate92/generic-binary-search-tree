package com.zen.graph;

public class Graph {

    private int[][] matrix;

    // using composition, so that algorithms can be provided via dependency injection
    private IShortestDistanceAlgorithm shortestDistanceAlgorithm;

    public Graph(int nodeCount, IShortestDistanceAlgorithm algorithm) {
        matrix = new int[nodeCount][nodeCount];
        setShortestDistanceAlgorithm(algorithm);
    }

    public boolean addEdge(int x, int y, int weight, boolean isBidirectional) {
        if (!isValidNodePair(x, y)) return false;
        matrix[x][y] = weight;
        if (isBidirectional)
            matrix[y][x] = weight;
        return true;
    }

    public boolean addEdge(int x, int y, int weight) {
        return addEdge(x, y, weight, true);
    }

    // for un-weighed graphs
    public boolean addEdge(int x, int y) {
        return addEdge(x, y, 1);
    }

    public void setShortestDistanceAlgorithm(IShortestDistanceAlgorithm algorithm) {
        if (shortestDistanceAlgorithm == null)
            throw new IllegalArgumentException("Invalid shortest distance algorithm");
        shortestDistanceAlgorithm = algorithm;
    }

    // A return value of -1 denotes that there's no path between sourceNode and destinationNode
    public long findShortestPath(int sourceNode, int destinationNode) {
        return shortestDistanceAlgorithm.findShortestDistance(matrix, sourceNode, destinationNode);
    }

    public int getNodeCount() {
        return matrix.length;
    }

    private boolean isValidNodePair(int nodeA, int nodeB) {
        return isValidNode(nodeA) && isValidNode(nodeB);
    }

    private boolean isValidNode(int node) {
        return node >= 0 && node <= matrix.length;
    }
}
