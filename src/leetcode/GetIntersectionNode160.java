package leetcode;

//  题解中的思路，每个链表遍历到末尾后接续到另一个链表的头部；
//  这样如果两个链表有交点，一定会相遇。两个链表的长度差会被这样接续的方式抹平。因为A+B=B+A。
public class GetIntersectionNode160 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getInterSectionNode2(ListNode headA, ListNode headB){
        if(headA==null || headB==null){
            return null;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;
        while(pointA!=pointB){
            pointA = pointA==null ? headB : pointA.next;
            pointB = pointB==null ? headA : pointB.next;
        }
        return pointA;
    }

    public ListNode getInterSectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        if (pointA == null || pointB == null) {
            return null;
        }
        while (pointA != pointB) {
            //pA和pB同时往后遍历
            if (pointA != null) {
                pointA = pointA.next;
            } else {
                //第一次遍历到末尾，pointA = null了，这时候指向headB，在顺着B遍历一次
                pointA = headB;
            }
            if (pointB != null) {
                pointB = pointB.next;
            } else {
                //第一次遍历到末尾，pointB = null了，这时候指向headA，再顺着A遍历一次
                pointB = headA;
            }
        }
        return pointA;

    }
}
