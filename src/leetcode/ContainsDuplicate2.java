package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] array, int k){
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;++i){
            if(!map.containsKey(array[i])){
                map.put(array[i], i);
            } else {
                int len = i-map.get(array[i]);
                if(len<=k){
                    return true;
                } else {
                    //  更新所在的位置
                    map.put(array[i], i);
                }
            }
        }
        return false;
    }
}
