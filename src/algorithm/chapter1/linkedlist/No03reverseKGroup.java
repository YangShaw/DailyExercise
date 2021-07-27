package algorithm.chapter1.linkedlist;

/**
 * @author YangShaw
 * @date 2021/3/15 12:10
 */
public class No03reverseKGroup {

    static class ListNode {
        ListNode next;
        int value;
        ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 迭代方法实现翻转
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        // b往后查找k个节点，找到每组翻转的右边界
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode start = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return start;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = reverseKGroup(node1, 2);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }


}
