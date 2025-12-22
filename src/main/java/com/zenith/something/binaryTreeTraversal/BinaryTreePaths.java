package com.zenith.something.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> paths = solution.binaryTreePaths(root);
        System.out.println(paths);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> toReturn = new ArrayList<>();
        if (root == null) {
            return toReturn;
        }
        if (root.left == null && root.right == null) {
            toReturn.add(String.valueOf(root.val));
        } else {
            List<String> leftPath = binaryTreePaths(root.left);
            List<String> rightPath = binaryTreePaths(root.right);
            for (String path : leftPath) {
                toReturn.add(root.val + "->" + path);
            }
            for (String path : rightPath) {
                toReturn.add(root.val + "->" + path);
            }
        }
        return toReturn;
    }
}
