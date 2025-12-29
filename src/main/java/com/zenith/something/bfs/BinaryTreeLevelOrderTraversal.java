package com.zenith.something.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zenith.structures.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> levels = new ArrayDeque<>();
        queue.add(root);
        levels.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levels.poll();
            List<Integer> currentLevel;
            System.out.println(node.val);
            if (result.isEmpty() || result.size() == level) {
                currentLevel = new ArrayList<>();
                currentLevel.add(node.val);
                result.add(currentLevel);
            } else {
                currentLevel = result.getLast();
                currentLevel.add(node.val);
            }

            if (node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }
        }

        return result;
    }

    private static void printLevelOrder(List<List<Integer>> result) {
        if (result == null) {
            System.out.println("null");
            return;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solver = new BinaryTreeLevelOrderTraversal();

        // Case 1: Simple balanced tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        List<List<Integer>> out1 = solver.levelOrder(root1);
        System.out.println("Case 1 Input: Balanced tree");
        System.out.println("Expected: [[3], [9, 20], [15, 7]]");
        System.out.println("Actual: ");
        printLevelOrder(out1);

        // Case 2: Single node
        // 1
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> out2 = solver.levelOrder(root2);
        System.out.println("\nCase 2 Input: Single node");
        System.out.println("Expected: [[1]]");
        System.out.println("Actual: ");
        printLevelOrder(out2);

        // Case 3: Empty tree
        TreeNode root3 = null;
        List<List<Integer>> out3 = solver.levelOrder(root3);
        System.out.println("\nCase 3 Input: Empty tree");
        System.out.println("Expected: []");
        System.out.println("Actual: ");
        printLevelOrder(out3);
    }
}
