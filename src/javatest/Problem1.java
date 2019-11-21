package javatest;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;++i) {
			nums[i] = s.nextInt();
		}
		int target = s.nextInt();
		int len = nums.length;
		for (int i = 0; i < len; ++i) {
			for (int j = i + 1; j < len; ++j) {
				if (nums[i] + nums[j] == target) {
					System.out.println(i+" "+j);
					return;
				}
			}
		}
	}
}
