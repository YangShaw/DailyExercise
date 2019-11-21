package leetcode;

import java.util.Arrays;

public class HeightChecker1051 {

	public static int heightChecker(int[] heights) {
		int result = 0;
		int l= heights.length;
		int[] start = heights.clone();
		Arrays.sort(heights);
		for(int i=0;i<l;++i) {
			if(heights[i]!=start[i]) {
				result++;
			}
		}
		
		
		return result;
	}
	public static void main(String[] args) {
		int[] s = {1,1,2,1,4,3};
		heightChecker(s);
	}
	
}
