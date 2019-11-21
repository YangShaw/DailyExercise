package leetcode;

public class DivisorGame1025 {
	
	public boolean solution(int n) {
		return n%2==0;
	}
	
	//	我感觉我写的代码很玄学，估计等到明天我自己就看不懂了。。
	//	递归的方法，时间复杂度太高
	
	public boolean divisorGame(int n) {
		
		if(n==1) {
			return false;
		}	
		return game(n, true);
		//	1一定可以整除
	}
	
	public boolean game(int n, boolean flag) {
		if(n==2) {
			//	会赢。如果flag=true，要求赢，那么这种情况会赢。
			return flag;
		}
		
		//	1一定可以整除
		//	选择1意味着过了一轮，那么后面的要求输才能是赢
		if(game(n-1, !flag)==flag) {
			return flag;
		} else {
			for(int i=2;i<n;++i) {
				if(n%i==0) {
					if(game(n-i, !flag)==flag) {
						return flag;
					}
				}
			}
		}
		return !flag;
	}

}
