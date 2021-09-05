package leetcodegrindingguide.chapter14;

public class binarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode cur = root;
        // pre是用来比较和前一个节点的大小，从而判断是否是二叉搜索树
        // 因为后面还要把节点的值进行交换，所以要存节点，而不是值
        TreeNode pre = null;

        while (cur != null) {
            //Morris中序遍历
            if (cur.left != null) {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    //第一次访问左边
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    //访问过一次左边 可以查看当前情况
                    if (pre != null && cur.val < pre.val) {
                        y = cur;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    // 每次只需要在访问下一个之前，将pre置为当前就可以了
                    pre = cur;
                    temp.right = null;
                    cur = cur.right;
                }
            } else {
                if (pre != null && cur.val < pre.val) {
                    y = cur;
                    if (x == null) {
                        x = pre;
                    }
                }
                pre = cur;
                cur = cur.right;
            }
        }

        int temp = x.val;
        x.val = y.val;
        y.val = temp;

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.val > high) {
            // 显然是当前和右边都需要抛弃
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;


    }

}
