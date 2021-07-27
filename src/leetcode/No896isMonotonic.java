package leetcode;

public class No896isMonotonic {

    public boolean isMonotonic(int[] a) {
        int len = a.length;
        if (len == 0 || len == 1) {
            return true;
        }
        int i = 1;
        while (i < len && a[i] == a[i-1]) {
            i++;
        }
        // 整个数组都相等
        if (i == len) {
            return true;
        }
        // 判断单调性
        if (a[i] > a[i - 1]) {
            i++;
            while (i < len) {
                if (a[i] < a[i - 1]) {
                    break;
                }
                i++;
            }
        } else {
            i++;
            while (i < len) {
                if (a[i] > a[i - 1]) {
                    break;
                }
                i++;
            }
        }
        if (i == len) {
            return true;
        }
        return false;
    }
}
