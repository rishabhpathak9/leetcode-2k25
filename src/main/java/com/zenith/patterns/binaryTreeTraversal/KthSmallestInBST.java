package com.zenith.patterns.binaryTreeTraversal;

import com.zenith.structures.TreeNode;

public class KthSmallestInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);

        KthSmallestInBST solution = new KthSmallestInBST();
        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println(result);
    }

    int result;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
