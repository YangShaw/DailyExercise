package leetcode;

/*
    DP算法
    方程：dp[i][j] = dp[i-1][j]+dp[i][j-1]
    初值：i/j任一为1时，只有一条路径，dp值为1.

 */

import java.util.Arrays;

public class UniquePaths62 {

    //  优化到空间复杂度o(n)
    //  没看懂 貌似是杨辉三角？
    public int uniquePaths2(int m, int n){
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    public int uniquePaths(int m, int n){
        int down = m;
        int right = n;
        if(down==1||right==1){
            return 1;
        }

        int[][] result = new int[down+1][right+1];
        for(int i=1;i<down+1;++i){
            result[i][1] = 1;
        }
        for(int i=1;i<right+1;++i){
            result[1][i] = 1;
        }
        for(int i=2;i<down+1;++i){
            for(int j=2;j<right+1;++j){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[down][right];
    }
}
