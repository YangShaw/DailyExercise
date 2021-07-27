package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum34 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        dfs(root, sum);
        return result;
    }

    public void dfs(TreeNode root, int sum){
        if(root==null){
            return;
        }
        path.add(root.val);
        int cur = sum-root.val;
        if(cur==0 && root.left==null && root.right==null){
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
        path.remove(path.size()-1);
    }
}
