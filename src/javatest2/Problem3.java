package javatest2;

import java.util.*;

public class Problem3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = s.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(array[0]);
        for (int i = 1; i < n; ++i) {
            if (stack.empty() || array[i] * stack.peek() > 0) {
                //	���ᱬը
                stack.push(array[i]);
            } else {
                //	���б�ը
                while (!stack.empty() && Math.abs(array[i]) > Math.abs(stack.peek())) {
                    if (array[i] < 0) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (!stack.empty()) {
                    if (array[i] + stack.peek() == 0) {
                        stack.pop();
                    }
                } else {
                    stack.push(array[i]);
                }

            }

        }
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        while (!temp.empty()) {
            System.out.print(temp.pop() + " ");
        }
    }
}
