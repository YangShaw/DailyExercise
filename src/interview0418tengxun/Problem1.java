package interview0418tengxun;

/**
 * @author YangShaw
 * @date 2021/4/18 19:59
 */
public class Problem1 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int va){
            val = va;
        }
    }

    public static ListNode solve(ListNode s) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = s;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        String num = sb.toString();
        int n = num.length();
        String minNum = num;
        int index = 0;
        for (int i = 1; i < n; i++) {
            String temp = num.substring(i) + num.substring(0, i);
            if (temp.compareTo(minNum) < 0) {
                // 找到了更小的串
                num = temp;
                index = i;
            }
        }
        System.out.println(num);
        // 恢复成链表
        ListNode head = new ListNode();
        head.val = num.charAt(0) - '0';
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = num.charAt(i) - '0';
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        ListNode temp = solve(head);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
