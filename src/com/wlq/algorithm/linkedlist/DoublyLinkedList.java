package com.wlq.algorithm.linkedlist;

/**
 * @author wuliuqing
 * @date 2019/11/28 17:14
 **/
public class DoublyLinkedList {

    private int length = 0;

    private Node node;

    static final class Node {
        Node next;
        Node pre;
        int val;

        Node(int val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public DoublyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index + 1 > length) {
            return -1;
        }
        return getNode(index + 1).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index <= 0) {
            node = new Node(val, node, null);
        } else if (index == length) {
            Node temp = getNode(index);
            temp.next = new Node(val, null, temp);
        } else {
            Node temp = getNode(index);
            Node newNode = new Node(val, temp.next, temp);
            temp.next.pre = newNode;
            temp.next = newNode;
        }
        length++;
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
            Node temp = getNode(index);
            temp.next = temp.next == null ? null : temp.next.next;
        }
        length--;
    }

    private Node getNode(int index) {
        Node temp = node;
        while (index - 1 > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

}
