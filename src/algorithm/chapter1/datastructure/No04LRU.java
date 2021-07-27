package algorithm.chapter1.datastructure;


import java.util.HashMap;
import java.util.Map;

/**
 * @author YangShaw
 * @date 2021/3/27 16:15
 */
public class No04LRU {

    /**
     * 双向链表节点
     */
    class Node {
        Node pre;
        Node next;
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双向链表
     */
    class DoubleList {
        Node head, tail;
        int size;

        DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        // 插入链表末尾（最新位置）
        public void addRecently(Node node) {
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        // 清除链表头部（最老位置）
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node node = head.next;
            remove(node);
            return node;
        }

        // 清除链表某个指定节点（重名替换）
        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }
    }

    // 容量
    int cap;
    // LRU缓存
    DoubleList cache;
    // 索引
    Map<Integer, Node> map;
    No04LRU(int cap) {
        this.cap = cap;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        makeRecently(key);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            // 是否到容量
            if (map.size() >= cap) {
                // 删除最旧
                deleteOld();
            }
            // 放到最新
            addRecently(key, value);
        } else {
            delete(key);
            addRecently(key, value);
            // 不能直接前置key，因为对应的value可能会修改，而makeRecently方法不修改value
            //makeRecently(key);
        }
    }

    // 放到最新
    private void addRecently(int key, int value) {
        Node node = new Node(key, value);
        map.put(key, node);
        cache.addRecently(node);
    }

    // 删除最旧
    private void deleteOld() {
        Node node = cache.removeFirst();
        int key = node.key;
        map.remove(key);
    }

    // 删除
    private void delete(int key) {
        Node node = map.remove(key);
        cache.remove(node);
    }

    // 访问某个key后，置为最新
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addRecently(node);
    }


}
