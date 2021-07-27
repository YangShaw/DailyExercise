package interview0418tengxun;

import java.util.*;

/**
 * @author YangShaw
 * @date 2021/4/18 20:27
 */
public class Problem3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[] time = new int[n];
            int[] value = new int[n];
            int[][] tuple = new int[n][2];
            // 根据时间限制对数据分组
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                time[j] = s.nextInt();
                map.putIfAbsent(time[j], new ArrayList<>());
            }
            for (int j = 0; j < n; j++) {
                value[j] = s.nextInt();
                map.get(time[j]).add(value[j]);
            }
            // 存放到tuple中的索引
            int index = 0;
            for (Integer limit : map.keySet()) {
                List<Integer> list = map.get(limit);
                // 降序排列list
                Collections.sort(list, (a, b) -> {
                    return b - a;
                });
                // 当前limit有多少个游戏
                int size = list.size();
                // 重置的时间从1开始
                int start = 1;
                if (limit > size) {
                    // 位置足够，不用从1开始
                    start = limit - size + 1;
                }
                // 开始重置
                int cur = 0;
                for (; start <= limit; start++) {
                    // 新时间
                    tuple[index][0] = start;
                    // value不变
                    tuple[index][1] = list.get(cur);
                    cur++;
                    index++;
                }
                // 剩下的放进去
                for (; cur < size; cur++) {
                    tuple[index][0] = limit;
                    tuple[index][1] = list.get(cur);
                    cur++;
                    index++;
                }
            }
            Arrays.sort(tuple, (a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });

            int res = 0;
            int ti = 1;
            for (int j = 0; j < n; j++) {
                // 当前位需要的时间
                int cur = tuple[j][0];
                // 时间有空余
                if (ti < cur) {
                    // 直接玩掉这个游戏
                    ti++;
                    // 跳到下一个游戏
                    continue;
                }
                // 时间刚好
                if (ti == cur) {
                    // 只能玩当前的游戏，然后跳过所有时间相同的游戏
                    ti++;
                    while (j+1 < n && tuple[j+1][0] == cur) {
                        // 当前时间没法完成
                        j++;
                        res += tuple[j][1];
                    }
                    continue;
                }
                if (ti > cur) {
                    // 时间不变，跳过所有当前的游戏
                    while (j+1 < n && tuple[j+1][0] == cur) {
                        // 当前时间没法完成
                        j++;
                        res += tuple[j][1];
                    }
                }
            }
            System.out.println(res);
        }
    }
}
