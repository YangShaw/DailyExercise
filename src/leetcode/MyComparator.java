package leetcode;

import java.util.*;

public class MyComparator implements Comparable<MyComparator>{

	private int x;
	private int y;
	public MyComparator(int x, int y) {
		this.x = x;
		this.y = y;
	
	}
	
	public Integer getx() {
		return x;
	}
	public Integer gety() {
		return y;
	}
	
	public String toString() {
		return this.x+"|"+this.y;
	}
	
	@Override
	public int compareTo(MyComparator o) {
		// TODO Auto-generated method stub
		if(this.x!=o.x)
			return -this.getx().compareTo(o.getx());
		else
			return -this.gety().compareTo(o.gety());
			
		
//		if(this.x>o.x)
//			return 1;
//		else if(this.x==o.x&&this.y>o.y) {
//			return 1;
//		} else {
//			return 0;
//		}
	}

	
	public static void main(String[] args) {
		MyComparator b = new MyComparator(3, 6);
		MyComparator a = new MyComparator(5, 7);
		MyComparator c = new MyComparator(3, 9);
		List<MyComparator> arr = new ArrayList<MyComparator>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		System.out.println(arr);
		Collections.sort(arr);
		System.out.println(arr);
	}
	
	class sortByMyClass implements Comparator<MyComparator>{
		

		@Override
		public int compare(MyComparator o1, MyComparator o2) {
			// TODO Auto-generated method stub
			MyComparator a = o1;
			MyComparator b = o2;
			if(a.x>b.x)
				return 1;
			else if(a.x==b.x&&a.y>b.y) {
				return 1;
			} else {
				return 0;
			}

		}

		
	}

}
