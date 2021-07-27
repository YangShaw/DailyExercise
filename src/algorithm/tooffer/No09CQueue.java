package algorithm.tooffer;

import java.util.Stack;

/**
 * @author YangShaw
 * @date 2021/4/14 0:09
 */
public class No09CQueue {

    class CQueue {
        // 存放
        Stack<Integer> s1 = new Stack<>();
        // 取出的时候作为转置
        Stack<Integer> s2 = new Stack<>();
        public CQueue() {

        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s1.isEmpty() && s2.isEmpty()) {
                return -1;
            }
            if (!s2.isEmpty()) {
                return s2.pop();
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
}
