package leetcode;

import java.util.*;

/*
	这题的边界很容易出错，好好思考一下。
	下次如果再复习到这道题，要好好在捋一遍逻辑。

	三个数，就是固定一个，然后再用两数之和的解题思路。
	题练习的越多，思路越丰富，越灵活。
	用发展的眼光看自己。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        int lastIndex = nums.length - 2;    //	留出l和r指针的控件
        int lp, rp;
        for (int i = 0; i < lastIndex; ++i) {
            lp = i + 1;
            rp = nums.length - 1;

            if (nums[i] > 0) {
                //	由于数列有序，最小的元素大于零，则和不可能为零
                //	后面也不可能再有符合条件的三元组了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //	去重
                continue;
            }
            while (lp < rp) {
                //	固定起点，遍历lp和rp的所有组合方式
                int sum = nums[i] + nums[lp] + nums[rp];
                if (sum == 0) {
                    //	如果找到正确的一组
                    result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    //这里不能break，因为可能同一个nums[i]后面有多个匹配的二元组
                    //break;
                    //	*但是为了避免重复，又要对前后相同的数字进行判断
                    //	这里的两个while如果忘记了什么意思，画个图就理解了
                    while (lp < rp && nums[lp] == nums[lp + 1]) {
                        lp++;
                    }
                    while (lp < rp && nums[rp] == nums[rp - 1]) {
                        rp--;
                    }
                    //	while中跳过的都是重复的。因为sum==0的时候两头的元素都利用上了，还得顺延到下一个。
                    lp++;
                    rp--;
                } else if (sum > 0) {
                    rp--;
                } else {
                    lp++;
                }
            }
        }
        return result;
    }
}
