package leetcode;

public class MaxProfit121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        int n = prices.length;
        for (int i = 0; i < n; ++i) {
            if (prices[i] < min) {
                //	��ʼ��һ��
                profit = profit > (max - min) ? profit : (max - min);
                min = prices[i];
                max = prices[i];

            } else if (prices[i] > max) {
                max = prices[i];
            }
        }
        profit = profit > (max - min) ? profit : (max - min);
        return profit;

    }

}
