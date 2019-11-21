package leetcode;

import java.util.Arrays;

public class SingleNumber136 {

    //  标准解法，使用异或运算符，相同的元素异或后会变成0；异或符合交换律。
    public int singleNumber2(int[] nums){
        int result = nums[0];
        if(nums.length>1){
            for(int i=1;i<nums.length;++i){
                result = result^nums[i];
            }
        }
        return result;
    }

    //  排序解法，时间复杂度不符合要求，空间复杂度o(1)
    public int singleNumber(int[] nums){
        Arrays.sort(nums);
        if(nums.length==1){
            return nums[0];
        }
        int l = nums.length-1;
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        for(int i=1;i<l;++i){
            if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]) {
                return nums[i];
            }
        }
        return nums[l];
    }
}
