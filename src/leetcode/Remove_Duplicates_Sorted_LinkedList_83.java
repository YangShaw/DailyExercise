package leetcode;

public class Remove_Duplicates_Sorted_LinkedList_83 {

	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	//递归方法解决问题
	public static ListNode solution2(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		head.next = solution2(head.next);
		if(head.val==head.next.val) return head.next;
		return head;
	}
	
	public static ListNode solution(ListNode head) {
		if(head==null) return head;
        ListNode pre=head,cur=head, temp=pre;
		int num = head.val;
		while(cur.next!=null) {
			cur = cur.next;
			if(cur.val==num) continue;
			else {
				temp.next = cur;
                temp = cur;
                num = cur.val;
			}
		}
        if(cur.val==num) temp.next=null;
		return pre;
	}
}
