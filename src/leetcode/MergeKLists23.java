package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists23 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists){
        // 降序排列,使用优先级队列。数据结构是小根堆
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2)->v1.val-v2.val);
        for(ListNode list: lists){
            if(list!=null){
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode curMin = pq.poll();
            if(curMin.next!=null){
                pq.offer(curMin.next);
            }

            cur.next = curMin;
            cur = cur.next;
            //tail = curMin;//相当于tail = tail.next，往后推移一位
        }
        return dummy.next;
    }
}
