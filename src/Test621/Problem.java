package Test621;

import java.util.Stack;

public class Problem {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
//        TreeNode n6 = new TreeNode(66);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        boolean result = new Problem().isBinarySearchTree(n4);
        System.out.println(result);
    }

    public boolean isBinarySearchTree(TreeNode root) {

        int lastVal = Integer.MIN_VALUE;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        // 最右边的节点还没添加到栈中，不能提前停止
        while (!stack.isEmpty() || cur != null) {
            // 访问左边
            while (cur != null) {
                stack.push(cur);
                // 找到最左边的节点
                cur = cur.left;
            }
            // 循环停止的条件，栈顶元素没有左孩子
            // 访问中间
            TreeNode node = stack.pop();
            if (node.val < lastVal) {
                return false;
            }
            lastVal = node.val;
            // 访问右边

            // 更新指针
            cur = node.right;
        }
        return true;
    }
}
