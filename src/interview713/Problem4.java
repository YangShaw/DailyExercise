package interview713;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    public int[] solution(int[] array, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int n = array.length;
        for(int i=0;i<n;++i){
            map.put(array[i], i);
            int num = target-array[i];
            if(map.containsKey(num)){
                result[0] = map.get(array[i]);
                result[1] = map.get(num);
                return result;
            }
        }
        return null;
    }
}
