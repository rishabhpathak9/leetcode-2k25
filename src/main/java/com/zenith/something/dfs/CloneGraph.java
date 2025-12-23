package com.zenith.something.dfs;

import java.util.HashSet;
import java.util.Set;

import com.zenith.structures.GraphNode;

public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {
        // TODO: Implement graph cloning logic here
        return null;
    }

    private static boolean isClone(GraphNode original, GraphNode cloned) {
        Set<GraphNode> visited = new HashSet<>();
        return isCloneHelper(original, cloned, visited);
    }

    private static boolean isCloneHelper(GraphNode original, GraphNode cloned, Set<GraphNode> visited) {
        if (original == null && cloned == null) {
            return true;
        }
        if (original == null || cloned == null || original == cloned) {
            return false;
        }
        if (original.val != cloned.val) {
            return false;
        }
        if (original.neighbors.size() != cloned.neighbors.size()) {
            return false;
        }

        visited.add(original);

        for (int i = 0; i < original.neighbors.size(); i++) {
            if (visited.contains(original.neighbors.get(i))) {
                continue;
            }
            if (!isCloneHelper(original.neighbors.get(i), cloned.neighbors.get(i), visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        GraphNode clonedGraph = solution.cloneGraph(node1);

        System.out.println("Original graph node: " + node1);
        System.out.println("Cloned graph node: " + clonedGraph);
        System.out.println("Are they different objects? " + (node1 != clonedGraph));
        System.out.println("Do they have the same value? " + (node1.val == clonedGraph.val));
        System.out.println("Do they have the same number of neighbors? "
                + (node1.neighbors.size() == clonedGraph.neighbors.size()));

        if (isClone(node1, clonedGraph)) {
            System.out.println("\n✓ Graph successfully cloned!");
        } else {
            System.out.println("\n✗ Graph clone failed!");
        }
    }
}
