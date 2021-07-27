package algorithm.chapter1.binarytree;

/**
 * @author YangShaw
 * @date 2021/3/18 23:32
 */
public class No05buildTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return solve(preorder, inorder, 0, len, 0, len);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl >= pr || il >= ir) {
            return null;
        }
        TreeNode root = new TreeNode();
        int rootVal = preorder[pl];
        int rootIndex = -1;
        root.val = rootVal;
        for (int i = il; i < ir; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 左子树长度
        int leftLen = rootIndex - il;
        // 右子树长度
        int rightLen = ir - rootIndex - 1;
        root.left = solve(preorder, inorder, pl + 1, pl + 1 + leftLen, il, rootIndex);
        root.right = solve(preorder, inorder, pl + 1 +leftLen, pr, rootIndex + 1, ir);
        return root;
    }
}
