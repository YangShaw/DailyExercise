package leetcode;
import java.util.*;
public class EvalRPN150 {
	
	public int evalRPN(String[] tokens) {
        
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for(String s : tokens) {
			if(s.equals("+")) {
				stack.push(stack.pop()+stack.pop());
			} else if(s.equals("-")) {
				stack.push(-stack.pop()+stack.pop());
			} else if(s.equals("*")) {
				stack.push(stack.pop()*stack.pop());
			} else if(s.equals("/")) {
				int temp = stack.pop();
				stack.push(stack.pop()/temp);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}

		result = stack.pop();
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
