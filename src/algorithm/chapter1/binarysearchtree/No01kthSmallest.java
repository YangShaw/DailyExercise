package algorithm.chapter1.binarysearchtree;

/**
 * @author YangShaw
 * @date 2021/3/19 19:02
 */
public class No01kthSmallest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int rank = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return result;
    }

    public void solve(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        solve(root.left, k);
        // 中序遍历二叉搜索树
        rank++;
        if (k == rank) {
            result = root.val;
            return;
        }
        solve(root.right, k);
    }
}
