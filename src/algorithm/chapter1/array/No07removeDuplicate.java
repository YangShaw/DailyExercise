package algorithm.chapter1.array;

import java.util.Stack;

/**
 * @author YangShaw
 * @date 2021/4/5 1:24
 */
public class No07removeDuplicate {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] exist = new boolean[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : array) {
            count[c - 'a']--;
            // 不需要重复插入
            if (exist[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                exist[stack.peek() - 'a'] = false;
            }
            stack.push(c);
            exist[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
