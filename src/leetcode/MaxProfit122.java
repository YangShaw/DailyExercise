package leetcode;

import java.util.Scanner;

public class MaxProfit122 {

	public int maxProfit(int[] array) {
		
		int n = array.length;
		if(n==0) {
			return 0;
		}
		
		int start = array[0];
		int curMax = start;
		int count = 0;
		for(int i=1;i<n;++i) {
			if(array[i]>curMax) {
				//	还能继续持有
				curMax = array[i];
			} else {
				//	抛出前面的
				count = count+curMax-start;
				//	重新购买
				start = array[i];
				curMax = start;
			}
		}
		count = count+curMax-start;
		
		return count;
	}
}
