package leetcode;

public class CoinChange322 {
	
	//	自上而下，利用递归
	//	这种解法是正确的，但是复杂度太高
	public int coinChange2(int[] coins, int amount) {
		if(amount==0) {
			return 0;
		}
		
		int type = coins.length;
		int cost = Integer.MAX_VALUE;
		for(int i=0;i<type;++i) {
			if(amount-coins[i]>=0) {
				int temp = coinChange2(coins, amount-coins[i])+1;
				if(temp!=0) {
					//	确保子问题是有解的
					cost = Math.min(cost, temp);
				}
			}
		}
			
		return cost==Integer.MAX_VALUE?-1:cost;
	}
	
	//	自底向上，利用备忘录的DP，迭代法
	public int coinChange(int[] coins, int amount) {
		
		int type = coins.length;
		//	这里子问题的划分是对amount进行从小到大划分，而不是对coins数组进行划分
		
		//	存储amount取各个值时候的最优解
		//	用func作为变量名更生动一点，让我联想到f(n)的函数形式
		int[] func = new int[amount+1];
		func[0] = 0;	//	初值
		for(int i=1;i<=amount;++i) {
			//	遍历amount=k的各种情况，子问题从小到大
			int cost = Integer.MAX_VALUE;
			for(int j=0;j<type;++j) {
				//	遍历每种情况
				if(i-coins[j]>=0) {
					//	可以用一枚coins[j]的时候
					if(func[i-coins[j]]!=Integer.MAX_VALUE) {
						//	防止溢出
						cost = Math.min(cost, func[i-coins[j]]+1);
					}
				}
			}
			
			func[i] = cost;
		}
		
		
		return func[amount]==Integer.MAX_VALUE?-1 : func[amount];
	}

}
