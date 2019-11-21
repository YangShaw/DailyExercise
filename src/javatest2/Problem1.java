package javatest2;

import java.util.*;
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;++i) {
			array[i] = s.nextInt();
		}
		int target = s.nextInt();
		
		int start = 0;
		int end = 1;
		int sum = array[0];
		int count = 1;
		int min = n;
		boolean flag = false;
		while(start<end&&end<n) {
			while(sum<target&&end<n) {
				//	没超过大小，继续往后加
				sum = sum+array[end];
				end++;
				count++;
			} 
			while(sum>=target&&start<end){
//					超过了，看看前面能不能少一个
				flag = true;
				sum = sum-array[start];
				start++;
				count--;
			}
			int temp = count+1;
			if(temp<min) {
				min = temp;
			}

		}
		if(flag) {
			System.out.println(min);
		} else {
			System.out.println(0);
		}
//		

	}

}
