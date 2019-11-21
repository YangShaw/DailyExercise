package leetcode;

import java.util.Stack;


/*
    使用一个辅助栈
    只需要在最小值被更新的时候记录到辅助栈中；
    在最小值被取出的时候从辅助栈中相应pop；
    其他时候，在辅助栈中重复一遍栈顶元素，用来作为占位符，确保两个栈的元素个数相同即可。
    我最开始的思路是列一个入栈元素的完整排序，纯属没必要。

 */
class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<Integer>();
        mins = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(mins.empty()||mins.peek()>=x){
            mins.push(x);
        } else {
            //  确保两个栈元素个数相同
            mins.push(mins.peek());
        }
    }

    public void pop() {
        if(!stack.empty()){
            stack.pop();
            mins.pop();
        }
    }

    public int top() {
        if(!stack.empty()){
            return stack.peek();
        }
        throw new RuntimeException();
    }

    public int getMin() {
        if(!mins.empty()){
            return mins.peek();
        }
        throw new RuntimeException();
    }
}
