package leetcode;

import java.util.Stack;

public class StockSpanner_901 {

    //	add cache
    public static Stack<Integer> stack;
    public static Stack<Integer> result;    //	��һ��ջ�洢��Ӧλ�õĸ���
    public static int lastCase;

    public StockSpanner_901() {
        stack = new Stack<Integer>();
        result = new Stack<Integer>();
        lastCase = 0;
    }

    public int next(int price) {
        if (price == lastCase) {
            int temp = result.peek();
            stack.push(price);
            result.push(temp);
            return temp;
        }

        //	�Ȱѵ�ǰԪ����ջ
        if (stack.empty() || price < stack.peek()) {
            //	ǰ��û��Ԫ�أ���ֻ����1
            stack.push(price);
            result.push(1);
            return 1;
        }

        int ans = 1;
        while (!stack.empty() && price >= stack.peek()) {
            stack.pop();
            ans = ans + result.pop();
        }
        stack.push(price);
        result.push(ans);

        return ans;
    }


}
