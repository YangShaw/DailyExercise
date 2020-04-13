package algexercise;

public class Ch3_01 {

    //  DP练习
    //  leetcode 64题最小路径和

    public static int minPathSum(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];


        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                dp[i][j]=grid[i][j];
                if(i==0&&j==0){
                    continue;
                } else if(i==0){
                    dp[i][j] += dp[i][j-1];
                } else if(j==0){
                    dp[i][j] += dp[i-1][j];
                } else {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                }
                System.out.println(i+"\t"+j+"\t"+dp[i][j]);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
