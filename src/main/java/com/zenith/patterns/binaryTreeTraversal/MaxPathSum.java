package com.zenith.patterns.binaryTreeTraversal;

import com.zenith.structures.TreeNode;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        MaxPathSum solution = new MaxPathSum();
        int result = solution.maxPathSum(root);
        System.out.println(result);
    }

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxVal;
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
}
