package leetcode;
import java.math.*;
public class Max_Subarray_53 {
	
	
	//	这种思路更简洁严谨，但是复杂度相似
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		int sum = 0;
		for(int num: nums) {
			if(sum>0) {
				sum = sum+num;
			} else {
				sum = num;
			}
			result = Math.max(sum, result);
		}
		return result;
	}
	
	public static int solution(int[] nums) {
		int n = nums.length;
		int i, j;
		int value=Integer.MIN_VALUE;
		for(i=0;i<n;) {
				//	i是一段子序列的开头。如果开头是负数，直接不用看了。
            if(nums[i]>value)	
            	value = nums[i];
			if(nums[i]<=0) {	//	
				++i;
				continue;
			}
		    int sum = nums[i];	//	从当前开始求和
            
			for(j=i+1;j<n;j++) {	//	从i的下一个位置开始找
				if(nums[j]+sum<=0) {	//	加这个还不如不加
					if(value<sum) {
						value = sum;	//	当前最大值。虽然这一波要跳过了，但是它前面的可能确实是最大的了。
					}
					i=j+1;
					break;	//	放弃这一波，从后面开始
				} 
				if(nums[j]<0) {
                    if(value<sum) {
                    	value = sum;	//	这个值是负数，那就先存一下，看看后面还会不会有更大的
                    }
					sum = sum+nums[j];
				} else {
					sum = sum+nums[j];
					if(sum>value) {
						value = sum;
					}
				}
			}
			if(j==n) return value;
		}
		return value;
	}
	public static void main(String[] args) {
		
		int nums[] = {1};
		System.out.println(solution(nums));
	}

}
