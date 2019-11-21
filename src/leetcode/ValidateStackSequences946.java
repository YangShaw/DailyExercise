package leetcode;

import java.util.*;
public class ValidateStackSequences946 {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
        
		//	存放pushed内容
		Stack<Integer> stack = new Stack<Integer>();
		//	定位popped内容的指针
		int j = 0;
		
		for(int i=0;i<pushed.length;++i) {
			stack.push(pushed[i]);
			while(!stack.empty()&&stack.peek()==popped[j]) {
				//	当栈顶元素和出栈序列最头上元素相同时，可以出栈
				stack.pop();
				j++;
			}
		}
		if(stack.empty()) {
			return true;
		}
		return false;
    }
}
