package algorithm.chapter1.datastructure;

import java.util.Stack;

/**
 * @author YangShaw
 * @date 2021/3/29 23:18
 */
public class No10stackAndQueue {

    /**
     * 使用两个栈来实现队列
     */
    class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public MyQueue() {
            // 队尾栈
            s1 = new Stack<>();
            // 队头栈
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            peek();
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }
}
