package leetcode;

import java.util.*;

public class ValidateStackSequences946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        //	���pushed����
        Stack<Integer> stack = new Stack<Integer>();
        //	��λpopped���ݵ�ָ��
        int j = 0;

        for (int i = 0; i < pushed.length; ++i) {
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek() == popped[j]) {
                //	��ջ��Ԫ�غͳ�ջ������ͷ��Ԫ����ͬʱ�����Գ�ջ
                stack.pop();
                j++;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
