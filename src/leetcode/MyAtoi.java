//package leetcode;
//import java.math.*;
//public class MyAtoi {
//
//	public static int myAtoi(String str) {
//		str = str.trim();
//		if(str.equals("")) {
//			return 0;
//		}
//		boolean isNegative = false;
//		if(str.charAt(0)=='+') {
//			str = str.substring(1);
//		} else if(str.charAt(0)=='-') {
//			isNegative = true;
//			str = str.substring(1);
//		}
//		
//		//	去掉正负号后可能没有其他的了
//		if(str.equals("")) {
//			return 0;
//		}
//		
//		int result = 0;
//		long temp = -1;
//		BigInteger bi;
//		char[] array = str.toCharArray();
//		
//		StringBuilder sb = new StringBuilder("");
//		int start=0;
//		int end = 0;
////		System.out.println(array[0]);
//		
//		
//			
//		if(Character.isDigit(array[0])) {
//			// 必须以数字开头
////			System.out.println("come in");
//			start = 0;	
//			end = 1;
//			while(end<array.length&&Character.isDigit(array[end])) {
//				end++;
//			}
//		} else {
//			return 0;
//		}
////		System.out.println(start);
////		System.out.println(end);
//
//		
//		sb.append(str.subSequence(start, end));
//		
//		System.out.println(sb.toString());
//		bi = new BigInteger(sb.toString());
//		if(isNegative) {
//			bi = bi.multiply(new BigInteger("-1"));
//		}
//		System.out.println(bi);
//		
//		if(bi.compareTo(new BigInteger(""+Integer.MAX_VALUE))) {
//			result = Integer.MAX_VALUE;
//		} else if(temp<Integer.MIN_VALUE) {
//			result = Integer.MIN_VALUE;
//		} else {
//			result = (int)temp;
//		}
//		return result;
//	}
//	
//	public static void main(String[] args) {
//		String str = "-20000000000000000000";
//		System.out.println(myAtoi(str));
//	}
//}
