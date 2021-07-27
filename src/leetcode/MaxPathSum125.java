package leetcode;

public class MaxPathSum125 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxContribution(root);
        return maxSum;
    }

    public int maxContribution(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftC = Math.max(0, maxContribution(node.left));
        int rightC = Math.max(0, maxContribution(node.right));
        int curC = node.val+leftC+rightC;
        maxSum = Math.max(maxSum, curC);
        return node.val+ Math.max(leftC, rightC);
    }
}
