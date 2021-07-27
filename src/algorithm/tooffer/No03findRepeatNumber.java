package algorithm.tooffer;

/**
 * @author YangShaw
 * @date 2021/4/13 23:35
 */
public class No03findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                res = nums[i];
            }
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a]= nums[b];
        nums[b] = temp;
    }
}
