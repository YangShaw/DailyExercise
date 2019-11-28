package leetcode;

public class LowestCommonAncestor236 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    //  题解中给出的LCA解法
    //  递归的思想，很巧妙
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //  如果一直找到最底层都没找到，说明这一支子树里没有我们需要的节点
        if(root==null){
            return root;
        }
        //  只要在当前子树中找到了p或q，就返回之
        if(root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }
}
