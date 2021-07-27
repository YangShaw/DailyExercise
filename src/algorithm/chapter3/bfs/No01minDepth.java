package algorithm.chapter3.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YangShaw
 * @date 2021/4/9 20:13
 */
public class No01minDepth {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
    public int minDepth(TreeNode root) {
        int min = Integer.MAX_VALUE;
        // core structure
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int depth = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 同层的一起搞，因为深度相同
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    // 叶子节点，算一次深度
                    if (min < depth) {
                        return min;
                    }
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            depth++;
        }
        return min;
    }
}
