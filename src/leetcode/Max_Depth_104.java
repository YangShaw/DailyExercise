package leetcode;


public class Max_Depth_104 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static int solution(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(solution(root.left), solution(root.right));
    }
}
