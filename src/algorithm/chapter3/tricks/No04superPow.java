package algorithm.chapter3.tricks;

/**
 * @author YangShaw
 * @date 2021/4/10 17:16
 */
public class No04superPow {

    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    // mod运算技巧： (a*b)%k = (a%k)(b%k)%k 避免溢出
    public int superPow(int a, int[] b, int last) {
        if (last < 0) {
            return 1;
        }
        int cur = b[last];
        last--;
        int part1 = pow(a, cur);
        int part2 = pow(superPow(a, b, last), 10);
        return (part1 * part2) % base;
    }

    int base = 1337;
    int pow2(int a, int k) {
        // 对因子求mod
        a = a % base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * a;
            res = res % base;
        }
        return res;
    }

    // 另一种化简求幂的方式
    int pow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a %= base;
        if (k % 2 == 1) {
            return (a * pow(a, k - 1)) % base;
        } else {
            int sub = pow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
