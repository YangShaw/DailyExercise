package leetcode;

import java.util.*;

public class NextGreaterElements503 {

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!stack.empty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                result[i % n] = -1;
            } else {
                result[i % n] = stack.peek();
            }
            stack.push(nums[i % n]);
        }

        return result;
    }

    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = Integer.MIN_VALUE;
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            boolean flag = false;
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] < nums[j]) {
                    result[i] = nums[j];
                    flag = true;
                    break;
                } else if (result[j] > nums[i]) {
                    result[i] = result[j];
                    flag = true;
                    break;
                } else {
                    j++;
                }
            }

            if (!flag) {
                for (j = 0; j < i; j++) {
                    if (nums[i] < nums[j]) {
                        result[i] = nums[j];
                        flag = true;
                        break;
                    } else if (result[j] > nums[i]) {
                        result[i] = result[j];
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                result[i] = -1;
            }
        }
        return result;
    }
}
