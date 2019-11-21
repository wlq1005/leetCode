package com.wlq.algorithm.linkedlist;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * @author wlq
 * @since 2019/11/13 23:00
 */
public class MyLinkedList {

    private int length = 0;

    private Node node;

    static final class Node {
        Node next;
        int val;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index + 1 > length || node == null) {
            return -1;
        }
        Node temp = node;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        System.out.println(temp.val);
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        node = new Node(val, length == 0 ? null : node);
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (length == 0) {
            node = new Node(val, null);
        } else {
            Node temp = node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val, null);
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            Node temp = node;
            while (index - 1 > 0) {
                temp = temp.next;
                index--;
            }
            temp.next = new Node(val, temp.next);
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index + 1 > length) {
            return;
        }
        if (index == 0) {
            node = node.next;
        } else {
            Node temp = node;
            while (index - 1 > 0) {
                temp = temp.next;
                index--;
            }
            temp.next = temp.next == null ? null : temp.next.next;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */