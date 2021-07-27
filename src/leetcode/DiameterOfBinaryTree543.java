package leetcode;

public class DiameterOfBinaryTree543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    int result = 0;
    public int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        //后面的dfs计算的是节点个数，路径的话比节点少1
        return result-1;
    }

    //返回的是每一个节点的深度
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //判断路径的长度
        result = Math.max(result, left+right+1);
        //作为当前root节点的一部分记入下一段路径的长度
        return Math.max(left, right)+1;
    }
}
