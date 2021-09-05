package freewheel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1 {

    class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode findFailNode(TreeNode root, int failId) {
        Queue<TreeNode> path = new LinkedList<>();
        path.add(root);
        int id = 0;
        // 找到目标出错节点
        while (!path.isEmpty()) {
            int size = path.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = path.poll();
                if (id == failId) {
                    return cur;
                }
                id++;
                if (cur.left != null) {
                    path.add(cur.left);
                }
                if (cur.right != null) {
                    path.add(cur.right);
                }
            }
        }
        return null;
    }
    
    public int GetMinTimeCost(TreeNode root, int failId, int[] timeCost) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;

        // 先找到目标节点
        TreeNode failNode = findFailNode(root, failId);
        if (failNode == null) {
            return 0;
        }
        queue.add(failNode);
        int index = failId;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                // 取出当前这一层所有的节点，找一个往下通知耗时最少的节点来下通知
                TreeNode cur = queue.poll();
                // 当前节点还能往下传递的时候，才有可能作为min
                boolean hasMore = false;
                if (cur.left != null) {
                    hasMore = true;
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    hasMore = true;
                    queue.add(cur.right);
                }

                if (hasMore) {
                    int cost = timeCost[index];
                    min = Math.min(min, cost);
                }
                // 但是索引不能错乱
                index++;
            }
            // 至少有一个需要往下通知的节点的时候，才累加result
            if (!queue.isEmpty()) {
                result += min;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    }
}
