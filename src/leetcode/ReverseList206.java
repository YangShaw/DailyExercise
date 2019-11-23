package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseList206 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2;i<6;++i){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        reverseList2(head);
    }

    public static ListNode reverseList2(ListNode head){
        if(head==null){
            return null;
        }
        ListNode result = head;
        ListNode cur =head.next;

        //由于result=head，那么head作为引用指向的内存区域有了新的别名result。所以将result.next置为null时，head.next也会被置为空。
        result.next = null;
        while(cur!=null){
            ListNode point = new ListNode(cur.val);
            System.out.println(point.val);
            point.next = result;
            result = point;
            System.out.println(result.val);
            cur = cur.next;
        }
        return result;
    }

    //  将元素取出来，利用数组进行反转
    public ListNode reverseList(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(0, cur.val);
            cur = cur.next;
        }
        cur = head;
        for(int i:list){
            cur.val = i;
            cur = cur.next;
        }
        return head;
    }
}
