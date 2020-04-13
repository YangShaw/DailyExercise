package algexercise;

import java.util.Arrays;

public class Ch5_01 {

    //  回溯法 装载问题
    //  第九周p26
    public static int[] loading(int[] weights, int c1, int c2){
        Arrays.sort(weights);

        int currentGap = c1;
        int bestGap = c1;

        int n = weights.length;
        int i=0;
        //  记录当前解的情况
        int[] memo = new int[n];
        int[] result = new int[n];
        while(true){
            while(i<n){
                if(currentGap>=weights[i]){
                    System.out.println("gap "+currentGap);
                    System.out.println("pick up "+i);
                    memo[i] = 1;
                    currentGap -= weights[i];
                } else {
                    memo[i] = 0;
                }
                i++;
            }
            System.out.println("current loop stop");
            i--;
            if(currentGap<bestGap){
                System.arraycopy(memo, 0, result, 0, n);
                System.out.println("best "+currentGap);
                bestGap = currentGap;
            }
            //  回溯, 沿着右分支一直往上找（不装），直到出现一个左分支（装）
            while(i > 0 && memo[i]==0){
                i = i-1;
            }
            //  如果能找到一个左分支，把它改成不装，相当于从左子树变化到右子树，然后继续往下搜索
            if(memo[i]==1){
                memo[i]=0;
                //  装变到不装，空隙变大
                currentGap = currentGap + weights[i];
                //  往下搜索
                i = i+1;
            }
            //  如果一直找回了根节点，遍历完成，返回结果
            if(i==0){
                return result;
            }
        }
    }

    public static void main(String[] args) {
        int[] weights = {90,80,40,30,20,12,10};
        int c1 = 152;
        int c2 = 130;
        int[] result = loading(weights, c1, c2);
        for(int i : result){
            System.out.println(i);
        }
    }
}
