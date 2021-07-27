package algorithm.chapter1.binarysearchtree;

/**
 * @author YangShaw
 * @date 2021/3/19 23:57
 */
public class No04isInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 遍历框架
     * @param root
     * @param target
     */
    public void BST(TreeNode root, int target) {
        if (root.val == target) {
            // do sth.
        }
        if (root.val < target) {
            BST(root.left, target);
        } else {
            BST(root.right, target);
        }
    }

    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        if (target < root.val) {
            return searchBST(root.left, target);
        } else {
            return searchBST(root.right, target);
        }
    }

    public TreeNode insert(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (target < root.val) {
            root.left = insert(root.left, target);
        } else {
            root.right = insert(root.right, target);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            // delete
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 从右节点中找到最小的节点
            TreeNode min = getMin(root.right);
            // 直接将当前节点替换为最小节点
            root.val = min.val;
            // 从右节点中删去最小的节点
            root.right = delete(root.right, min.val);
        }
        if (target < root.val) {
            root.left = delete(root.left, target);
        } else {
            root.right = delete(root.right, target);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
