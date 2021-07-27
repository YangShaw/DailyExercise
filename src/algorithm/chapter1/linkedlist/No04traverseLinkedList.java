package algorithm.chapter1.linkedlist;

/**
 * @author YangShaw
 * @date 2021/3/15 20:49
 */
public class No04traverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 后序遍历法
     */
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }

    /**
     * 快慢指针法模拟双指针
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head.next == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数的情况
        if (fast != null) {
            slow = slow.next;
        }
        // 从slow开始翻转链表
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
