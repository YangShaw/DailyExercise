package javatest;

import java.util.*;
public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;++i) {
			nums[i] = s.nextInt();
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(nums[n-1]);
		for(int i=n-2;i>=0;--i) {
			while(!stack.empty()&&nums[i]>=stack.peek()) {
				stack.pop();
			}
			stack.push(nums[i]);
			
			if(stack.size()>=3) {
				System.out.println("true");
				return;
			}
		}
		
		System.out.println("false");
		
	}

}
