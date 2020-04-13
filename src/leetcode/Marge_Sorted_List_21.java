package leetcode;


public class Marge_Sorted_List_21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tear = res;
        while (l1 != null && l2 != null) {
            int one = l1.val;
            int two = l2.val;
            ListNode s;
            if (one <= two) {
                s = new ListNode(one);
                tear.next = s;
                tear = s;
                // if(l1.next.next!=null)
                l1 = l1.next;
                // else
                // l1.next = null;
            } else {
                s = new ListNode(two);
                tear.next = s;
                tear = s;
                // if(l2.next.next!=null)
                l2 = l2.next;
                // else
                // l2.next = null;
            }
        }
        if (l1 != null) {
            tear.next = l1;
        }
        if (l2 != null) {
            tear.next = l2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
