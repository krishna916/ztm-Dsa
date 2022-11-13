package com.krishnamurti.ztmDataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGraph {

    private int numberOfNodes;
    private Map<Integer, List<Integer>> adjacentList;

    public SimpleGraph() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(Integer node) {
        if (!adjacentList.containsKey(node)) {
            adjacentList.put(node, new ArrayList<>());
            this.numberOfNodes++;
        }
    }

    public void addEdge(Integer node1, Integer node2) {
        // undirected graph
        this.adjacentList.get(node1).add(node2);
        this.adjacentList.get(node2).add(node1);
    }

    public void showConnections() {
        for (Integer node : this.adjacentList.keySet()) {
            List<Integer> nodeConnections = this.adjacentList.get(node);
            StringBuilder connections = new StringBuilder();
            for (Integer nodeConnection : nodeConnections) {
                connections.append(nodeConnection).append(" ");
            }
            System.out.println(node + " ---> " + connections);
        }
    }
}
