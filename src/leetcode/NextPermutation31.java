package leetcode;

import java.util.*;

public class NextPermutation31 {

    public static void nextPermutation(int[] nums){
        /*
        1 从最右面开始往左找，找到存在比他小的数
        2 将这个数移动到比他小的数前面
        3 这个数后面的数升序排列
        4 找不到这样的数，则全部升序排列
         */
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int indexOfMin = 0;
        boolean flag = false;
        int i,j=0;
        for(i=n-1;i>=0;--i){
            if(indexOfMin>=n || nums[i]==sorted[indexOfMin]){
                while(sorted[indexOfMin]==sorted[indexOfMin+1]){
                    indexOfMin++;
                }
                indexOfMin++;
                continue;
            } else {
                flag = true;
                for(j=i-1;j>=0;--j){
                    if(nums[j]<nums[i]){
                        break;
                    }
                }
                break;
            }
        }
        if(!flag){
            Arrays.sort(nums);
            return;
        }

        //  i:较大的数字； j:较小的数字
        System.out.println(i);
        System.out.println(j);
        List<Integer> temp = new ArrayList<>();
        int pos = j;
        for( ;j<n;++j){
            if(j!=i){
                System.out.println("add num" + nums[j]);
                temp.add(nums[j]);
            }
        }
        Collections.sort(temp);
        nums[pos] = nums[i];
        pos++;
        int start = 0;
        for(; pos<n;++pos){
            nums[pos] = temp.get(start);
            start++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        nextPermutation(nums);
        for(int i=0;i<nums.length;++i){
            System.out.print(nums[i]+" ");
        }
    }
}
