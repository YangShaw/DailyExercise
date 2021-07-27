package algorithm.chapter3.tricks;

/**
 * @author YangShaw
 * @date 2021/4/10 16:58
 */
public class No03primes {

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        flag[2] = false;
        // 优化 sqrt i < n即可
        for (int i = 2; i * i < n; i++) {
            if (flag[i]) {
                // 素数才进行后续的遍历
                // 优化 j从i方开始考虑，太小的数已经被前面更小的i给遍历到了
                for (int j = i * i; j < n; j += i) {
                    flag[j] = false;
                }
            }
        }
        int res = 0;
        for (boolean b : flag) {
            if (b) res++;
        }
        return res;
    }
}
