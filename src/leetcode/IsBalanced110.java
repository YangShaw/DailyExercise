package leetcode;

public class IsBalanced110 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }
    //平衡二叉树的含义不要理解错了，想到了那一年的期末考试
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        if(Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }

}
