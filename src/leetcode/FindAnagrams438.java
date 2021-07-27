package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams438 {



    public List<Integer> findAnagrams(String s, String p){
        int len = p.length();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<len;++i){
            if(!map.containsKey(p.charAt(i))){
                map.put(p.charAt(i), 1);
            } else {
                map.put(p.charAt(i), map.get(p.charAt(i)+1));
            }
        }
        int n = s.length();
        int i=0;
        //标志前一个是否成功
        boolean flag = false;
        while(i<n){
            if(flag){
                //前一个成功了，那么只需要看下一位就可以
                if(s.charAt(i)==s.charAt(i-len)){
                    flag = true;
                    result.add(i-4+1);
                    i++;
                } else{
                    //如果下一位不相同
                    i = i-len+2;
                    flag = false;
                }
            } else {
                Map<Character, Integer> current = new HashMap<>(map);
                int j = i;
                for(;j<len+i;++j){
                    //不包含 则直接跳过
                    char cur = s.charAt(j);
                    if(!current.containsKey(cur)){
                        // 下一次直接从当前位置的后一个开始遍历
                        i = j+1;
                        flag = false;
                        break;
                    } else {
                        if(current.get(cur)==1){
                            current.remove(cur);
                        } else {
                            current.put(cur, current.get(cur)-1);
                        }
                    }
                }
                if(j==len+i){
                    //说明没有break，成功遍历完了，那么这一组就是正确的
                    result.add(i);
                    flag = true;
                    i = j;
                }
            }
        }
        return result;
    }
}
