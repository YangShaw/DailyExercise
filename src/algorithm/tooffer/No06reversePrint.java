package algorithm.tooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/4/13 23:57
 */
public class No06reversePrint {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    List<Integer> result = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        reverse(head);
        int n = result.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        result.add(head.val);
    }
}
