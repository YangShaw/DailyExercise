package leetcode;

public class Max_Area_11 {

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length-1;
		int result = -1;
		int lower = -1;
		while(left<right) {
			if(height[left]<height[right]) {
				lower=height[left];
				left++;
			} else {
				lower = height[right];
				right--;
			}
			int temp = lower*(right-left+1);
			if(temp>result) {
				result = temp;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] height= {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		
	}
}
