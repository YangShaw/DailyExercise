package algorithm.chapter1.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/3/19 1:02
 */
public class No6findDupSubtrees {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 1 描述自己所在的子树是什么样子-二叉树序列化
     * 2 怎么知道其他子树是什么样子来判断是否重复-借助全局数据结构
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return result;
    }

    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public String solve(TreeNode root) {
        if (root == null) {
            return "#";
        }

        //后序遍历，才能得到左右子树的结果，和当前的相加进行判断
        String left = solve(root.left);
        String right = solve(root.right);
        String current = left + "," + right + "," + root.val;

        map.put(current, map.getOrDefault(current, 0) + 1);
        if (map.get(current) == 2) {
            result.add(root);
        }
        return current;
    }
}
