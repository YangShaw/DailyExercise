package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int lastIndex = nums.length-2;
        int lp, rp;

        //  初始值
        int closerSum = nums[0]+nums[1]+nums[nums.length-1];
        int closer = Math.abs(target-closerSum);
        for(int i=0;i<lastIndex;++i){

            //  聪明反被聪明误，这一段的错误在于，target可能是负数，不一定是接下来连续三个元素最接近
            //  可能和再往后的正数相加抵消得到更接近target的和
            //if(nums[i]>target){
            //    //  当首个元素就大于target的时候，一定是接下来连续三个元素最接近。
            //    int sum = nums[i]+nums[i+1]+nums[i+2];
            //    int dis = Math.abs(target-sum);
            //    if(dis<closer){
            //        closer = dis;
            //        closerSum = sum;
            //    }
            //    continue;
            //}

            lp = i+1;
            rp = nums.length-1;
            while(lp<rp){
                int sum = nums[i]+nums[lp]+nums[rp];
                if(sum==target){
                    return target;
                }
                int dis = Math.abs(target-sum);
                //  如果差值更小，更新之
                if(dis<closer){
                    closer = dis;
                    closerSum = sum;
                }
                //  期望更加逼近target
                if(sum>target){
                   rp--;
                } else {
                    lp++;
                }
            }
        }
        return closerSum;
    }
}
