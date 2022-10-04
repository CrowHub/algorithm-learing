package com.study;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


    }


    /**
     * todo 利用双向链表实现lru
     * 利用 @see LinkedHashMap 实现lru
     */
    static class LRUCache {

        private LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity) {
            cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return this.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    static class Lru {

        static class Node {
            int value;
            Node left;
            Node right;

            public Node(int value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }

            public Node(int value) {
                this.value = value;
            }
        }

        int capacity;
        Node head;
        Node tail;

        public Lru(int capacity) {
            this.capacity = capacity;
            // use dummy node
            head = new Node(-1);
            tail = new Node(-1);

            head.right = tail;
            tail.left=head;
        }

        public int get(int key) {
            Node currentNode = getNode(key);
            if (currentNode == null) {
                return -1;
            }
            // 将当前节点移动到最前面
            currentNode.left.right = currentNode.right;
            currentNode.right.left = currentNode.left;

            currentNode.right = head.right;
            head.right.left = currentNode;
            currentNode.left = head;
            head.right = currentNode;
            return currentNode.value;
        }

        public void put(int key, int value) {

        }

        private Node getNode(int key) {
            for (Node p = head.right;p!=tail;p=p.right){
                if (key == p.value){
                    return p;
                }
            }
            return null;
        }
    }

}
