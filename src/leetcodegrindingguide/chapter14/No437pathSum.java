package leetcodegrindingguide.chapter14;

import java.util.HashMap;
import java.util.Map;

public class No437pathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    Map<Integer, Integer> prefix;
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        prefix = new HashMap<>();
        target = targetSum;
        // 给每个节点本身单独形成一个路径的机会
        prefix.put(0, 1);
        return solution(root, 0);
    }

    public int solution(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        curSum += root.val;

        count += prefix.getOrDefault(curSum - target, 0);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);

        int left = solution(root.left, curSum);
        int right = solution(root.right, curSum);

        count = count + left + right;

        prefix.put(curSum, prefix.get(curSum) - 1);
        return count;

    }

}
