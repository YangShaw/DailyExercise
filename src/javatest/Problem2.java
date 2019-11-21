package javatest;

import java.util.*;
public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;++i) {
			nums[i] = s.nextInt();
		}
		
		int left = 0;
		int right = n-1;
		int result = 0;
		while(left<right) {
			int length = right-left;
			int area = 0;
			if(nums[left]<nums[right]) {
				area = length*nums[left];
				left++;
			} else {
				area = length*nums[right];
				right--;
			}
			
			if(area>result) {
				result = area;
			}
			
		}
		System.out.println(result);
	}

}
