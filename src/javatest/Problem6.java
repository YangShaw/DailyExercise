package javatest;

import java.util.*;
public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;++i) {
			nums[i] = s.nextInt();
		}
		int target = s.nextInt();
		
		int length = 0;
		for(int i=0;i<n;++i) {
			int temp = nums[i];
			int j = i+1;
			while(temp<target&&j<n) {
				temp = temp+nums[j];
				j++;
			}
			if(temp==target) {
				length = length>(j-i)?length:j-i;
				
			}
		}
		System.out.println(length);
		
	}

}
