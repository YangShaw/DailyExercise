package algorithm.chapter1.binarytree;

import java.util.Arrays;

/**
 * @author YangShaw
 * @date 2021/3/18 20:19
 */
public class No04constructMaxTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        // 前序遍历
        // 先找到最大值，然后把数组分开，分别递归
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = max;

        if (index == 0) {
            root.left = null;
        } else {
            int[] lefts = Arrays.copyOfRange(nums, 0, index);
            root.left = constructMaximumBinaryTree(lefts);
        }

        if (index == nums.length - 1) {
            root.right = null;
        } else {
            int[] rights = Arrays.copyOfRange(nums, index + 1, nums.length);
            root.right = constructMaximumBinaryTree(rights);
        }
        return root;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        // 避免copy数组，通过传递索引的方式来置换
        return solve(nums, 0, nums.length);
    }

    public TreeNode solve(int[] nums, int start, int right) {
        if (start > right) {
            return null;
        }
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode();
        root.left = solve(nums, start, index);
        root.right = solve(nums, index + 1, right);
        return root;
    }
}
