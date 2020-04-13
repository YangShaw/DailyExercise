package leetcode;

public class MinCostClimbingStairs746 {

    //	��̬�滮
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;    //	n>=2
        int[] result = new int[n + 1];    //	result[k]��Ӧ����cost[k]̨�׵Ĵ���

        result[0] = 0;
        result[1] = 0;
        for (int i = 2; i <= n; ++i) {
            //	����ÿһ��λ�õ�resultֵ
            //	����iλ�ã�Ҫô�Ǵ�i-1��������Ҫô�Ǵ�i-2��������
            //	result[i-1]������i-1�Ĵ��ۣ�cost[i-1]�Ǵ�i-1����iλ�õĴ��ۣ��������ȡ�
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }


        return result[n];

    }

}
