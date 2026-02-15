package com.zenith.patterns.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.zenith.structures.TreeNode;

public class PathSum2 {

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum, new LinkedList<>());
        return paths;
    }

    private void dfs(TreeNode root, int target, LinkedList<Integer> currentPath) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && target == root.val) {
            currentPath.addLast(target);
            paths.add(List.copyOf(currentPath));
            currentPath.removeLast();
            return;
        }
        target -= root.val;
        currentPath.addLast(root.val);
        dfs(root.left, target, currentPath);
        dfs(root.right, target, currentPath);
        currentPath.removeLast();
    }

    private static void printPaths(List<List<Integer>> paths) {
        if (paths == null) {
            System.out.println("Output: null");
            return;
        }
        System.out.println("Output paths:");
        for (List<Integer> p : paths) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        PathSum2 solution = new PathSum2();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        List<List<Integer>> result = solution.pathSum(root, target);

        System.out.println("=== PathSum2 Test ===");
        System.out.println("Target: " + target);
        printPaths(result);
        System.out.println("Expected: [[5, 4, 11, 2], [5, 8, 4, 5]]");
    }
}
