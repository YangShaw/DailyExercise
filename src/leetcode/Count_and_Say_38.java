package leetcode;

public class Count_and_Say_38 {
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution2(n));
	}
	
	//	这个方法更快一些
	public static String solution2(int n) {
		if(n==1) {
			//	递归出口
			System.out.println("current is "+n+", and the result is 1");
			return "1";
		} else {
			String cur = solution2(n-1);
			StringBuilder sb = new StringBuilder("");
			char[] array = cur.toCharArray();
			int l = array.length;
			for(int i=0;i<l;) {
				char curChar = array[i];
				int j = i+1;
				while(j<l&&array[j]==curChar) {
					j++;
				}
				sb.append(Integer.toString(j-i));
				sb.append(curChar);
				i=j;
			}
			System.out.println("current is "+n+", and the result is "+sb.toString());
			return sb.toString();
		}
	}
	
	public static String solution(int n) {
		if(n==1) {
			return "1";
		} else {
			String cur = solution(n-1);
			StringBuilder sb = new StringBuilder("");
			char[] array = cur.toCharArray();
			int l=array.length, count=0, i, j;
			for(i=0;i<l;) {
				int val = Integer.parseInt(""+array[i]);
				count=1;
				for(j=i+1;j<l;++j) {
					if(Integer.parseInt(""+array[j])==val) {
						count++;
					} else {
						break;
					}
				}
				sb.append(Integer.toString(count));
				sb.append(Integer.toString(val));
				i=j;
			}
			return sb.toString();
		}
	}

}
