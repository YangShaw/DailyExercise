package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {
    public static List<String> letterCombination(String digits){
        if("".equals(digits)){
            return new ArrayList<>();
        }

        //  存储映射关系，0和1位没有内容
        List<String[]> func = new ArrayList<>();
        func.add(null);
        func.add(null);
        func.add(new String[]{"a", "b", "c"});
        func.add(new String[]{"d", "e", "f"});
        func.add(new String[]{"g", "h", "i"});
        func.add(new String[]{"j", "k", "l"});
        func.add(new String[]{"m", "n", "o"});
        func.add(new String[]{"p", "q", "r", "s"});
        func.add(new String[]{"t", "u", "v"});
        func.add(new String[]{"w", "x", "y", "z"});

        int n = digits.length();

        //  动态规划，dp数组
        List<String>[] dp = new ArrayList[n+1];
        //  相当于dp的初始值
        dp[0] = new ArrayList<>();
        dp[0].add("");
        //  遍历digits中的每一位数字
        for(int i=1;i<=n;++i){
            dp[i] = new ArrayList<>();
            //  -'0'的小技巧用来将char型数字来转换为对应的int
            int current = digits.charAt(i-1)-'0';
            //  前i-1位的所有可能性，存储在dp[i-1]中
            int preCount = dp[i-1].size();
            //  第i位的所有可能性
            int sufCount = func.get(current).length;
            //  双层循环，将前缀和后缀的所有可能组合进行遍历
            for(int j=0;j<preCount;++j){
                for(int k=0;k<sufCount;++k){
                    String str = dp[i-1].get(j) + func.get(current)[k];
                    dp[i].add(str);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String digits = "234";
        List<String> result = letterCombination(digits);
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i));
        }
    }
}
