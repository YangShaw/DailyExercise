package leetcode;

public class IsSubsequence392 {

	//	DP的解法，和教材上的例子类似，但是比那个简化了
	//	DP在这道题中复杂度很高，但是作为练手了来熟悉一下。
	public boolean isSubsequence2(String s, String t) {
		
		int sl = s.length();
		int tl = t.length();
		
		boolean[][] dp = new boolean[sl+1][tl+1];
		if(sl==0) {
			return true;
		}
		if(sl>tl) {
			return false;
		}
		
		//	赋初值
		for(int i=0;i<tl;++i) {
			dp[0][i] = true;
		}
		
		for(int i=1;i<sl;++i) {
			for(int j=1;j<tl;++j) {
				if(s.charAt(i-1)==t.charAt(j-1)) {
					//	当前元素相同，说明当前位置的元素不是阻止结果为true的障碍。忽略掉当前元素，考察前面的
					//	往前推移一个子问题
					dp[i][j] = dp[i-1][j-1];	//	s[i],t[j]位置的元素相同，不会对结果产生影响
				} else {
					//	s[i],t[j]不相同，说明t[j]这个元素没用了，直接去掉这个元素
					//	但是s[i]还没有得到匹配，所以只有t可以往前移动1
					//	判断s是不是t的子序列，所以只能t往前推移
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		
		
		return dp[sl][tl];
	}
	
	
	//	时间复杂度只相当于遍历了一遍t。
	public boolean isSubsequence(String s, String t) {
		
		if(s.equals("")) {
			return true;
		}
		
		char[] sArray = s.toCharArray();
		int sl = sArray.length;
		
		char[] tArray = t.toCharArray();
		int tl = tArray.length;
		
		if(sl>tl){
			return false;
		}
		
		int pointer = 0;
		boolean flag = false;
		int i;
		for(i=0;i<sl;++i) {
			flag = false;
			for(int j=pointer;j<tl;++j) {
				if(tArray[j]==sArray[i]) {
					pointer = j+1;
					flag = true;
					break;
				}
			}
			if(!flag) {
				return false;
			}
		}
		if(i==sl&&flag) {
			return true;
		}
		
		return false;
	}
}
