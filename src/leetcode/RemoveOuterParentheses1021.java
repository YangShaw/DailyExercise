package leetcode;

import java.util.*;

public class RemoveOuterParentheses1021 {

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder("");
        Stack<Character> stack = new Stack<Character>();

        char[] sArray = s.toCharArray();
        int head = 0;
        int tail = 0;
        for (int i = 0; i < sArray.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(sArray[i]);
                head = i;
            } else if (sArray[i] == '(') {
                stack.push('(');
            } else {
                //	����������ţ���ô��ջ����ȡ����һ������
                stack.pop();
            }

            //	��ʱ����ܳ�ջ���ˣ�����ǿ��ˣ�˵����һ��ԭ�������
            if (stack.isEmpty()) {
                tail = i;
                //	��ȡ��һ���ֵ��Ӵ�
                result.append(s.substring(head + 1, tail));
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
