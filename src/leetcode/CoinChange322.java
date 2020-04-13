package leetcode;

public class CoinChange322 {

    //	���϶��£����õݹ�
    //	���ֽⷨ����ȷ�ģ����Ǹ��Ӷ�̫��
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int type = coins.length;
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < type; ++i) {
            if (amount - coins[i] >= 0) {
                int temp = coinChange2(coins, amount - coins[i]) + 1;
                if (temp != 0) {
                    //	ȷ�����������н��
                    cost = Math.min(cost, temp);
                }
            }
        }

        return cost == Integer.MAX_VALUE ? -1 : cost;
    }

    //	�Ե����ϣ����ñ���¼��DP��������
    public int coinChange(int[] coins, int amount) {

        int type = coins.length;
        //	����������Ļ����Ƕ�amount���д�С���󻮷֣������Ƕ�coins������л���

        //	�洢amountȡ����ֵʱ������Ž�
        //	��func��Ϊ������������һ�㣬�������뵽f(n)�ĺ�����ʽ
        int[] func = new int[amount + 1];
        func[0] = 0;    //	��ֵ
        for (int i = 1; i <= amount; ++i) {
            //	����amount=k�ĸ���������������С����
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < type; ++j) {
                //	����ÿ�����
                if (i - coins[j] >= 0) {
                    //	������һöcoins[j]��ʱ��
                    if (func[i - coins[j]] != Integer.MAX_VALUE) {
                        //	��ֹ���
                        cost = Math.min(cost, func[i - coins[j]] + 1);
                    }
                }
            }

            func[i] = cost;
        }


        return func[amount] == Integer.MAX_VALUE ? -1 : func[amount];
    }

}
