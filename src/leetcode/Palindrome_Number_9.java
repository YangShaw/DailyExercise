package leetcode;

public class Palindrome_Number_9 {

    //	����������ȼ�࣬���Ǻ�ʱ�ϳ�
    public boolean isPalindrome3(int x) {
        return Integer.toString(x).equals(new StringBuilder(Integer.toString(x)).reverse().toString());
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int rev = 0;
        while (x > rev) {    //	��������������бȽϴ�С
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int input = x;

        int rev = 0;
        while (x != 0) {

            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return false;
            }
            rev = rev * 10 + pop;
        }
        if (rev == input) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 1357531122;
        System.out.println(isPalindrome(a));
    }

}
