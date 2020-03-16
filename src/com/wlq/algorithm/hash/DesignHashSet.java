package com.wlq.algorithm.hash;

/**
 * @author wlq
 * @since 2020/3/16 22:53
 */
public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        // 返回 true
        hashSet.contains(1);
        // 返回 false (未找到)
        hashSet.contains(3);
        hashSet.add(2);
        // 返回 true
        hashSet.contains(2);
        hashSet.remove(2);
        // 返回  false (已经被删除)
        hashSet.contains(2);
    }
}

class MyHashSet {

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {

    }

    public void add(int key) {

    }

    public void remove(int key) {

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return false;
    }
}
