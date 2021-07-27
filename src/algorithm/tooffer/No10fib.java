package algorithm.tooffer;

/**
 * @author YangShaw
 * @date 2021/4/14 0:12
 */
public class No10fib {

    public int fib(int n) {
        int dp0 = 0;
        int dp1 = 1;
        if (n == 0) {
            return dp0;
        }
        if (n == 1) {
            return dp1;
        }

        for (int i = 2; i <= n; i++) {
            int dp2 = (dp1 + dp0) % (1000000007);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp1;
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int dp0 = 1;
        int dp1 = 2;
        for (int i = 3; i <= n; i++) {
            int dp2 = (dp0 + dp1) % (1000000007);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp1;
    }
}
