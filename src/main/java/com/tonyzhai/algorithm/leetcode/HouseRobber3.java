package com.tonyzhai.algorithm.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.
 Example 1:

 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:

 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.

 题目大意：
 小偷又给自己找了一个新的偷盗场所。这片区域只有一个入口，叫做“根”。除了根以外，每一个房间有且仅有一个父级房间。在踩点之后，聪明的盗贼发现“所有的房间形成了一棵二叉树”。如果两个有边直接相连的房间在同一晚上都失窃，就会自动联络警察。

 判断盗贼在不惊动警察的情况下最多可以偷到的金钱数目。

 测试用例如题目描述。

 解题思路：
 解法I 深度优先搜索（DFS）

 深度优先遍历二叉树，每次遍历返回两个值：分别表示偷窃或者不偷窃当前节点可以获得的最大收益。

 状态转移方程见代码。
 */
public class HouseRobber3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    private static int[] dfs(TreeNode x) {
        System.out.println("current node is " + (x != null ? x.val : null));
        if(x != null){
            System.out.println("current node left is " + (x.left != null ? x.left.val : null));
            System.out.println("current node right is " + (x.right != null ? x.right.val : null));
        }
        if (x == null) return new int[2];
        System.out.println("current node is " + (x != null ? x.val : null));
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new HouseRobber3.TreeNode(3);
        TreeNode node2 = new HouseRobber3.TreeNode(4);
        TreeNode node3 = new HouseRobber3.TreeNode(5);
        TreeNode node4 = new HouseRobber3.TreeNode(1);
        TreeNode node5 = new HouseRobber3.TreeNode(3);
        TreeNode node6 = new HouseRobber3.TreeNode(1);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(rob(root));
    }
}
