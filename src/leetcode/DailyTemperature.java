package leetcode;

import java.util.*;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] t) {
        int[] result = new int[t.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = t.length - 1; i >= 0; --i) {
            while (!stack.empty() && stack.peek() <= t[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                result[i] = 0;
            } else {
                int target = stack.peek();
                int j = 0;
                for (j = i; j < t.length; ++j) {
                    if (t[j] == target) {
                        break;
                    }
                }
                result[i] = j - i;
            }
            stack.push(t[i]);
        }

        return result;
    }

    //	��һ��Сϸ�ڣ��������е������ȴ洢����ϣ������
    //	�洢��hash�����ٶȷ��������ˣ�Ϊʲô��
    public int[] dailyTemperatures2(int[] t) {
        int[] result = new int[t.length];
        Stack<Integer> stack = new Stack<Integer>();
        //	�����洢ÿ��ʱ���Ӧ��index
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < t.length; ++i) {
            int cur = t[i];
            if (map.containsKey(cur)) {
                map.get(cur).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(cur, list);
            }
        }

        for (int i = t.length - 1; i >= 0; --i) {
            while (!stack.empty() && stack.peek() <= t[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                result[i] = 0;
            } else {
                int target = stack.peek();
                int j = 0;
                List<Integer> list = map.get(target);
                for (int num : list) {
                    if (num > i) {
                        j = num;
                        break;
                    }
                }

                result[i] = j - i;
            }
            stack.push(t[i]);
        }

        return result;
    }


}
