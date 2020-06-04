package com.wlq.algorithm.tree;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author wlq
 * @since 2020/6/4 23:29
 */
public class SolveProblemsRecursively {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean answer = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return answer;
        }
        getSum(root, 0, sum);
        return answer;
    }

    private void getSum(TreeNode node, int val, int sum) {
        if (answer) {
            return;
        }
        val += node.val;
        if (node.left == null && node.right == null) {
            answer = val == sum;
            return;
        }
        if (node.left != null) {
            getSum(node.left, val, sum);
        }
        if (node.right != null) {
            getSum(node.right, val, sum);
        }
    }

    public static void main(String[] args) {
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);

        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11);
        node11.left = node7;
        node11.right = node2;

        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        node4.left = node11;
        root.left = node4;
        root.right = node8;

        TreeNode node13 = new TreeNode(13);
        TreeNode node4_1 = new TreeNode(4);
        node8.left = node13;
        node8.right = node4_1;

        TreeNode node1 = new TreeNode(1);
        node4_1.right = node1;
        SolveProblemsRecursively solveProblemsRecursively = new SolveProblemsRecursively();
        solveProblemsRecursively.hasPathSum(root, 22);
    }
}
