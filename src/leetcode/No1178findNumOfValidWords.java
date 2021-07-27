package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No1178findNumOfValidWords {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String word: words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c: word.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                }
            }
        }

        int len = puzzles.length;
        List<Integer> answer = new ArrayList<>();
        return null;

    }
}
