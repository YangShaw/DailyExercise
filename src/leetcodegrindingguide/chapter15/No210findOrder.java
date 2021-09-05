package leetcodegrindingguide.chapter15;

import java.util.*;

public class No210findOrder {

    public static void main(String[] args) {
        int n = 2;
        int[][] pre = {{0, 1}, {1, 0}};
        No210findOrder solution = new No210findOrder();
        solution.findOrder(n, pre);
    }

    // 拓扑排序问题
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 记录每门课的入度
        int[] requests = new int[numCourses];
        // 记录每门课可以解放哪些课
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 记录入度为0的课程
       Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; ++i) {
            int[] curReq = prerequisites[i];
            // 前一个是被要求有前提的课程 后一个是前提课程
            int beRequested = curReq[0];
            int preCourse = curReq[1];
            requests[beRequested]++;
            map.putIfAbsent(preCourse, new HashSet<>());
            map.get(preCourse).add(beRequested);
        }

        for (int i = 0; i < numCourses; ++i) {
            System.out.println(requests[i]);
            if (requests[i] == 0) {
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            System.out.println("in queue");
            int course = queue.poll();
            result[index++] = course;
            if (map.containsKey(course)) {
                Set<Integer> canUnlock = map.get(course);
                for (Integer lockedCourse : canUnlock) {
                    requests[lockedCourse]--;
                    if (requests[lockedCourse] == 0) {
                        queue.add(lockedCourse);
                    }
                }
            }
        }
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }

    }
}
