package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Medium.
 *
 * @author michaelwong
 */
public class LC146 {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     * The cache is initialized with a positive capacity.
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     */
    private Map<Integer, DoubleLinkedListNode> map;
    private DoubleLinkedListNode headNode;
    private DoubleLinkedListNode tailNode;
    private int capacity;

    // LRU cache
    public LC146(int capacity) {
        map = new HashMap<Integer, DoubleLinkedListNode>();
        headNode = new DoubleLinkedListNode();
        tailNode = new DoubleLinkedListNode();
        headNode.next = tailNode;
        tailNode.prev = headNode;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        DoubleLinkedListNode node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.get(key) == null && map.size() < capacity) {
            DoubleLinkedListNode node = new DoubleLinkedListNode();
            node.val = value;
            node.key = key;
            addNode(node);
            map.put(key, node);
        } else if (map.get(key) == null && map.size() == capacity) {
            DoubleLinkedListNode node = new DoubleLinkedListNode();
            node.val = value;
            node.key = key;
            map.remove(tailNode.prev.key);
            removeNode(tailNode.prev);
            map.put(key, node);
            addNode(node);
        } else if (map.get(key) != null) {
            DoubleLinkedListNode node = map.get(key);
            node.val = value;
            node.key = key;
            removeNode(node);
            addNode(node);
        }

    }

    private void addNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode nextNode = headNode.next;
        headNode.next = node;
        node.next = nextNode;
        node.prev = headNode;
        nextNode.prev = node;
    }

    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode nextNode = node.next;
        DoubleLinkedListNode prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    class DoubleLinkedListNode {
        int val;
        int key;
        DoubleLinkedListNode next;
        DoubleLinkedListNode prev;
    }
}
