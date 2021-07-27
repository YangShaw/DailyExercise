package leetcode;

public class MaxProfit121 {

    public int maxProfit2(int[] prices){
        if(prices.length<=1){
            return 0;
        }
        int l = prices.length;
        int min = prices[0];
        int profit = 0;


        for(int i=1; i<l; ++i){
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

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
