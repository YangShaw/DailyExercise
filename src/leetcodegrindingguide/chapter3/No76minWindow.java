package leetcodegrindingguide.chapter3;

import java.util.HashMap;
import java.util.Map;

public class No76minWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 当前窗口中满足要求的字符数
        int valid = 0;
        for (int i = 0; i < t.length(); ++i) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 窗口边界
        int right = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = -1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            while (valid == need.size()) {
                char lc = s.charAt(left);
                if (need.containsKey(lc)) {
                    if (window.get(c).equals(need.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }

                if (right - left < min) {
                    min = right - left;
                    start = left;
                }

                left++;

            }
        }
        return start == -1 ? "" : s.substring(start, start + min);
    }
}
