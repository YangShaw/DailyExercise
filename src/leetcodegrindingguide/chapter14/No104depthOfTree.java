package leetcodegrindingguide.chapter14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No104depthOfTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        return subDepth(root) != -1;
    }

    public int subDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = subDepth(root.left);
        int right = subDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxD;
    }

    public int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);
        maxD = Math.max(maxD, left + right);

        return Math.max(left, right) + 1;
    }

    // 两层递归的操作 很骚 也见过几次 很有意思
    // 不算当前节点，从左右节点往下进行各自为根的递归
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
                + pathSumStartWithRoot(root, targetSum);
    }

    // 从这个节点开始连续的往下寻找路径
    public int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == sum) {
            count++;
            return count;
        }

        count += pathSumStartWithRoot(root.left, sum - root.val);
        count += pathSumStartWithRoot(root.right, sum - root.val);
        return count;

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
