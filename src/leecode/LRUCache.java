package leecode;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/lru-cache/description/
 * 
 * @author weiwei
 *
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private int count;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.head.prev = null;
        this.tail.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1); // returns 1
        cache.put(3, 3); // evicts key 2
        cache.get(2); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        cache.get(1); // returns -1 (not found)
        cache.get(3); // returns 3
        cache.get(4); // returns 4
    }

}
