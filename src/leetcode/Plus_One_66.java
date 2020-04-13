package leetcode;

public class Plus_One_66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] solution(int[] digits) {
        int n = digits.length;
        int i;
        for (i = n - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
        }

        if (i < 0) {
            int[] array = new int[n + 1];
            array[0] = 1;
            for (int j = 0; j < n; j++) {
                array[j + 1] = digits[j];
            }
            return array;

        } else {
            return digits;
        }

    }

}
