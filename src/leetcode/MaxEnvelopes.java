package leetcode;

import java.util.Arrays;

public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes){
        Arrays.sort(envelopes, (v1, v2) ->
                v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0]);
        int l = envelopes.length;
        int[] height = new int[l];
        for(int i = 0; i < l; ++i){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);

    }

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
