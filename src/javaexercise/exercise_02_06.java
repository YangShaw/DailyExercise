package javaexercise;
import java.util.*;
public class exercise_02_06 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a number between 0 and 1000:");
		int n = s.nextInt();
		int result = 0;
		while(n!=0) {
			result += n%10;
			n = n/10;
		}
		System.out.println("The sum of the digits is "+result);
	}
}
