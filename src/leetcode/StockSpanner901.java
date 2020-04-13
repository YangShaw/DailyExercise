package leetcode;

import java.util.*;

public class StockSpanner901 {

    public static Stack<Integer> stack;
    public static Stack<Integer> result;    //	��һ��ջ�洢��Ӧλ�õĸ���

    public StockSpanner901() {
        stack = new Stack<Integer>();
        result = new Stack<Integer>();
    }

    public int next(int price) {
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
