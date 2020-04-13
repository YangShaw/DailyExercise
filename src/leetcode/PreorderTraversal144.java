package leetcode;

import java.util.*;

public class PreorderTraversal144 {

    //	�ô����ڸ�������һ�����Ľڵ㣬Ҳ�������ǲ���Ҫ��������

    //	Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//	 ����ʹ�þ�̬��ȫ�ֱ�������Ϊ�ڶ���������в��Ե�ʱ��ᱣ������
//	public static List<Integer> result = new LinkedList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }
        solution(root, result);
        return result;
    }

    //	�ǵݹ���ʽ
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);

            //	�������Ҫ�ж�һ���Ƿ�Ϊ�գ���Ϊ�����null��ѿյ����ݼ��뵽stack�У����¿�ָ���
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return result;
    }

    public void solution(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        list.add(cur.val);
        solution(cur.left, list);
        solution(cur.right, list);
    }

}
