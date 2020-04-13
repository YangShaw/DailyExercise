package leetcode;

import java.util.*;

public class PostorderTraversal145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }
        solution(root.left, result);
        solution(root.right, result);
        result.add(root.val);
        return result;
    }

    //	�ǵݹ�ķ���
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right != null) {
                //	�ұ߲��ǿյ�ʱ��Ҫ�ټӽ�ȥ
                stack.push(cur);
                stack.push(cur.right);
            } else {
                result.add(cur.val);
                cur = stack.pop();
            }
        }


        return result;
    }

    public void solution(TreeNode cur, List<Integer> list) {
        if (cur == null)
            return;
        if (cur.left != null) {
            solution(cur.left, list);
        }
        if (cur.right != null) {
            solution(cur.right, list);
        }
        list.add(cur.val);
    }

}
