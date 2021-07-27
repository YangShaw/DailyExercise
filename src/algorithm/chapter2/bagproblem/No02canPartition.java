package algorithm.chapter2.bagproblem;

/**
 * @author YangShaw
 * @date 2021/4/19 15:24
 */
public class No02canPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        // 目标值
        sum = sum / 2;
        int n = nums.length;
        // dp[i][j]:在前i个数字中是否能凑出j
        // 1<=i<=n
        boolean[][] dp = new boolean[n+1][sum+1];
        // j=0 true 不用装
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        // i=0 false
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i-1] > j) {
                    // 只能不选
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 选中当前或者不选
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
