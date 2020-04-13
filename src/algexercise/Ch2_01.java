package algexercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
    锦标赛算法求第二大元素
 */
public class Ch2_01 {

    public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static int secondMax(Integer[] array){
        int n = array.length;

        while(n>1){
            ArrayList<Integer> next = new ArrayList<>();
            int i=0;

            for(;i<n-1;i=i+2){
                int a = Math.max(array[i], array[i+1]);
                int b = Math.min(array[i], array[i+1]);
                System.out.println(a+"\t"+b);

                next.add(a);
                if(map.containsKey(a)){
                    map.get(a).add(b);
                } else {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(b);
                    map.put(a, arrayList);
                }
            }
            if(i==(n-1)){
                next.add(array[i]);
                if(!map.containsKey(array[i])){
                    map.put(array[i], new ArrayList<>());
                }
            }
            //  更新n的值
            n = next.size();
            //  更新数组
            array = new Integer[n];
            array = next.toArray(array);
        }

        ArrayList<Integer> resultList = map.get(array[0]);
        Optional<Integer> opt = resultList.stream().max(Integer::compareTo);
        return opt.get();
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6};
        System.out.println(secondMax(array));
    }
}


