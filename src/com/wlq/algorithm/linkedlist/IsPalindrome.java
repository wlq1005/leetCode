package com.wlq.algorithm.linkedlist;

/**
 * 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/submissions/
 *
 * @author wlq
 * @since 2019/11/25 23:01
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.定义快慢两指针,快指针每次两步,慢指针每次一步
        // 2.慢指针每次都将字符进行翻转
        // 3.当快指针达到链表尾结点，慢指针真好到达中间
        // 4.逐个比较两段值
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        while (fast != null) {
            if (fast.next != null) {
                // 偶数
                fast = fast.next.next;
                slow = slow.next;
                head.next = temp;
                temp = head;
                head = slow;
            } else {
                // 奇数
                slow = slow.next;
                head.next = temp;
                head = slow;
                break;
            }
        }
        while (temp != null) {
            if (temp.val != head.val) {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
