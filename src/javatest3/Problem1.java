package javatest3;

import java.util.Scanner;
import java.util.Stack;

public class Problem1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] pushed = new int[n];
        int[] poped = new int[n];

        for(int i=0;i<n;++i){
            pushed[i] = s.nextInt();
        }
        for(int i=0;i<n;++i){
            poped[i] = s.nextInt();
        }

        int curPop = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;++i){
            stack.push(pushed[i]);
            while(!stack.empty()&&stack.peek()==poped[curPop]){
                stack.pop();
                curPop++;
            }
        }
        if(stack.empty()){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
