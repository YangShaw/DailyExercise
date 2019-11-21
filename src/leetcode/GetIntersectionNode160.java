package leetcode;

//  题解中的思路，每个链表遍历到末尾后接续到另一个链表的头部；
//  这样如果两个链表有交点，一定会相遇。两个链表的长度差回被这样接续的方式抹平。因为A+B=B+A。
public class GetIntersectionNode160 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getInterSectionNode(ListNode headA, ListNode headB){
        ListNode pointA = headA;
        ListNode pointB = headB;
        if(pointA==null||pointB==null){
            return null;
        }
        boolean flagA = true;
        boolean flagB = true;
        while(pointA!=pointB){
            if(pointA!=null){
                pointA = pointA.next;
            } else if(flagA){
                flagA = false;
                pointA = headB;
            } else {
                return null;
            }
            if(pointB!=null){
                pointB = pointB.next;
            } else if(flagB){
                flagB = false;
                pointB = headA;
            } else {
                return null;
            }
        }
        return pointA;

    }
}
