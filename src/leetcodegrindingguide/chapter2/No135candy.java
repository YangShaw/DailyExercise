package leetcodegrindingguide.chapter2;

import java.util.Arrays;

public class No135candy {

    /**
     * 贪心算法，满足条件要求左规则和右规则同时满足。
     * 左：右边的较大时，右边的加一
     * 右：左边的较大时，左边的加一
     * 从左往右的遍历满足左规则，从右往左的遍历满足右规则
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        for (int i = 0; i < n - 1; i++) {
            if (ratings[i+1] > ratings[i]) {
                candy[i+1] = candy[i] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candy[i-1] = Math.max(candy[i-1], candy[i] + 1);
            }
        }

        int result = 0;
        for (int i : candy) {
            result += i;
        }
        return result;
    }
}
