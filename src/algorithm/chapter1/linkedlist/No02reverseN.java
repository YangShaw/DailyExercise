package algorithm.chapter1.linkedlist;

/**
 * 链表前N个数翻转
 * @author YangShaw
 * @date 2021/3/13 23:56
 */
public class No02reverseN {

    static class Node {
        Node next;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    // 尾部不需要调整的部分
    static Node tail = null;
    public static Node reverseN(Node head, int n) {
        Node last;
        if (n == 1) {
            // tail不是递归的，而是恒定在这个节点后面
            tail = head.next;
            return head;
        }

        last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

    static Node pre = null;
    public static Node reverseBetween(Node head, int m, int n) {
        if (m == 1) {
            // 退化到前一种情况
            return reverseN(head, n);
        }
        // 把当前的next接续到后面调转完的链上
        head.next = reverseBetween(head.next, m - 1, n);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        head.next = node1;
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        //Node newHead = reverseN(head, 2);
        Node newHead = reverseBetween(head, 2, 2);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }
}
