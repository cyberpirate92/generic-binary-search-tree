package com.zen.graph;

public class DijkstraAlgorithm implements IShortestDistanceAlgorithm {
    @Override
    public long findShortestDistance(int[][] adjacencyMatrix, int fromNode, int toNode) {

        boolean[] visited = new boolean[adjacencyMatrix.length];
        long[] distances = new long[adjacencyMatrix.length];

        // set all distances to max
        for (int i=0; i<distances.length; i++) {
            distances[i] = Long.MAX_VALUE;
        }

        distances[fromNode] = 0;

        while(!allNodesVisited(visited)) {
            int currentNode = pickNode(distances, visited);
            for (int i=0; i<adjacencyMatrix.length; i++) {
                if (i != currentNode && adjacencyMatrix[currentNode][i] != 0
                        && distances[currentNode] + adjacencyMatrix[currentNode][i] < distances[i]) {
                    distances[i] = distances[currentNode] + adjacencyMatrix[currentNode][i];
                }
            }
            visited[currentNode] = true;
        }

        return distances[toNode] == Long.MAX_VALUE ? -1 : distances[toNode];
    }

    // returns a index which is not visited & has the shortest distance
    private static int pickNode(long[] distances, boolean[] visited) {
        long minValue = Long.MAX_VALUE;
        int minIndex = -1;

        for(int i=0; i<distances.length; i++) {
            if (!visited[i] && distances[i] < minValue) {
                minValue = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private boolean allNodesVisited(boolean[] array) {
        for (boolean b : array)
            if (!b) return b;
        return true;
    }
}
