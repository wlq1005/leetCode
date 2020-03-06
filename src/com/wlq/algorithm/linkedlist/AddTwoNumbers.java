package com.wlq.algorithm.linkedlist;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author wlq
 * @since 2020/3/6 22:19
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(3);
        l1.next = l2;
        ListNode ll1 = new ListNode(5);
        ListNode ll2 = new ListNode(6);
        ll2.next = new ListNode(4);
        ll1.next = ll2;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode nodes = addTwoNumbers.addTwoNumbers(l1, ll1);
        while (nodes != null) {
            System.out.println(nodes.val);
            nodes = nodes.next;
        }
    }
}
