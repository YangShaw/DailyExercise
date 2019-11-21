package leetcode;

public class Add_Binary_67 {

	
	public static String solution(String a, String b) {
		int na=a.length()-1;
		int nb=b.length()-1;
		int carry=0;
		StringBuilder sb = new StringBuilder();
		while(na>=0||nb>=0) {
			int n1=na>=0?Integer.parseInt(""+a.charAt(na)):0;
			int n2=nb>=0?Integer.parseInt(""+b.charAt(nb)):0;
			na--;
			nb--;
			int s1=n1==n2?0:1;
			int s2=s1==carry?0:1;
			if(n1==1&&n2==1)
				carry=1;
			else if(s1==1&&carry==1)
				carry=1;
			else
				carry=0;
			
			sb.append(s2);
		}
		if(carry==1)
			sb.append(1);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String a="100";
		String b="1";
		System.out.println(solution(a, b));
	}
}
