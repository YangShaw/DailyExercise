package leetcodegrindingguide.chapter15;

import java.util.LinkedList;
import java.util.Queue;

public class No785isBipartitie {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if (n == 0) {
            return true;
        }

        int[] color = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        // 图中可能包含多个连通区域
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                queue.add(i);
                color[i] = 1;
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int[] neighs = graph[cur];
                for (int neigh : neighs) {
                    if (color[neigh] == 0) {
                        queue.add(neigh);
                        // 所有相邻的节点都应该被标记为相反的颜色
                        color[neigh] = color[cur] == 1 ? 2 : 1;
                    } else if (color[neigh] == color[cur]) {
                        // 如果出现一个不能满足这个需求的就说明达不到二分图的要求
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
