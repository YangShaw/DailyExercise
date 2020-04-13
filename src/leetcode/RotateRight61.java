package leetcode;

public class RotateRight61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    /*
    你是我情深似海的依赖
    我是你早已过时的旧爱
    反正这不三不四的年纪
    谁也不会只为谁而着迷
    你是我甘心瞑目的遗憾
    我用那无悔时光来填满
    就让这无怨无悔的双手
    收拾出我想要的以后

    一首歌深夜写给黄淮
    你是我无法言语诉说的爱
    当我在原地无助徘徊
    你告诉我理想必须热爱
    你要我坚持我的执着
    你让我明白我为谁而活
    永恒不只是那一瞬间
    我的未来谢谢你让我看见
     */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int listLen = 0;
        ListNode cur = head;
        //  查长度
        while (cur != null) {
            listLen++;
            cur = cur.next;
        }

        //  实际需要移动的步数
        int realK = k % listLen;
        //  不需要移动
        if (realK == 0) {
            return head;
        }


        ListNode temp = head;
        for (int i = 1; i < listLen - realK; ++i) {
            temp = temp.next;
        }
        //  前一段的终点
        ListNode end = temp;
        //  旋转后的新起点
        ListNode start = temp.next;
        ListNode pointer = start;
        //  把前一段截断
        end.next = null;

        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = head;
        return start;
    }
}
