package leetcode;


public class DeleteDuplicates83 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates3(ListNode head){
        ListNode current = head;
        while(current!=null && current.next!=null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
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
        if (head == null || head.next == null) return head;

        //�ȴ���ͷ���ظ�
        while (pre == cur) {
            while (cur == cur.next) {
                cur = cur.next;
            }
            pre = cur.next;
            cur = pre.next;
        }
        res = pre;
        while (cur.next != null) {
            while (pre == cur) {
                while (cur == cur.next) {
                    cur = cur.next;
                }
                pre = cur.next;
                cur = pre.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return pre;

    }
}
