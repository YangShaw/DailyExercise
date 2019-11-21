package javatest;

import java.util.Scanner;

public class Problem3_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums =new int[n];
		for(int i=0;i<n;++i) {
			nums[i] = s.nextInt();
		}
		
		int min = nums[0];
		int result = 0;
		
		for(int i=1;i<n;++i) {
			int temp = nums[i];
			if(temp<min) {
				min = temp;
			} else {
				int value = temp-min;
				if(value>result) {
					result = value;
				}
			}
		}
		System.out.println(result);
	}
}
