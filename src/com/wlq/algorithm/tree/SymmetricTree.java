package com.wlq.algorithm.tree;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author wlq
 * @since 2020/5/31 19:40
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val == root.right.val) {
            // 对称即：
            // 左子树的左子树 == 右子树的右子树 且 左子树的右子树 == 右子树的左子树
            return isSame(root.left.left, root.right.right) && isSame(root.left.right, root.right.left);
        }
        return false;
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return false;
    }
}
