package leetcodegrindingguide.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeSearch {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            // to leftest
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode temp = stack.pop();
            result.add(temp.val);
            cur = temp.right;
        }
        return result;
    }

    public List<Integer> morrisInorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        while (cur != null) {
            //判断是否有left
            if (cur.left != null) {
                TreeNode temp = cur.left;
                // 找到中序遍历中cur的前驱节点
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    // 还没有连接前驱和cur
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    // left访问完成，可以打印当前
                    result.add(cur.val);
                    cur = cur.right;
                }
            } else {
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        // 增加一个pre节点，用来确认访问cur的时候，是否cur的right已经被访问过
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            // 确认right孩子是否存在，若存在要判断是否被访问过
            if (cur.right == null || cur.right == pre) {
                pre = cur;
                result.add(cur.val);
                // 下一轮直接选栈顶元素，也就是cur的父亲节点
                cur = null;
            } else {
                // 当前节点要重新加入栈中
                stack.push(cur);
                cur = cur.right;
            }
        }
        return result;
    }
}
