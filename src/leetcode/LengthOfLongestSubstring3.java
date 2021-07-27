package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {

    public int lenghtOfLongestSubstring(String s){
        int result = 0;
        int len = s.length();
        if(len==0){
            return result;
        }
        Set<Character> set = new HashSet<>();
        int right = -1;
        for(int i=0;i<len;++i){
            //每一轮都往后推一个，注意这里要删除的是前一个（因为i已经自增了）
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            //对每一轮，都找到无重复的位置
            while(right+1<len && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            //更新一下当前最大长度
            result = Math.max(result, right-i+1);
        }
        return result;
    }
}
