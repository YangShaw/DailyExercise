package leetcode;

public class Length_of_Last_Word_58 {
	
	//	这种方法速度更慢，说明可能是split的问题.也对，确实没必要进行split。
	public int lengthOfLastWord(String s) {
		String[] array = s.split(" ");
		int l = array.length;
		if(l==0) {
			return 0;
		}
		return array[l-1].length();
	}


	//	更新。之前我写的都是些啥玩意= =
	public static int solution(String s) {
		s = s.trim();
        int p = s.lastIndexOf(' ');
		int n = s.length();
		return n-p-1;
	}
	
	
}
