package javatest;

import java.util.Scanner;
import java.util.Stack;

public class Problem5_2 {
	public static void main(String[] args) {
		
		//	读取数据
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;++i) {
			nums[i] = s.nextInt();
		}
		
		//	初始化一个栈，用于倒序存储数组元素
		Stack<Integer> stack = new Stack<Integer>();
		//	先把数组末位元素压入栈中，减少一次循环
		stack.push(nums[n-1]);
		//	用min变量来保存构成2元序列的出栈元素中的最小值。
		int min = 0;
		//	用一个布尔变量来记录是否有符合条件的2元序列
		boolean flag = false;
		
		//	倒序遍历数组
		for(int i=n-2;i>=0;--i) {
			//	类似单调栈的思想，如果栈顶元素存在并且小于当前元素，就要将它出栈
			//	利用while，一直找到栈顶元素比当前元素大为止
			while(!stack.empty()&&nums[i]>=stack.peek()) {
				//	为了防止已经构成有效的3元序列的元素被弹出无法检测，所以出栈前先进行判断。
				//	因为入栈过程中已经确保了栈中元素自底向上是递减的，所以如果栈中已经有了不少于3个元素，
				//	那么这3个元素在数组中就构成了递增3元子序列，可以直接判定为true
				if(stack.size()>=3) {
					System.out.println("true");
					return;
				}
				//	如果栈中有2个元素构成有序序列，那么也要将它们保存下来，因为前面可能存在一个更小的元素
				//	可以和这2个元素构成3元序列。如果直接删除不记录一下，就会忽略掉这种情况。
				//	例如8 3 9 6 7这样的样例
				if(stack.size()==2) {
					//	只有2个元素的情况需要特殊判断，所以只保存较小的这一个(栈顶的)元素就可以。最小的存在min变量中
					int temp = stack.peek();
					if(!flag) {
						flag = true;
						min = temp;
					} else {
						if(temp<min) {
						min = temp;
						}
					}
					
				}
				//	栈顶元素出栈
				stack.pop();
			}
			//	判断一下当前元素能否和前面存在的2元序列组成3元序列
			if(nums[i]<min) {
				System.out.println("true");
				return;
			}
			//	当前元素入栈
			stack.push(nums[i]);
		}
		
		System.out.println("false");
	}
}
