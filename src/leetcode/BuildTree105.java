package leetcode;

public class BuildTree105 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode buildTree105(int[] preorder, int[] inorder){
        int len = preorder.length;
        if(len==0){
            return null;
        }
        return solution(preorder, inorder, 0, len, 0, len);
    }

    public TreeNode solution(int[] preorder, int[] inorder, int pL, int pR, int iL, int iR){
        if(pL==pR){
            return null;
        }
        int rootVal = preorder[pL];
        TreeNode root = new TreeNode(rootVal);
        //从中序序列中找到根节点
        int divide = -1;
        for(int i=iL;i<iR;++i){
            if(inorder[i]==rootVal){
                divide = i;
                break;
            }
        }
        int leftCount = divide-iL;

        root.left = solution(preorder, inorder, pL+1, pL+1+leftCount, iL, divide);
        root.right = solution(preorder, inorder, pL+1+leftCount, pR, divide+1, iR);
        return root;
    }
}
