package leetcode;

public class Same_Tree_100 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static boolean start(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return solution(p, q);
        }

    }

    public static boolean solution(TreeNode p, TreeNode q) {
        if (p.val != q.val) return false;

        boolean l = false, r = false;
        boolean flag1 = false, flag2 = false;

        if (p.left != null && q.left != null) {    //	��������
            flag1 = true;
            l = solution(p.left, q.left);
        }
        if (p.right != null && q.right != null) {    //	�����Һ���
            flag2 = true;
            r = solution(p.right, q.right);
        }

        if (flag1 || flag2) {
            if (flag1 && flag2) {
                if (l && r) return true;
                else return false;
            } else {
                if ((flag1 && l) || (flag2 && r)) {
                    return true;
                } else return false;
            }
        }

        if (p.left == null && p.right == null && q.left == null && q.right == null) {    //	��û�к���
            return true;
        } else {
            return false;
        }

    }
}
