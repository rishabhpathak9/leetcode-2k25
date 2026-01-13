package com.zenith.something.dynamicProgramming.dpOnTrees;

import com.zenith.structures.TreeNode;

/**
 * LeetCode 124: Binary Tree Maximum Path Sum
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes
 * in the sequence has an edge connecting them. A node can only appear in the
 * sequence
 * at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty
 * path.
 */
public class BinaryTreeMaxPathSum {
    int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        int res = maxVal;
        maxVal = 0;
        return res;
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);

        int maxPathThrough = root.val + Math.max(0, leftSum) + Math.max(0, rightSum);
        maxVal = Math.max(maxVal, maxPathThrough);

        return root.val + Math.max(0, Math.max(leftSum, rightSum));
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum btmps = new BinaryTreeMaxPathSum();

        System.out.println("Test 1: root = [1,2,3]");
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Output: " + btmps.maxPathSum(root1));
        System.out.println("Expected: 6\n");

        System.out.println("Test 2: root = [-10,9,20,null,null,15,7]");
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Output: " + btmps.maxPathSum(root2));
        System.out.println("Expected: 42\n");

        System.out.println("Test 3: root = [2,1]");
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        System.out.println("Output: " + btmps.maxPathSum(root3));
        System.out.println("Expected: 3\n");
    }
}
