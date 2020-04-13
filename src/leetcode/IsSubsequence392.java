package leetcode;

public class IsSubsequence392 {

    //	DP�Ľⷨ���ͽ̲��ϵ��������ƣ����Ǳ��Ǹ�����
    //	DP��������и��ӶȺܸߣ�������Ϊ����������Ϥһ�¡�
    public boolean isSubsequence2(String s, String t) {

        int sl = s.length();
        int tl = t.length();

        boolean[][] dp = new boolean[sl + 1][tl + 1];
        if (sl == 0) {
            return true;
        }
        if (sl > tl) {
            return false;
        }

        //	����ֵ
        for (int i = 0; i < tl; ++i) {
            dp[0][i] = true;
        }

        for (int i = 1; i < sl; ++i) {
            for (int j = 1; j < tl; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //	��ǰԪ����ͬ��˵����ǰλ�õ�Ԫ�ز�����ֹ���Ϊtrue���ϰ������Ե���ǰԪ�أ�����ǰ���
                    //	��ǰ����һ��������
                    dp[i][j] = dp[i - 1][j - 1];    //	s[i],t[j]λ�õ�Ԫ����ͬ������Խ������Ӱ��
                } else {
                    //	s[i],t[j]����ͬ��˵��t[j]���Ԫ��û���ˣ�ֱ��ȥ�����Ԫ��
                    //	����s[i]��û�еõ�ƥ�䣬����ֻ��t������ǰ�ƶ�1
                    //	�ж�s�ǲ���t�������У�����ֻ��t��ǰ����
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }


        return dp[sl][tl];
    }


    //	ʱ�临�Ӷ�ֻ�൱�ڱ�����һ��t��
    public boolean isSubsequence(String s, String t) {

        if (s.equals("")) {
            return true;
        }

        char[] sArray = s.toCharArray();
        int sl = sArray.length;

        char[] tArray = t.toCharArray();
        int tl = tArray.length;

        if (sl > tl) {
            return false;
        }

        int pointer = 0;
        boolean flag = false;
        int i;
        for (i = 0; i < sl; ++i) {
            flag = false;
            for (int j = pointer; j < tl; ++j) {
                if (tArray[j] == sArray[i]) {
                    pointer = j + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        if (i == sl && flag) {
            return true;
        }

        return false;
    }
}
