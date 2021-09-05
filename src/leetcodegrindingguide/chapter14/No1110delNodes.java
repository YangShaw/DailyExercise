package leetcodegrindingguide.chapter14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No1110delNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<TreeNode> result;
    List<Integer> deleteList;
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        result = new LinkedList<>();
        deleteList = new ArrayList<>(toDelete.length);
        for (int i : toDelete) {
            deleteList.add(i);
        }
        solution(root, null, true);
        if (!deleteList.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    public TreeNode solution2(TreeNode root) {
        if (root == null) {
            return root;
        }

        return null;
    }

    public void solution(TreeNode root, TreeNode parent, boolean isLeft) {
        if (root == null) {
            return;
        }

        solution(root.left, root, true);
        solution(root.right, root, false);

        if (deleteList.contains(root.val)) {
            // 如果当前节点需要被删掉，那么首先需要把它和parent节点断开
            if (parent != null) {
                // parent == null是root节点的情况
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            // 然后产生了两棵新树
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
        }
    }


}
