package interview713;

public class Problem1 {

    class Node{
        int value;
        Node next;
    }

    public void reverseLinkList(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node cur = head.next;
        Node curNext = cur.next;
        Node pre = head;
        while(curNext!=null){
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        cur.next = pre;
        head.next = cur;
    }
}
