package com.wlq.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author wlq
 * @since 2020/2/14 22:34
 */
public class LRUCache {

    private int capacity;

    private Map<Integer, Node> cache = new HashMap<>();

    private Node tail;

    private Node head;

    class Node {

        Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node pre;
        Node next;
        int val;
        int key;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToTail(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                int delKey = removeHead();
                cache.remove(delKey);
            }
            Node newNode = new Node(key, value);
            addToTail(newNode);
            cache.put(key, newNode);
        } else {
            // 更新
            node.val = value;
            moveToTail(node);
        }
    }

    private void addToTail(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.pre = tail;
            tail.next = node;
        }
        tail = node;
    }

    private void moveToTail(Node node) {
        if (node == tail) {
            return;
        }
        if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        tail.next = node;
        tail = node;
    }

    private int removeHead() {
        int key = head.key;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
        return key;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
