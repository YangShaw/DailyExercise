package leetcode;

public class Implement_Strstr_28 {
	
	public static int solution(String haystack, String needle) {
		for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) 
		    	  return i;	//	匹配完成
		      if (i + j == haystack.length()) 
		    	  return -1; //匹配失败
		      if (needle.charAt(j) != haystack.charAt(i + j)) 
		    	  break;	//	判断当前是否失配
		    }
		}
	}
	
	//	一定程度的暴力，但是做了优化可以提前终止
	public int strStr(String haystack, String needle) {
		char start = needle.charAt(0);
		int haystackLength = haystack.length();
		int needleLength = needle.length();
		for(int i=0;i<haystackLength;++i) {
			if(haystack.charAt(i)!=start) {
				//	首先找到开头匹配的部分
				continue;
			}
			if(i+needleLength>haystackLength) {
				//	剩余未匹配的长度已经不足了
				return -1;
			}
			int j;
			for(j=1;j<needleLength;++j) {
				if(needle.charAt(j)!=haystack.charAt(i+j)) {
					break;
				}
			}
			if(j==needleLength) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
