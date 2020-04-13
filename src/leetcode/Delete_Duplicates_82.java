package leetcode;


public class Delete_Duplicates_82 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //	�ݹ�ⷨ
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
