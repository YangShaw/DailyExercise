package leetcodegrindingguide.chapter16;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // 维护一个双向链表
    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        LinkedNode() {

        }

        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 链表头部的不存数据的指针，指向最新的节点
    LinkedNode latest;
    // 链表尾部的指针，指向最旧的节点
    LinkedNode oldest;
    // 记录某个key是否在链表中存在，并且快速定位
    Map<Integer, LinkedNode> map = new HashMap<>();
    int cap;
    int cur;
    public LRUCache(int capacity) {
        latest = new LinkedNode();
        oldest = new LinkedNode();
        latest.next = oldest;
        oldest.pre = latest;

        cap = capacity;
        cur = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 查找并放到最前面
        LinkedNode target = map.get(key);

        // 从原本位置挪走后需要的变化 挪走动2步
        target.next.pre = target.pre;
        target.pre.next = target.next;

        // 插入到头部后需要的变化 插入动4步
        target.next = latest.next;
        target.pre = latest;
        latest.next.pre = target;
        latest.next = target;
        return target.value;

    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            // 不存在，直接添加到头部
            LinkedNode linkedNode = new LinkedNode(key, value);
            // 判断是否达到容量
            if (cur == cap) {
                // 删掉最旧的
                LinkedNode lastNode = oldest.pre;
                // 挪走动2步
                lastNode.pre.next = lastNode.next;
                lastNode.next.pre = lastNode.pre;
                map.remove(lastNode.key);
                cur--;
            }

            // 插入头部，维护双向指针 插入动4步
            linkedNode.next = latest.next;
            linkedNode.pre = latest;
            latest.next.pre = linkedNode;
            latest.next = linkedNode;
            map.put(key, linkedNode);
            cur++;

        } else {
            // 存在，需要给放到最前面来
            LinkedNode target = map.get(key);
            target.value = value;
            // 挪走
            target.next.pre = target.pre;
            target.pre.next = target.next;
            // 插入
            target.next = latest.next;
            target.pre = latest;
            latest.next.pre = target;
            latest.next = target;
            map.put(key, target);
        }
    }
}
