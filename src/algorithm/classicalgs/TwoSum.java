package algorithm.classicalgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/4/18 13:57
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3, 6, 1, 1, 5, 5, 5};
        twoSum(nums, 6);
    }

    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        return nSumTarget(nums, n, 0, target);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || size < n) {
            return result;
        }
        if (n == 2) {
            // 双指针两数之和的操作，只不过left从start开始
            int left = start, right = size - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int numl = nums[left];
                int numr = nums[right];
                if (sum < target) {
                    while (left < right && nums[left] == numl) {
                        // 跳过重复数字
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && nums[right] == numr) {
                        right--;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(numl);
                    temp.add(numr);
                    while (left < right && nums[left] == numl) {
                        left++;
                    }
                    while (left < right && nums[right] == numr) {
                        right++;
                    }
                }
            }
        } else {
            // 递归
            for (int i = start; i < size; i++) {
                List<List<Integer>> list = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> temp : list) {
                    // 还缺当前这一个值
                    temp.add(nums[i]);
                    result.add(temp);
                }
                while (i < size - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return result;
    }

    public static void twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int numl = nums[left];
            int numr = nums[right];
            if (sum < target) {
                while (left < right && nums[left] == numl) {
                    // 跳过重复数字
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == numr) {
                    right--;
                }
            } else {
                System.out.println(numl + " " + numr);
                while (left < right && nums[left] == numl) {
                    left++;
                }
                while (left < right && nums[right] == numr) {
                    right++;
                }
            }
        }
    }
}
