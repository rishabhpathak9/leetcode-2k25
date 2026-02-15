package com.zenith.basics;

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {
public static void main(String[] args) {
    /*
     * Problem Statement:
     * Given a sample undirected graph, perform a Depth-First Search (DFS) traversal starting from node 0
     * and print the traversal order. The graph is represented using an adjacency list.
     * 
     * Sample Graph:
     * 0 -- 1
     * |    |
     * 2 -- 3
     * 
     * Adjacency list:
     * 0: 1,2
     * 1: 0,3
     * 2: 0,3
     * 3: 1,2
     */
    int V = 4;
    // Adjacency list representation
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adj.add(new java.util.ArrayList<>());
    }
    adj.get(0).add(1);
    adj.get(0).add(2);
    adj.get(1).add(0);
    adj.get(1).add(3);
    adj.get(2).add(0);
    adj.get(2).add(3);
    adj.get(3).add(1);
    adj.get(3).add(2);

    // Call DFS (Implement the dfs method)
    boolean[] visited = new boolean[V];
    System.out.print("DFS Traversal: ");
    dfs(0, adj, visited);
}

static void dfs(int node,List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    System.out.println(node);
    for(int nei: adj.get(node)){
        if(!visited[nei]){
            dfs(nei, adj, visited);
        }
    }
}

}
