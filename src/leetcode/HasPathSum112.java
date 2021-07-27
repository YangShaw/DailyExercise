package leetcode;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum112 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //自上而下的遍历，我为啥会想到自下而上。。多此一举
    public boolean hasPathSum2(TreeNode root, int sum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val == sum;
        }

        return hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum-root.val);
    }

    //自己写的方法，效率较低
    public boolean hasPathSum(TreeNode root, int sum){
        List<Integer> all = dfs(root, sum);
        if(all.contains(sum)){
            return true;
        }
        return false;
    }

    public List<Integer> dfs(TreeNode root, int sum){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> left = dfs(root.left, sum);
        List<Integer> right = dfs(root.right, sum);
        int val = root.val;
        //叶子节点
        if(left.size()==0 && right.size()==0){
            cur.add(val);
            return cur;
        }
        //原本写了剪枝的方法，但是测试用例中存在负数，所以不能用了
        for(int num:left){
            cur.add(val+num);
        }
        for(int num:right){
            cur.add(val+num);
        }
        return cur;
    }
}
