package algorithm.chapter2.bagproblem;

/**
 * @author YangShaw
 * @date 2021/4/19 16:04
 */
public class No03completeBag {

    // 完全背包 物品数量无限

    // lc 322 零钱兑换
    public int coinChange(int[] coins, int amount) {

        // 硬币是否能凑齐每一个amount
        // 遍历当前硬币面额，判断当前amount-硬币

        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        // base case
        // amount = 0，只需要0个硬币
        // coin不选，没法凑
        for (int i = 0; i <= amount; i++) {
            dp[i][0] = -1;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[j-1] > i) {
                    // 当前种类不起作用
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-coins[j-1]][j] + 1);
                }
            }
        }
        return dp[amount][n];
    }

    // 518
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }

    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i-1]) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
