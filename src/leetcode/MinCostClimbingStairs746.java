package leetcode;

public class MinCostClimbingStairs746 {
	
	//	动态规划
	public int minCostClimbingStairs(int[] cost) {
		
		int n = cost.length;	//	n>=2
		int[] result = new int[n+1];	//	result[k]对应爬到cost[k]台阶的代价
		
		result[0] = 0;
		result[1] = 0;
		for(int i=2;i<=n;++i) {
			//	计算每一个位置的result值
			//	爬到i位置，要么是从i-1爬上来，要么是从i-2爬上来。
			//	result[i-1]是爬到i-1的代价，cost[i-1]是从i-1爬到i位置的代价；后面的类比。
			result[i] = Math.min(result[i-1]+cost[i-1], result[i-2]+cost[i-2]);
		}
		
		
		return result[n];
		
	}

}
