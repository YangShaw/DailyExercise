package daily;

import java.util.Scanner;

public class Question1 {
	//3 5 -8 6 -3 4 -5 9
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;++i) {
			array[i] = s.nextInt();
		}
		
		int neg = -1;	//	负数的位置
		int sum = 0;
		int start = 0;
		int negsum = 0;
		for(int i=0;i<n;++i) {
			if(array[i]>0) {
				if(neg==-1) {
					// 	如果不需要考虑负数，那么直接加
					sum += array[i];
				} else {
					//	如果需要考虑负数
					negsum +=array[i];
					if(negsum>=0) {
						neg = -1;
						sum = sum+negsum;
//						System.out.println("抵消"+sum);
						negsum = 0;
					}
				}
			} else {
				neg = i;
				negsum+=array[i];
				if(negsum+sum<=0) {
					//	直接跳过前面所有的
					sum=0;
					//	从下一位开始计数
					start = i+1;
					neg = -1;
					negsum=0;
				} else if(negsum>=0) {
					neg = -1;
					sum = sum+negsum;
				}
			}
		}
		System.out.println(sum);
	}
}
