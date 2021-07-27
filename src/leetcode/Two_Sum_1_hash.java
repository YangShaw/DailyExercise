package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1_hash {

    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int l = nums.length;
        int[] result = new int[2];
        for(int i=0; i<l; ++i){
            int wanted = target-nums[i];
            if(map.containsKey(wanted)){
                result[0] = i;
                result[1] = map.get(wanted);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);    //	key:nums[i],for that we wants to search key to find the value equals target minus another number.

        }
        for (int i = 0; i < nums.length; ++i) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
        }
        return null;
    }


    public static int[] compute(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int answer = target - num;
            if (map.containsKey(answer) && map.get(answer) != i) {
                return new int[]{i, map.get(answer)};
            }
        }

        return null;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int nums[] = {2, 7, 4, 11};
        int target = 9;
        int results[] = twoSum(nums, target);
        System.out.println(results[0]);
        System.out.println(results[1]);
    }

}
