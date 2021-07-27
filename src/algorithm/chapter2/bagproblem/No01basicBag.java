package algorithm.chapter2.bagproblem;

/**
 * @author YangShaw
 * @date 2021/4/18 19:22
 */
public class No01basicBag {

    // 0-1背包问题
    // 每个物品只有一个
    public static int basicBag(int[] weight, int[] value) {
        int n = weight.length;
        // 状态：前i个物品，在j的重量下，是否选择
        int[][] dp = new int[n+1][n+1];
        // 0个物品，价值都是0
        // 0重量可用，价值都是0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // dp[i][j]表示j重量下，第i个物品是否要选
                // 若装不开，则一定不选
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 第i个物品对应的索引是i-1,所以它的重量是weight[i-1]，价值是value[i-1];
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        int[] weight = {2, 1, 3};
        int[] value = {4, 2, 3};
        System.out.println(basicBag(weight, value));
    }
}
