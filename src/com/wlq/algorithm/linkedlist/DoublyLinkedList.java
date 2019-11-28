package com.wlq.algorithm.linkedlist;

/**
 * @author wuliuqing
 * @date 2019/11/28 17:14
 **/
public class DoublyLinkedList {

    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

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

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtTail(3);
        doublyLinkedList.addAtIndex(1,2);
        System.out.println(doublyLinkedList.get(1));
        doublyLinkedList.deleteAtIndex(1);
        System.out.println(doublyLinkedList.get(1));
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtTail(3);
    }

     // 1,2,3

    // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
    //[[],                 [1]        ,[3]         ,[1,2]   ,[1]        ,[1]       ,[1]]
    // [null,null,null,null,2,null,3]
}
