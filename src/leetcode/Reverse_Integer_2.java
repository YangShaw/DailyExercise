package leetcode;

import java.util.Stack;

public class Reverse_Integer_2 {

    public static int reverse(int x) {

        boolean flag = x < 0 ? true : false;

        String num = Integer.toString(Math.abs(x));
        System.out.println(num);
        Stack<Character> stack = new Stack<>();
        char nums[] = num.toCharArray();

        for (int i = 0; i < nums.length; ++i) {
            stack.push(nums[i]);
        }

        char top = stack.pop();
        while (top == 0) {

            top = stack.pop();
            continue;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(top);
            top = stack.pop();
        }
        sb.append(top);
        String res = sb.toString();
        if (flag) {
            res = "-" + res;
        }
        int result;
        try {
            result = Integer.parseInt(res);
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(reverse(x));
    }
}
