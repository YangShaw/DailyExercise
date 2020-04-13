package leetcode;

public class CanWinNim {

    //  纯找规律的方法
    public boolean canWinNim2(int n) {
        return !(n % 4 == 0);
    }

    //  这种方法超出了内存限制
    public boolean canWinNim(int n) {
        boolean[] result = new boolean[n + 1];
        if (n < 4) {
            return true;
        }
        if (n == 4) {
            return false;
        }

        result[1] = result[2] = result[3] = true;
        result[4] = false;
        for (int i = 5; i < n; ++i) {
            if (result[i - 1] && result[i - 2] && result[i - 3]) {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }

        return result[n];
    }
}
