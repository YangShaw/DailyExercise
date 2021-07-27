package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    List<Integer> result = new ArrayList<>();

    //BFS
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; ++i){
                TreeNode cur = queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                if(i==size-1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }

    //DFS
    public List<Integer> rightSideView(TreeNode root){
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        //  新的一层
        if(depth == result.size()){
            result.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


}
