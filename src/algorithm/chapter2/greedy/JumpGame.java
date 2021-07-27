package algorithm.chapter2.greedy;

/**
 * @author YangShaw
 * @date 2021/4/19 17:53
 */
public class JumpGame {

     public boolean canJump(int[] nums) {
         int n = nums.length;
         int farthest = 0;
         for (int i = 0; i < n-1; i++) {
             // 计算当前位置可能能到达的最远的位置，只要能覆盖当前的i，就说明可以往下走
             farthest = Math.max(farthest, i +nums[i]);
             if (farthest <= i) {
                 // 走不动了
                 return false;
             }
         }
         // 走到n就算成功
         return farthest >= n-1;
     }

     public int jump(int[] nums) {
         int n = nums.length;
         int end = 0;
         int farthest = 0;
         int count = 0;
         for (int i = 0; i < n; i++) {
             // 当前能到达的最远位置
             farthest = Math.max(farthest, nums[i]);
             // 如果当前走到了end，就算作一跳
             if (end == i) {
                 count++;
                 end = farthest;
             }
         }
         return count;
     }
}
