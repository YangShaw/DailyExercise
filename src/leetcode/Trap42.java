package leetcode;

public class Trap42 {

    // 按照列计算
    public static int trap2(int[] height){
        int len = height.length;
        if(len==0 || len==1){
            return 0;
        }
        //用来记录每个点左右两侧的最高值
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        int leftMin = height[0];
        for(int i=1;i<len;++i){
            left[i] = leftMin;
            leftMin = Math.max(leftMin, height[i]);
        }

        right[len-1] = -1;
        int rightMin = height[len-1];
        for(int i=len-1;i>=0;--i){
            right[i] = rightMin;
            rightMin = Math.max(rightMin, height[i]);
        }


        int result = 0;
        //计算每列的值
        for(int i=0;i<len;++i){
            int curMin = Math.min(left[i], right[i]);
            System.out.println(curMin);
            if(curMin>height[i]){
                result = result+curMin-height[i];
            }
        }
        return result;

    }

    // 按照行计算 自己的解法超时了
    public static int trap(int[] height) {
        int len = height.length;
        if(len==0 || len==1){
            return 0;
        }
        int maxH = height[0];
        int minH = height[0];
        //优化 还可以记录一个最小值
        for(int i=1;i<len;++i){
            maxH = Math.max(maxH, height[i]);
            minH = Math.min(minH, height[i]);
        }
        System.out.println(minH);
        System.out.println(maxH);
        //按照行计算
        //左右两侧的墙
        int left = -1;
        boolean hasWater = false;
        int sum = 0;
        for(int i=minH;i<=maxH;++i){
            for(int j=0;j<len;++j){
                //水的左边
                if(!hasWater && height[j]>i){
                    left = j;
                }
                //前面有墙才算有水
                if(height[j]<=i && left!=-1){
                    hasWater = true;
                }
                //水的右边
                if(hasWater && height[j]>i){
                    sum = sum + j-left-1;
                    hasWater = false;
                    left = j;
                }
            }
            System.out.println(sum);
            left = -1;
            hasWater = false;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {5,2,1,2,1,5};
        System.out.println(trap2(height));
    }
}
