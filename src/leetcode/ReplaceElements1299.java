package leetcode;

public class ReplaceElements1299 {

    public int[] replaceElement(int[] arr){
        int l = arr.length;
        int curMax = arr[l-1];
        int[] result = new int[l];
        result[l-1] = -1;
        for(int i=l-2;i>=0;--i){
            result[i] = curMax;
            curMax = Math.max(curMax, arr[i]);
        }
        return result;
    }

    public int[] replaceElement2(int[] arr){
        int l = arr.length;
        int curMax = arr[l-1];
        arr[l-1] = -1;
        for(int i=l-2;i>=0;--i){
            int temp = curMax;
            curMax = Math.max(curMax, arr[i]);
            arr[i] = temp;
        }
        return arr;

    }
}
