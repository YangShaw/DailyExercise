package algorithm.chapter3.tricks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/4/10 22:46
 */
public class No05missedAndRepeated {

    // 缺失1-n中的一个值
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res = res + i - nums[i];
        }
        return res;
    }

    // 使用异或来求缺失的1个值
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res = res ^ nums[i] ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4, 2};
        No05missedAndRepeated solve = new No05missedAndRepeated();
        System.out.println(solve.missingNumber2(nums));
    }

    // 缺失若干个数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 第一个位置（i=0)上要放1，否则交换
            // 如果目标位置的值和当前相等，就不用换了
            while (nums[i] != (i + 1) && nums[nums[i] - 1] != nums[i]) {
                // 把当前位的值放到他应该在的地方
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 第一个位置（i=0)上要放1，否则交换
            // 如果目标位置的值和当前相等，就不用换了
            while (nums[i] != (i + 1) && nums[nums[i] - 1] != nums[i]) {
                // 把当前位的值放到他应该在的地方
                swap(nums, i, nums[i] - 1);
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
            }
        }
        return res;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
