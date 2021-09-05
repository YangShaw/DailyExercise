package leetcodegrindingguide.chapter7;

public class No198rob {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int prepre = 0;
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = Math.max(nums[i] + prepre, pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}
