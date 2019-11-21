package leetcode;

import java.util.*;

public class Valid_Parentheses_20 {
	private static boolean isMatch(char a, char b) {
		if(a=='['&&b==']') {
			return true;
		} else if(a=='('&&b==')') {
			return true;
		} else if(a=='{'&&b=='}') {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		char[] array = s.toCharArray();
		int n = array.length;
		for(int i=0;i<n;++i) {
			if(array[i]=='['||array[i]=='('||array[i]=='{') {
				stack.push(array[i]);
			}else {
				if(!stack.isEmpty()) {
					char temp = stack.pop();	
					if(isMatch(temp, array[i])) {
						continue;
					} else {
						return false;
					}
				} else {
					return false;
				}
				
			}
		}
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()[]{}}"));
	}

}
