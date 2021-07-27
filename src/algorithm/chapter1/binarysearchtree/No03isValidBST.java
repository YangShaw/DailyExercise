package algorithm.chapter1.binarysearchtree;

/**
 * @author YangShaw
 * @date 2021/3/19 22:11
 */
public class No03isValidBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        return solve(root, null, null);
    }

    public boolean solve(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (min != null && root.val >= min.val) {
            return false;
        }

        return solve(root.left, min, root) && solve(root.right, root, max);
    }


}
