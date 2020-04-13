package algexercise;

import java.util.Stack;

public class bt01Knapsack {

    static class Node {
        int level;
        boolean isPut;
        int w;
        int v;

        Node(int level, boolean isPut, int w, int v) {
            this.level = level;
            this.isPut = isPut;
            this.w = w;
            this.v = v;
        }
    }

    public static int solution(int[] values, int[] weights, int capacity) {
        int[] result = null;
        if (values.length != weights.length) {
            return 0;
        }

        int n = values.length;
        result = new int[n];

        int count = 0;
        int sumWeight = 0;
        int maxValue = 0;

        //  助栈来进行前序遍历
        Stack<Node> stack = new Stack<Node>();
        //  右节点为0，左节点为1
        stack.push(new Node(0, false, 0, 0));
        stack.push(new Node(0, true, weights[0], values[0]));

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            int index = cur.level + 1;
            if (index < n) {
                //  先加入右节点，肯定不会超重，w和v不变
                stack.push(new Node(index, false, cur.w, cur.v));
                int newW = cur.w + weights[index];
                //  不超重才能加入
                if (newW <= capacity) {
                    stack.push(new Node(index, true, newW, cur.v + values[index]));
                } else {
                    maxValue = maxValue > cur.v ? maxValue : cur.v;
                }
            } else {
                //  找到了最下面一层，判断一下价值
                maxValue = maxValue > cur.v ? maxValue : cur.v;

            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = {3, 4, 5, 6};
        int[] weights = {2, 3, 4, 5};
        int capacity = 8;
        System.out.println(solution(values, weights, capacity));
    }
}
