package leetcode;
import java.util.*;

public class Symmetric_Tree_101 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
		
	}
	
	public static boolean solution(TreeNode root) {
		if(root==null) return true;
		int[] array=new int[1024];
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int count=0;
		queue.add(root);
		array[count]=root.val;
		count++;
		while(!queue.isEmpty()) {
			TreeNode cur=queue.remove();
			if(cur.left!=null) {
				queue.add(cur.left);
				array[count]=cur.left.val;
				count++;
			} else {
			}
		}
		
		return true;
		
		
	}
}
