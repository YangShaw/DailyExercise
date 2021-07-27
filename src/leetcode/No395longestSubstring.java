package leetcode;

import java.util.HashMap;
import java.util.Map;

public class No395longestSubstring {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: map.keySet()) {
            if (map.get(c) < k) {
                int res = 0;
                String[] sArray = s.split(String.valueOf(c));
                for (String newS: sArray) {
                    res = Math.max(res, longestSubstring(newS, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
