package algorithm.tooffer;

/**
 * @author YangShaw
 * @date 2021/4/14 0:02
 */
public class No07buildTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return solve(preorder, inorder, 0, len, 0, len);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl >= pr || il >= ir) {
            return null;
        }
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
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
