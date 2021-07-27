package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak139 {

    //public boolean wordBreak(String s, List<String> wordDict){
    //    Set<String> wordDictSet = new HashSet<>(wordDict);
    //
    //    int length = wordDict.size()+1;
    //    boolean[] dp = new boolean[length];
    //
    //    dp[0] = true;
    //
    //    for (int i=1; i<length; ++i) {
    //        for (int j=0; j<i; ++j) {
    //            if(dp[j] && wordDictSet.contains(s.substring(j, i))){
    //                dp[i] = true;
    //                break;
    //            }
    //        }
    //    }
    //
    //
    //    return dp[length-1];
    //}

    public boolean wordBreak(String s, List<String> wordDict) {
        //  BFS解法
        int n = s.length();
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        //BFS就是遍历字符串的每个位置作为起点，首先从0号位开始
        queue.add(0);
        while(!queue.isEmpty()){
            int current = queue.remove();
            if(visited[current]==0){
                //  未访问过 BFS的不同分支可能在某个点上殊途同归，那就没有必要再重复计算了
                for(int end = current+1;end<=n;end++){
                    // end<=n，很关键，因为substring函数是左闭右开区间
                    if(wordDict.contains(s.substring(current, end))){
                        queue.add(end);
                        //  在包含当前子串的情况下才判断
                        if(end == n){
                            return true;
                        }
                    }
                }
            }
            visited[current]=1;
        }
        return false;
    }
}
