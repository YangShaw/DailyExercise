package algorithm.chapter1.binarytree;

/**
 * @author YangShaw
 * @date 2021/3/17 0:49
 */
public class No01invertTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
