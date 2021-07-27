package algorithm.chapter1.binarytree;

/**
 * @author YangShaw
 * @date 2021/3/18 18:47
 */
public class No02connectRight {

    class Node {
        Node left;
        Node right;
        Node next;
        int val;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectTwo(root.left, root.right);
        return root;
    }

    public void connectTwo(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        // 前序遍历位置
        left.next = right;

        connectTwo(left.left, left.right);
        connectTwo(right.left, right.right);
        connectTwo(left.right, right.left);

    }
}
