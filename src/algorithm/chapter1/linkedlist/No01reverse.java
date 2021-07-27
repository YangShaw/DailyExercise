package algorithm.chapter1.linkedlist;

/**
 * 递归方法翻转链表
 * @author YangShaw
 * @date 2021/3/13 23:41
 */


public class No01reverse {

    static class Node {
        Node next;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    public static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        head.next = node1;
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node newHead = reverse(head);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }

}
