package javatest4;

import java.util.*;

public class Problem5 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>(10000);
        Map<Integer, Integer> map = new HashMap<>(10000);

        for(int i=0;i<n;++i){
            int num = s.nextInt();
            if(!map.containsKey(num)){
                //  不包含这个数字
                map.put(num, 1);
                list.add(num);
            } else {
                int size = map.get(num)+1;
                map.put(num, size);
            }
        }
        Collections.sort(list);
        for(Integer temp: list){
            int count = map.get(temp);
            System.out.println(temp+" "+count);
        }
    }
}
