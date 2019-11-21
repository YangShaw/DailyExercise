package leetcode;

public class Sqrt_69 {

	public static int solution(int x) {
		if(x==0) return 0;
		int left = 1, right = x/2+1;
		while(left+1<right) {
			int mid = (left+right)/2;	//	¶þ·Ö·¨
			if(mid>x/mid) right = mid;
			else if(mid<x/mid) left = mid;
			else return mid;
		}
		return left;
	}
}
