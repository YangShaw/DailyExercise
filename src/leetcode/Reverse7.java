package leetcode;

public class Reverse7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String num = Integer.toString(x);
        StringBuilder result = new StringBuilder();
        boolean isNeg = false;
        //  判断正负号
        if (num.startsWith("-")) {
            isNeg = true;
            num = num.substring(1);
        }
        while (num.endsWith("0")) {
            num = num.substring(0, num.length() - 1);
        }

        for (int i = num.length() - 1; i >= 0; --i) {
            result.append(num.charAt(i));
        }
        long midRes = Long.parseLong(result.toString());
        if (midRes > Integer.MAX_VALUE || midRes < Integer.MIN_VALUE) {
            return 0;
        }
        int res = (int) midRes;

        return isNeg ? -res : res;

    }
}
