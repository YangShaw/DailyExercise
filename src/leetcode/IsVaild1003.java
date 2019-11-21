package leetcode;
import java.util.*;
public class IsVaild1003 {

	public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] sArray = s.toCharArray();
		for(char cur : sArray) {
			if(cur=='c') {
				if(!stack.empty()&&stack.pop()=='b') {
					if(!stack.empty()&&stack.pop()=='a') {
						continue;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				stack.push(cur);
			}
			
		}
		if(stack.empty()) {
			return true;
		}
		
		return false;
	}
}
