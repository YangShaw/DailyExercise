package algorithm.chapter4;

/**
 * @author YangShaw
 * @date 2021/4/8 10:42
 */
public class No01palindrome {

    public String palindrome(String str, int left, int right) {
        int len = str.length() - 1;
        while (left >= 0 && right <= len && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        String result = "";
        for (int i = 0; i < len; i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i+1);
            result = result.length() > res1.length() ? result : res1;
            result = result.length() > res2.length() ? result : res2;
        }
        return result;
    }
}
