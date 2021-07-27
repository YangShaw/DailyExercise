package interview0411meituan;

import java.util.*;

/**
 * @author YangShaw
 * @date 2021/4/11 9:55
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] price = new int[n];
        Map<Integer, Integer> possible = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            price[i] = s.nextInt();
            if (price[i] == 0) {
                target.add(i);
            } else if (price[i] <= k) {
                pos.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (Integer po : pos) {
            int cur = 0;
            for (Integer t : target) {
                cur += Math.abs(t - po);
            }
            if (min > cur) {
                min = cur;
                index = po;
            }
        }
        System.out.println(index + 1);

    }
}
