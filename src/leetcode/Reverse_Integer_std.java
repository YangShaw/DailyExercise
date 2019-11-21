package leetcode;

public class Reverse_Integer_std {
	
	public static int reverse(int x) {
		int rev = 0;
		while(x!=0) {
			int pop = x%10;	//	提取末位数字
			x = x/10;	//	删除末位数字
			if(rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10&&pop>7)) {
				return 0;
			}
			if(rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10&&pop<-8)) {
				return 0;
			}
			rev = rev*10+pop;
		}
		return rev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -2147483647;
		System.out.println(reverse(a));
	}

}
