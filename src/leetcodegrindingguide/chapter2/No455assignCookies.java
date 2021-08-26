package leetcodegrindingguide.chapter2;

import java.util.Arrays;

public class No455assignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gp = 0;
        int sp = 0;
        int result = 0;
        while (gp < g.length && sp < s.length) {
            if (g[gp] <= s[sp]) {
                result++;
                gp++;
            }
            sp++;
        }

        return result;
    }
}
