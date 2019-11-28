package leetcode;

import java.util.ArrayList;

public class KthSmallest230 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    //  利用二叉搜索树的性质，
    public static ArrayList<Integer> list;
    public int kthSmallest(TreeNode root, int k){
       list = new ArrayList<>();
       inOrder(root);
       return list.get(k-1);
    }
    public void inOrder(TreeNode root){
        if(root.left!=null){
            inOrder(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            inOrder(root.right);
        }
    }
}
