package leetcode;

public class SortColors75 {

    public void sortColors(int[] nums){
        int n = nums.length;
        int a = 0, b = 0, c = 0;
        for(int i=0;i<n;++i){
            switch (nums[i]){
                case 0:
                    a++;
                    break;
                case 1:
                    b++;
                    break;
                case 2:
                    c++;
                    break;
            }
        }
        for(int i=0;i<a;++i){
            nums[i]=0;
        }
        for(int i=a;i<a+b;++i){
            nums[i]=1;
        }
        for(int i=a+b;i<a+b+c;++i){
            nums[i]=2;
        }
    }
}
