package leetcode;

import java.util.Arrays;

public class No300lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
