package algorithm.chapter1.binarysearchtree;

/**
 * 二叉累加树
 * @author YangShaw
 * @date 2021/3/19 21:51
 */
public class No02convertBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    int last = 0;
    public TreeNode convertBST(TreeNode root) {
        // 反向中序遍历, 相当于降序打印二叉树
        if (root == null) {
            return new TreeNode(0);
        }
        convertBST(root.right);
        root.val = root.val + last;
        last = root.val;
        convertBST(root.left);
        return root;
    }
}
