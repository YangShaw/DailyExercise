package algorithm.chapter1.binarytree;

/**
 * @author YangShaw
 * @date 2021/3/18 19:29
 */
public class No03flattenTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 将左右子树拉平
        flatten(root.left);
        flatten(root.right);
        // 后序遍历
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null) {
            return;
        }
        TreeNode temp = left;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
        root.right = left;
        root.left = null;
    }
}
