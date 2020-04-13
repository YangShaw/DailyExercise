package leetcode;

import java.util.*;

public class InorderTraversal94 {

    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();

        if (root == null) {
            return result;
        }
        solution(root.left, result);
        result.add(root.val);
        solution(root.right, result);

        return result;
    }

    //	�ǵݹ��д��
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                //	һֱ������ƽ���һֱ���ҵ�Ҷ�ӽڵ�
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public void solution(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        solution(cur.left, list);
        list.add(cur.val);
        solution(cur.right, list);
    }

}
