package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Daily1 {
	public static void main(String[] args) {
		String strarray = "hello world";
		String[] arrays = strarray.split(" ");

		String str = "hello";
		char[] ca = str.toCharArray();
		String castr = String.valueOf(ca);
		String castr2 = new String(ca);
		System.out.println(ca);
		System.out.println(castr);
		System.out.println(castr2);


		int[] array = {1,2,3,4,5};
		array = new int[array.length+1];
		array[0] = 0;
		for(int i : array) {
			System.out.println(i);
		}

		System.out.println("------------------------");
//		char a = '4';
//		int n=0;
//		System.out.println(Integer.parseInt(""+a));
//		Character.digit(a, n);
//		System.out.println(n);
//		String b = "a   ";
//		System.out.println(b.toCharArray().length);
//		System.out.println(b.lastIndexOf(' '));
		StringBuffer sb = new StringBuffer("abcde");
		sb = sb.deleteCharAt(3);
		System.out.println(sb);
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++)
			list.add(i);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(3);
		System.out.println(list);
		Map<Integer, Integer> map = new HashMap<>();
		
		for(Integer i : list) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		System.out.println(map.values());
		List<Integer> temp = new ArrayList<>();
		for(Integer i :map.keySet()){
			temp.add(i);
		}
		System.out.println(temp);
		
//		for(int i=0;i<list.size();++i) {
//			int cur = list.get(i);
//			int count = 1;
			
			
			
//			for(int j=i+1;j<list.size();++j) {
////				System.out.println(list.size());
//				int another = list.get(j);
//				if(cur==another) {
//					count++;
//					list.remove(j);
//					System.out.println("this moment we remove "+j);
//				}
//			}
//			System.out.println("count of "+i+" is "+count);
//		}
	}

}
