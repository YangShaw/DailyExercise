package leetcode;
import java.util.*;
public class StockSpanner901 {
	
	public static Stack<Integer> stack ;
	public static Stack<Integer> result;	//	另一个栈存储对应位置的个数
	public StockSpanner901() {
		stack = new Stack<Integer>();
		result = new Stack<Integer>();
	}
	
	public int next(int price) {
		//	先把当前元素入栈
		if(stack.empty()||price<stack.peek()) {
			//	前面没有元素，则只能是1
			stack.push(price);
			result.push(1);
			return 1;
		}
		
		int ans = 1;
		while(!stack.empty()&&price>=stack.peek()) {
			stack.pop();
			ans = ans+result.pop();
		}
		stack.push(price);
		result.push(ans);
		
		return ans;
	}

}
