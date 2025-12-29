package com.zenith.something.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
		int[] indeg = new int[numCourses];
		for (int[] p : prerequisites) {
			int a = p[0], b = p[1];
			adj.get(b).add(a);
			indeg[a]++;
		}
        int[] order = new int[numCourses];
		Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i]==0){
                queue.add(i);
            }
        }
        int curr = 0;
        while(!queue.isEmpty()){
            int element = queue.poll();
            order[curr++] = element;

            for (int vertex : adj.get(element)){
                indeg[vertex] -=1;
                if (indeg[vertex] == 0){
                    queue.add(vertex);
                }
            }

        }

        if (curr == numCourses){
            return order;
        } else {
            return new int[0];
        }
	}

    

	private static String arrToString(int[] arr) {
		if (arr == null) return "null";
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		CourseScheduleII solver = new CourseScheduleII();

		// Case 1 (simple)
		int num1 = 2;
		int[][] pre1 = {{1, 0}};
		int[] out1 = solver.findOrder(num1, pre1);
		System.out.println("Case 1 Input: numCourses=2 prerequisites=[[1,0]]");
		System.out.println("Expected: [0,1]");
		System.out.println("Actual: " + arrToString(out1));

		// Case 2 (branching)
		int num2 = 4;
		int[][] pre2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		int[] out2 = solver.findOrder(num2, pre2);
		System.out.println("\nCase 2 Input: numCourses=4 prerequisites=[[1,0],[2,0],[3,1],[3,2]]");
		System.out.println("Expected: [0,1,2,3] or [0,2,1,3]");
		System.out.println("Actual: " + arrToString(out2));

		// Case 3 (cycle)
		int num3 = 2;
		int[][] pre3 = {{1, 0}, {0, 1}};
		int[] out3 = solver.findOrder(num3, pre3);
		System.out.println("\nCase 3 Input: numCourses=2 prerequisites=[[1,0],[0,1]] (cycle)");
		System.out.println("Expected: []");
		System.out.println("Actual: " + arrToString(out3));
	}
}

