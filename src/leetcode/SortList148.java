package leetcode;

import java.util.Collections;
import java.util.LinkedList;

public class SortList148 {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public ListNode sortList2(ListNode head){
        return null;
    }

    //  先读取到数组里再排序再生成链表的方法。空间复杂度过高
    public ListNode sortList(ListNode head){

        LinkedList<Integer> array = new LinkedList<>();
        while(head!=null){
            array.add(head.val);
            head = head.next;
        }
        Collections.sort(array);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        for(int num:array){
            ListNode temp = new ListNode(num);
            cur.next = temp;
            cur = cur.next;
        }
        return result.next;
    }
}
