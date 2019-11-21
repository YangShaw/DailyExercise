package leetcode;

import java.util.*;

public class MyQueue232 {
	
	public static Stack<Integer> stackIn;
	public static Stack<Integer> stackOut;
	public static boolean isIn;

	 /** Initialize your data structure here. */
    public MyQueue232() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
        isIn = true;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(isIn) {
    		stackIn.push(x);
    	} else {
    		while(!stackOut.empty()) {
    			stackIn.push(stackOut.pop());
    		}
    		stackIn.push(x);
    		isIn = true;
    	}
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(!isIn) {
    		return stackOut.pop();
    	} else {
    		while(!stackIn.empty()) {
    			stackOut.push(stackIn.pop());
    		}
    		isIn = false;
    		return stackOut.pop();
    	}
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(!isIn) {
        	return stackOut.peek();
        } else {
        	while(!stackIn.empty()) {
    			stackOut.push(stackIn.pop());
    		}
    		isIn = false;
    		return stackOut.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackIn.empty()&&stackOut.empty()) {
        	return true;
        }
        return false;
    }
}
