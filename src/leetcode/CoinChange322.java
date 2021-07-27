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

    //动态规划
    public int coinChange(int[] coins, int amount) {

        int type = coins.length;
        int[] func = new int[amount + 1];
        func[0] = 0;
        // 对每个金额找出需要的最小的情况，并记录在dp数组func中
        for (int i = 1; i <= amount; ++i) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < type; ++j) {
                if (i - coins[j] >= 0) {
                    if (func[i - coins[j]] != Integer.MAX_VALUE) {
                        //比较当前的花费和前面的最优花费+1（加上当前面额）
                        cost = Math.min(cost, func[i - coins[j]] + 1);
                    }
                }
            }
            func[i] = cost;
        }
        return func[amount] == Integer.MAX_VALUE ? -1 : func[amount];
    }

}
