package leetcode;


public class Delete_Duplicates_82 {

	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	//	递归解法
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null||head.next==null)
			return head;
		if(head.val==head.next.val) {
			while(head.next!=null&&head.val==head.next.val) {
				head = head.next;
			}
			return deleteDuplicates2(head.next);
		}
		head.next = deleteDuplicates2(head.next);
		return head;
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode res = head;
        if(head==null||head.next==null) return head;
        
        //先处理开头的重复
        while(pre==cur) {
        	while(cur==cur.next) {
        		cur = cur.next;
        	}
        	pre =cur.next;
        	cur = pre.next;
        }
        res = pre;
        while(cur.next!=null) {
            while(pre==cur) {
            	while(cur==cur.next) {
            		cur = cur.next;
            	}
            	pre =cur.next;
            	cur = pre.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return pre;
        
    }
}
