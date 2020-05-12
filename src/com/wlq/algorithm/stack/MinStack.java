package com.wlq.algorithm.stack;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @author wlq
 * @since 2020/5/12 23:36
 */
public class MinStack {

    private Node node;

    static class Node {

        private final int val;

        private final int min;

        private Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
    }

    public void push(int x) {
        node = (node == null)
                ? new Node(x, x, null)
                : new Node(x, Math.min(x, node.min), node);
    }

    public void pop() {
        if (node != null) {
            Node next = node.next;
            node.next = null;
            node = next;
        }
    }

    public int top() {
        if (node != null) {
            return node.val;
        }
        return -1;
    }

    public int getMin() {
        if (node != null) {
            return node.min;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
