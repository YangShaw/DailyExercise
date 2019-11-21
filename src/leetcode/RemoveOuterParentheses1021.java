package leetcode;

import java.util.*;
public class RemoveOuterParentheses1021 {

	public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder("");
        Stack<Character> stack = new Stack<Character>();
        
        char[] sArray = s.toCharArray();
        int head = 0;
        int tail = 0;
        for(int i=0;i<sArray.length;++i) {
        	if(stack.isEmpty()) {
        		stack.push(sArray[i]);
        		head = i;
        	} else if(sArray[i]=='(') {
        		stack.push('(');
        	} else {
        		//	如果是右括号，那么出栈，提取出这一对括号
        		stack.pop();
        	}
        	
        	//	这时候可能出栈完了，如果是空了，说明这一对原语结束了
        	if(stack.isEmpty()) {
        		tail = i;
        		//	提取这一部分的子串
        		result.append(s.substring(head+1, tail));
        	}
        	
        }
        System.out.println(result.toString());
        return result.toString();
    }
	public static void main(String[] args) {
		String s = "(()())((()))";
		removeOuterParentheses(s);
	}
	
}
