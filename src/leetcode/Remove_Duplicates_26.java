package leetcode;

public class Remove_Duplicates_26 {
	
	public static int solution(int[] nums) {
		
		int n = nums.length;
		int count = 0;
		for(int i=0;i<n;) {
			int val = nums[i];
			
			//	不需要对原数组进行移动，直接把原数组完全重写一遍。防止移动数字的麻烦
			//	这个思路想到数据库中海量数据的增删改查等。有时候重新构建索引可能比修改索引更快
			nums[count] = val;
			++count;
			int j;
			for(j=i+1;j<n;j++) {
				if(nums[j]!=val)
					break;
			}
			i=j;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,2,2,3,4,5,5,6,7,8};
		System.out.println(solution(nums));
	}

}
