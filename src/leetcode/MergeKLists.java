package leetcode;

import java.util.PriorityQueue;

public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }


    //  使用最小堆
    //  很巧连续两道题都用到了优先级队列。加深对使用heap这种数据结构的印象。
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        //  初始添加一个头节点，结尾的时候返回merged.next即可。做过类似的就会有经验。
        ListNode merged = new ListNode(0);
        ListNode cur = merged;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            heap.add(list);
        }

        while (!heap.isEmpty()) {
            ListNode nextNode = heap.poll();
            cur.next = nextNode;
            cur = cur.next;
            if (nextNode.next != null) {
                heap.add(nextNode.next);
            }
        }
        return merged.next;
    }
}
