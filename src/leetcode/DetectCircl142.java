package leetcode;

public class DetectCircl142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    public ListNode detectCircle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
        }

        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return slow;


    }
}
