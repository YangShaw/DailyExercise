package leetcode;

import java.util.*;
public class PreorderTraversal144 {

	//	好处在于给定的是一个树的节点，也就是我们不需要构造树了
	
	 //	Definition for a binary tree node.
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
//	 不能使用静态的全局变量，因为在多个样例进行测试的时候会保留下来
//	public static List<Integer> result = new LinkedList<Integer>();
	 
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> result = new LinkedList<Integer>();
		if(root==null) {
			return result;
		}
		solution(root, result);
		return result;
	}
	
	//	非递归形式
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> result = new LinkedList<Integer>();
		if(root==null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()) {
			TreeNode cur = stack.pop();
			result.add(cur.val);
			
			//	这里必须要判断一下是否为空，因为如果是null会把空的内容加入到stack中，导致空指针错。
			if(cur.right!=null) {
				stack.push(cur.right);
			}
			if(cur.left!=null) {
				stack.push(cur.left);
			}
		}
		
		return result;
	}
	
	public void solution(TreeNode cur, List<Integer> list) {
		if(cur==null) {
			return;
		}
		list.add(cur.val);
		solution(cur.left, list);
		solution(cur.right, list);
	}
	
}
