package leetcode;

public class ReverseWords557 {

    public String reverseWords(String s) {

        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : array) {
            str = reverseString(str.toCharArray());
            sb.append(str + " ");
        }
        return sb.toString().trim();
    }

    public String reverseString(char[] s) {
        int length = s.length;
        int maxIndex = length - 1;
        for (int i = 0; i < length / 2; ++i) {
            char temp = s[i];
            s[i] = s[maxIndex - i];
            s[maxIndex - i] = temp;
        }
        return new String(s);
    }

}
