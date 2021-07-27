package algorithm.chapter3.tricks;

/**
 * 阶乘问题
 * @author YangShaw
 * @date 2021/4/10 14:12
 */
public class No02factorial {

    public static void main(String[] args) {
        No02factorial solve = new No02factorial();
        int k = 0;
        System.out.println(solve.leftBound(k));
        System.out.println(solve.rightBound(k));
    }

    // 单调性 求=k的所有n的取值，那么就是要获取满足条件的n的左右边界
    public int preimageSizeFZF(int k) {
        int res = 0;
        return (int)(rightBound(k) - leftBound(k) + 1);
    }

    public long leftBound(int k) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            //System.out.println(mid);
            if (trailingZeroes(mid) == k) {
                right = mid;
            } else if (trailingZeroes(mid) < k) {
                System.out.println("变大");
                left = mid + 1;
            } else {
                System.out.println("变小");
                right = mid;
            }
        }
        return left;
    }

    public long rightBound(int k) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (trailingZeroes(mid) == k) {
                left = mid + 1;
            } else if (trailingZeroes(mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public long trailingZeroes(long n) {
        long res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
