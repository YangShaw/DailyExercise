package algorithm.chapter3.tricks;

/**
 * @author YangShaw
 * @date 2021/4/10 1:55
 */
public class No01bitMani {

    public static void main(String[] args) {
        // 异或判断是否异号
        int a1 = -1;
        int a2 = 3;
        boolean af = (a1 ^ a2) < 0;
        System.out.println(af);

        // 消除n的二进制表示中的最后一个1
        int n = 8;  // 1000
        System.out.println(n & (n - 1));    // 0000
    }

    // 判断是不是2的指数（二进制表示只有一个1）
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return ((n & (n - 1)) == 0);
    }

    // 用该技巧判断有多少个1
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
