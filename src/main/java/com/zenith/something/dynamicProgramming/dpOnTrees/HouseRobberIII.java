package com.zenith.something.dynamicProgramming.dpOnTrees;

import java.util.HashMap;
import java.util.Map;

import com.zenith.structures.TreeNode;

/**
 * LeetCode 337: House Robber III
 *
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root". Besides the root, each house
 * has
 * one and only one parent house. After a tour, the smart thief realized that
 * "all houses in this place forms a binary tree". It will automatically contact
 * the police if two directly-linked houses were both robbed. Return the maximum
 * amount of money the thief can rob without alerting the police.
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        Map<Map.Entry<TreeNode, Boolean>, Integer> map = new HashMap<>();
        int res = Math.max(solve(root, true, map), solve(root, false, map));
        return res;
    }

    private int solve(TreeNode root, boolean b, Map<Map.Entry<TreeNode, Boolean>, Integer> map) {

        if (root == null) {
            return 0;
        }
        if (map.containsKey(Map.entry(root, b))) {
            return map.get(Map.entry(root, b));
        }
        int val = root.val;
        int res;
        if (b) {
            int consider = solve(root.right, false, map) + solve(root.left, false, map) + val;
            int reject = solve(root.right, true, map) + solve(root.left, true, map);
            res = Math.max(consider, reject);
        } else {
            res = solve(root.right, true, map) + solve(root.left, true, map);

        }
        map.put(Map.entry(root, b), res);
        return res;
    }

    public static void main(String[] args) {
        HouseRobberIII hriii = new HouseRobberIII();

        System.out.println("Test 1: root = [3,2,3,null,3,null,1]");
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(7);
        System.out.println("Output: " + hriii.rob(root1));
        System.out.println("Expected: 7\n");

        System.out.println("Test 2: root = [3,4,5,1,3,null,1]");
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println("Output: " + hriii.rob(root2));
        System.out.println("Expected: 9\n");
    }
}
