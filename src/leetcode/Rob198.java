package leetcode;

public class Rob198 {

    public int Rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n + 1];
        //	��ֵ
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];

        for (int i = 2; i < n; ++i) {
            //	״̬ת�Ʒ���
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }


        return dp[n - 1];
    }

}
