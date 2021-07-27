package leetcode;

import java.util.Arrays;

public class SortedArrayToBST108 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public TreeNode sortedArrayToBST2(int[] array){
        return solution(array, 0, array.length-1);
    }

    public TreeNode solution(int[] array, int left, int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = solution(array, left, mid-1);
        root.right = solution(array, mid+1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] array){
        int l = array.length;
        if(l == 0){
            return null;
        }
        if(l == 1){
            return new TreeNode(array[0]);
        }
        int mid = l/2;
        TreeNode root = new TreeNode(array[mid]);
        if(mid>0){
            int[] left = Arrays.copyOfRange(array, 0, mid);
            root.left = sortedArrayToBST(left);
        }
        if(mid<l-1){
            int[] right = Arrays.copyOfRange(array, mid+1, l);
            root.right = sortedArrayToBST(right);
        }
        return root;
    }

}
