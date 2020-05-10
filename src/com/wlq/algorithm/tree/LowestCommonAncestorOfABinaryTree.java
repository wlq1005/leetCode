package com.wlq.algorithm.tree;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author wlq
 * @since 2020/5/10 21:47
 */
public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 是否当前节点
        boolean current = root.val == p.val || root.val == q.val;
        // 查找左边
        boolean left = dfs(root.left, p, q);
        // 查找右边
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((left || right) && current)) {
            ans = root;
        }
        return left || right || current;
    }
}
