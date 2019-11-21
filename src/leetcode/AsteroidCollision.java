package leetcode;

import java.util.Stack;

public class AsteroidCollision {
	
	public int[] asteroidCollision(int[] array) {
		Stack<Integer> stack = new Stack<>();
		stack.add(array[0]);
		int n = array.length;
		for(int i=1;i<n;++i) {
			if(stack.empty() || array[i]*stack.peek()>0) {
				//	不会爆炸
				stack.push(array[i]);
			} else {
				//	会有爆炸
				while(!stack.empty() && Math.abs(array[i])>Math.abs(stack.peek())) {
					if(array[i]<0) {
						stack.pop();
					} else {
						break;
					}
				}
				if(!stack.empty()) {
					if(array[i]+stack.peek()==0) {
						stack.pop();
					}
				} else {
					stack.push(array[i]);
				}
						
			}

		}
		int[] result = new int[stack.size()];
		int i=result.length-1;
		while(!stack.empty()) {
			result[i--] = stack.pop();
		}
		return result;

    }

}
