package leetcode;

public class LowestCommonAncestor236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //  题解中给出的LCA解法
    //  递归的思想，很巧妙
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //  如果一直找到最底层都没找到，说明这一支子树里没有我们需要的节点，返回空
        if (root == null) {
            return null;
        }
        //  只要在当前子树中找到了p或q，就返回之
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //若分别在左右子树中找到了相应的节点，说明p,q分别存在于左右两边，那么公共节点只能是祖先
        if (left != null && right != null) {
            return root;
        }
        //否则，就是p或q其中某个是另一个祖先的情况
        if (left != null) {
            return left;
        }
        return right;
    }
}
