package leetcode;

public class Two_Sum_1 {

	public static int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; ++i) {
			for (int j = i + 1; j < len; ++j) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}

		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 2, 7, 4, 11 };
		int target = 9;
		int results[] = twoSum(nums, target);
		System.out.println(results[0]);
		System.out.println(results[1]);
	}

}
