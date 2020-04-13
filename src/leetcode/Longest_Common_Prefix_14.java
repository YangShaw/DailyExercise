package leetcode;

public class Longest_Common_Prefix_14 {

    //	����һ�ַ�����ܶ࣬����һ������ıȽϣ������ַ����бȽ�
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String start = strs[0];
        int startLength = start.length();
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < startLength; ++i) {
            char cur = start.charAt(i);
            int j = 0;
            for (j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
                    return sb.toString();
                }
            }
            if (j == strs.length) {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        boolean flag = true;
        while (!prefix.equals("")) {
            int len = prefix.length();
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < len || !strs[i].substring(0, len).equals(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return prefix;
            } else {
                prefix = prefix.substring(0, len - 1);
                flag = true;
            }
        }
        return "";

    }

    public static void main(String[] args) {
        String[] strs = {"carr", "car", "ca"};
        System.out.println(longestCommonPrefix(strs));
    }
}
