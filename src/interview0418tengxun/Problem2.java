package interview0418tengxun;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author YangShaw
 * @date 2021/4/18 21:27
 */
public class Problem2 {

    static class Ad {
        // 初始值
        int ori;
        // 当前系数
        int xi;
        // 当前值
        int cur;
        // 序号
        int id;

        public Ad(int id, int ori, int xi) {
            this.id = id;
            this.ori = ori;
            this.xi = xi;
            this.cur = ori * xi;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Ad> queue = new PriorityQueue<>((a, b) -> {
            if (a.cur == b.cur) {
                return a.id - b.id;
            }
            return a.cur - b.cur;
        });

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        for (int i = 0; i < n; i++) {
            int ori = s.nextInt();
            queue.add(new Ad(i + 1, ori, 1));
        }
        for (int i = 0; i < k; i++) {
            Ad ad = queue.poll();
            System.out.println(ad.id);
            queue.add(new Ad(ad.id, ad.ori, ad.xi + 1));
        }
    }
}
