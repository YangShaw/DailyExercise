package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No448findDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            while (Math.abs(nums[i]) != Math.abs(nums[nums[i] - 1])) {
                int target = nums[i] - 1;
                swap(nums, i, target);
            }
        }
        for (int i = 1; i <= len; ++i) {
            if (nums[i] != i) {
                result.add(i);
            }
        }

        return result;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
