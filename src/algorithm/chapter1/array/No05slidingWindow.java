package algorithm.chapter1.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 双指针-滑动窗口
 * @author YangShaw
 * @date 2021/4/4 12:17
 */
public class No05slidingWindow {

    public void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            // 窗口右移（扩大）
            right++;
            // 窗口内数据更新

            // 输出窗口左右，debug

            // 判断是否需要收缩
            while (true) {
                // 缩小窗口 数据更新
            }
        }
    }

    /**
     * 76 最小覆盖子串
     */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 子串起始索引和长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char cur = s.charAt(right);
            // 窗口右移（扩大）
            right++;
            // 窗口内数据更新
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    // cur字符完整
                    valid++;
                }
            }
            // 输出窗口左右，debug
            System.out.println(left + ":" + right);
            System.out.println(valid);
            // 判断是否需要收缩，当有效字符=t中包含的所有字符的时候，可以收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 将被缩小的字符
                char last = s.charAt(left);
                // 左移
                left++;
                // 更新
                if (need.containsKey(last)) {
                    if (window.get(last).equals(need.get(last))) {
                        valid--;
                    }
                    window.put(last, window.get(last) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * 567 字符串的排列
     */
    public boolean checkInclusion(String s2, String s1) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] s2Arr = s2.toCharArray();
        for (char c : s2Arr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            right++;
            // 非正常因素直接略过, 清空前面所有的内容
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s2.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s1.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    /**
     * 438 字母异位词
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        int valid = 0;
        char[] pArr = p.toCharArray();
        for (char c : pArr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return result;
    }

    /**
     * 3 最长无重复子串
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
