package algorithm.classicalgs;

/**
 * 股票买卖类问题
 * @author YangShaw
 * @date 2021/4/13 15:33
 */
public class MaxProfit {

    /** 每天对每种状态做选择
     *  选择：买入，卖出，无操作
     *  buy后才能sell，sell后才能buy，rest分为buy后和sell后两种
     *  buy的次数受k的限制
     *
     *  状态：天数，允许交易的次数，当前的持有状态（rest的状态）
     *
     *  三维数组：dp[i][k][0 / 1]，i<n, 共n * k *2中状态，直接穷举
     *
     *  状态转移：
     *  0：buy to 0, rest to 1
     *  1: sell to 0, rest to 1
     */

    // k = 1
    public int maxProfit(int[] prices) {
        // k = 0不合法
        // k = 1只有一种情况
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = - prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }
        return dp[n-1][0];
    }

    // k = 1
    public int maxProfitPlus(int[] prices) {
        // k = 0不合法
        // k = 1只有一种情况
        int n = prices.length;
        //int[][] dp = new int[n][2];
        int have = 0;
        int notHave = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                notHave = 0;
                have = - prices[i];
                //dp[0][0] = 0;
                //dp[0][1] = - prices[i];
                continue;
            }
            notHave = Math.max(notHave, have + prices[i]);
            have = Math.max(have, - prices[i]);
        }
        return notHave;
    }

    // k = inf
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, temp - prices[i]);
        }
        return dp0;
    }

    // k = 2
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        // k = 0时候的base
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        // i = 0时候的base
        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][2][0];
    }

    // k = inf, 冷冻期
    public int maxProfit4(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        int dpPre0 = 0; //  冷冻期一天，代表dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dpPre0 - prices[i]);
            dpPre0 = temp;
        }
        return dp0;
    }

    // k = inf, 含手续费
    public int maxProfit5(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, temp - prices[i] - fee);
        }
        return dp0;
    }

    // k = 任意
    public int maxProfit6(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][k+1][2];
        // i = 0, 填k
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = - prices[0];
        }
        // k = 0 填i
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];

    }
}
