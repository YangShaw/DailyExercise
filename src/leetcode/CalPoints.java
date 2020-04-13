package leetcode;

import java.util.*;

public class CalPoints {

    public static int calPoints(String[] ops) {

        int result = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                int num = stack.peek();
                stack.push(num * 2);
            } else if (op.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.peek();
                stack.push(num1);
                stack.push(num1 + num2);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        for (int num : stack) {
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }
}
