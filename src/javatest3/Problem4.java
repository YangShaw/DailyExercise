package javatest3;

import java.util.Scanner;

public class Problem4 {

    public static boolean isLegal(String num) {
        if ("0".equals(num)) {
            return true;
        }
        if (num.startsWith("0")) {
            return false;
        }
        int a = Integer.parseInt(num);
        if (a > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int length = input.length();
        if (length > 12) {
            System.out.println(0);
            return;
        }
        int space = length - 1;
        int count = 0;
        int il = space - 2;
        int jl = space - 1;

        for (int i = 1; i <= il; ++i) {
            if (i > 3) {
                System.out.println(count);
                return;
            }
            for (int j = i + 1; j <= jl; ++j) {
                if (j - i > 3) {
                    break;
                }
                for (int k = j + 1; k <= space; ++k) {
                    if (k - j > 3) {
                        break;
                    }
                    if (isLegal(input.substring(k)) &&
                            isLegal(input.substring(i, j)) &&
                            isLegal(input.substring(j, k)) && isLegal(input.substring(0, i))) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
