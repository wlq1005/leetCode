package com.wlq.algorithm.linkedlist;

/**
 * @author wuliuqing
 * @date 2019/11/22 14:13
 **/
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode result = null;
        while (temp != null) {
            if (result != null) {
                ListNode node = new ListNode(temp.val);
                result.next = node;
            }
            temp = temp.next;
            result = new ListNode(temp.val);
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
