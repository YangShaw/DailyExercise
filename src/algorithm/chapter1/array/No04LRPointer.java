package algorithm.chapter1.array;

/**
 * 双指针问题：左右指针
 * @author YangShaw
 * @date 2021/4/3 22:39
 */
public class No04LRPointer {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
