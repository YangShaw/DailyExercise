package javaexercise;

import java.util.*;

public class exercise_07_05 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < 10; ++i) {
            int num = s.nextInt();
            if (!map.containsKey(num)) {
                map.put(num, 1);
                list.add(num);
            }
        }

        System.out.println("The num of distinct number is " + list.size());
        System.out.print("The distinct numbers are: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
