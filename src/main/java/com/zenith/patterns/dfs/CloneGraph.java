package com.zenith.patterns.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zenith.structures.GraphNode;

public class CloneGraph {
    Map<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        GraphNode clone = new GraphNode(node.val);
        dfs(node, clone);
        return clone;
    }

    private void dfs(GraphNode vertex, GraphNode clone) {
        visited.put(vertex, clone);

        for (GraphNode neighbor : vertex.neighbors) {

            if (!visited.containsKey(neighbor)) {
                GraphNode neighborClone = new GraphNode(neighbor.val);
                dfs(neighbor, neighborClone);
                clone.neighbors.add(neighborClone);

            } else {
                clone.neighbors.add(visited.get(neighbor));
            }
        }
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
            System.out.println("\nYes Graph successfully cloned!");
        } else {
            System.out.println("\nNo Graph clone failed!");
        }
    }
}
