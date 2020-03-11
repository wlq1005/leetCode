package com.wlq.algorithm.linkedlist;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @author wlq
 * @since 2020/3/10 22:20
 */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;

        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ptr = head;
        // 原节点后复制个新节点
        while (ptr != null) {
            Node node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
        }
        ptr = head;
        // 复制元节点的random索引，注意null
        while (ptr != null) {
            ptr.next.random = ptr.random == null ? null : ptr.random.next;
            ptr = ptr.next.next;
        }
        // 新节点重新连接
        Node oldNode = head;
        Node newNode = head.next;
        Node newHeadNode = head.next;
        while (oldNode != null) {
            oldNode.next = oldNode.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHeadNode;
    }

}
