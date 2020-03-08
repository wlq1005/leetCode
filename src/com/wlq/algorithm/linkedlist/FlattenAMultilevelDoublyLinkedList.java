package com.wlq.algorithm.linkedlist;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author wlq
 * @since 2020/3/8 15:27
 */
public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = new Node();
        setNode(pre, head);
        pre.next.prev = null;
        return pre.next;
    }

    private Node setNode(Node pre, Node node) {
        if (node == null) {
            return pre;
        }
        Node cur = new Node();
        cur.val = node.val;
        cur.prev = pre;
        pre.next = cur;
        pre = pre.next;
        if (node.child != null) {
            pre = setNode(pre, node.child);
        }
        pre = setNode(pre, node.next);
        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;
        Node n4 = new Node();
        n4.val = 4;
        Node n5 = new Node();
        n5.val = 5;
        Node n6 = new Node();
        n6.val = 6;
        Node n7 = new Node();
        n7.val = 7;
        Node n8 = new Node();
        n8.val = 8;
        Node n9 = new Node();
        n9.val = 9;
        Node n10 = new Node();
        n10.val = 10;
        Node n11 = new Node();
        n11.val = 11;
        Node n12 = new Node();
        n12.val = 12;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;
        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;
        n9.next = n10;
        n10.prev = n9;
        n11.next = n12;
        n12.prev = n11;
        n3.child = n7;
        n8.child = n11;
        Node result = new FlattenAMultilevelDoublyLinkedList().flatten(n1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
