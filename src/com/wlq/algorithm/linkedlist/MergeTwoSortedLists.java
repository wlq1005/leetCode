package com.wlq.algorithm.linkedlist;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author wlq
 * @since 2020/3/1 18:53
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 直接递归搞定
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l1.next = l2;

        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(3);
        ll2.next = new ListNode(4);
        ll1.next = ll2;

        ListNode result = new MergeTwoSortedLists().mergeTwoLists(l1, ll1);
        System.out.println(result.val);
        ListNode nodes = result;
        while (nodes.next != null) {
            nodes = nodes.next;
            System.out.println(nodes.val);
        }
    }
}
