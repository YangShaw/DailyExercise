package javaexercise;
import java.util.*;
public class exercise_03_08 {

	static final int COUNT = 3;	//	读取的整数个数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<COUNT;++i) {
			System.out.println("Enter number "+i+":");
			list.add(s.nextInt());
		}
		
		Collections.sort(list);
		System.out.print("Result after sorting: ");
		for(int c : list) {
			System.out.print(c+" ");
		}
		
		

	}

}
