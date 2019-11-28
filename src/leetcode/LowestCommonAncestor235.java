package leetcode;



public class LowestCommonAncestor235 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if((pVal<=rootVal&&qVal>=rootVal) || (pVal>=rootVal&&qVal<=rootVal)){
            return root;
        }
        if(pVal<rootVal){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
