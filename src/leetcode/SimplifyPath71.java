package leetcode;

import java.util.*;

public class SimplifyPath71 {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] array = path.split("/");
        StringBuilder result = new StringBuilder("");
        for (String s : array) {
            if (s.equals(".") || s.equals("")) {
                //	��ʾ��ǰĿ¼������Ҫ����
                continue;
            } else if (s.equals("..")) {
                //	��ʾ��ת��һ��Ŀ¼����ôȡ����һ������ת����������ڸ�Ŀ¼�£�������ת
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        if (stack.empty()) {
            //	�������Ǹ�Ŀ¼����ô��Ҫ����һ��/����ʾ֮
            result.append("/");
        } else {
            for (String s : stack) {
                result.append("/");
                result.append(s);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }
}
