package com.wlq.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author wlq
 * @since 2020/5/13 00:07
 */
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(1, root, result);
        return result;
    }

    public void dfs(int index, TreeNode node, List<List<Integer>> result) {
        if (result.size() < index) {
            result.add(new ArrayList<>());
        }
        result.get(index - 1).add(node.val);
        if (node.left != null) {
            dfs(index + 1, node.left, result);
        }
        if (node.right != null) {
            dfs(index + 1, node.right, result);
        }
    }
}
