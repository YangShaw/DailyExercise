package algexercise;

public class Ch3_02 {

    // dp exercise
    //  投资问题
    public static int maxValue(int[][] table){
        int money = table.length;
        int item = table[0].length;

        //  memo
        int[][] dp = new int[money][item];
        //  init
        for(int i=0;i<money;++i){
            dp[i][0] = table[i][0];
        }


        for(int i=1;i<item;++i){
            for(int j=0;j<money;++j){
                //  对钱进行分配
                for(int k=0;k<=j;++k){
                    int cur = dp[k][i-1]+table[j-k][i];
                    if(dp[j][i]<cur){
                        dp[j][i] = cur;
                    }
                }
            }
        }
        return dp[money-1][item-1];
    }

    public static void main(String[] args) {
        int[][] table = {
                {0,0,0,0},
                {11,0,2,20},
                {12,5,10,21},
                {13,10,30,22},
                {14,15,32,23},
                {15,20,40,24}
        };
        System.out.println(maxValue(table));
    }
}
