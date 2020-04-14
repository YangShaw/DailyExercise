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
        //int[] sorted = nums.clone();
        //Arrays.sort(sorted);
        //int indexOfMin = 0;

        boolean flag = false;
        int i=0, j=0;
        for(i = n-1;i>0;--i){
            if(nums[i]>nums[i-1]){
                flag = true;
                for(j=n-1;j>=0;--j){
                    if(nums[j]>nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                break;
            }
        }

        //for(i=n-1;i>=0;--i){
        //    for(j=i-1;j>=0;--j){
        //        if(nums[j]<nums[i]){
        //            flag = true;
        //            break;
        //        }
        //    }
        //    if(flag){
        //        break;
        //    }

            //if(indexOfMin>=n || nums[i]==sorted[indexOfMin]){
            //    while(sorted[indexOfMin]==sorted[indexOfMin+1]){
            //        indexOfMin++;
            //    }
            //    indexOfMin++;
            //    continue;
            //} else {
            //    flag = true;
            //    for(j=i-1;j>=0;--j){
            //        if(nums[j]<nums[i]){
            //            break;
            //        }
            //    }
            //    break;
            //}
        //}

        //  没有更小的排列了
        if(!flag){
            Arrays.sort(nums);
            return;
        }

        //  i:较大的数字； j:较小的数字
        //System.out.println(i);
        //System.out.println(j);
        List<Integer> temp = new ArrayList<>();
        int pos = i;
        for( ;i<n;++i){
            temp.add(nums[i]);
        }
        Collections.sort(temp);
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
