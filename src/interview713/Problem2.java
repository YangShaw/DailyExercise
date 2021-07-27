package interview713;

public class Problem2 {

    class TreeNode{
        int value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2){
        //各自是根节点的情况
        if(node1.parent==null){
            return node1;
        }
        if(node2.parent==null){
            return node2;
        }
        //查找根节点
        TreeNode root = node1.parent;
        while(root.parent!=null){
            root = root.parent;
        }
        return solution(root, node1, node2);
    }
    public TreeNode solution(TreeNode root, TreeNode node1, TreeNode node2){
        if(root==node1 || root==node2 ||root==null){
            return root;
        }
        TreeNode left = solution(root.left, node1, node2);
        TreeNode right = solution(root.right, node1, node2);
        //互在两侧的情况
        if(left!=null && right!=null){
            return root;
        }
        //在某一侧的情况
        if(left!=null){
            return left;
        } else {
            return right;
        }
    }
}
