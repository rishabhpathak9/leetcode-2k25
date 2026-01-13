package com.zenith.something.dynamicProgramming.dpOnTrees;

import com.zenith.structures.TreeNode;

/**
 * LeetCode 968: Binary Tree Cameras
 *
 * Given a binary tree, we install cameras on the tree nodes where cameras can
 * monitor its parent, itself, and its immediate children. Return the minimum
 * number
 * of cameras needed to monitor all nodes of the tree.
 */
public class BinaryTreeCameras {
    int cams = 0;

    public int minCameraCover(TreeNode root) {
        int res = solve(root) == 0 ? cams + 1 : cams;
        cams = 0;
        return res;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int l = solve(root.left);
        int r = solve(root.right);
        if (l == 0 || r == 0) {
            cams++;
            return 1;
        }
        if (l == 1 || r == 1) {
            return 2;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        BinaryTreeCameras btc = new BinaryTreeCameras();

        System.out.println("Test 1: root = [0,0,null,0,0]");
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(0);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(0);
        System.out.println("Output: " + btc.minCameraCover(root1));
        System.out.println("Expected: 1\n");

        System.out.println("Test 2: root = [0,0,null,0,null,0,null,null,0]");
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(0);
        root2.left.left = new TreeNode(0);
        root2.left.left.left = null;
        root2.left.left.right = new TreeNode(0);
        System.out.println("Output: " + btc.minCameraCover(root2));
        System.out.println("Expected: 2\n");
    }
}
