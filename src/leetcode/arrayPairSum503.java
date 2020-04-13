package leetcode;

import java.util.*;

public class arrayPairSum503 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int l = nums.length;
        for (int i = 0; i < l; i = i + 2) {
            result += nums[i];
        }
        return result;
    }
}
