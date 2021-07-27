package algorithm.chapter3.traverse;

import java.util.*;

/**
 * @author YangShaw
 * @date 2021/4/9 17:15
 */
public class No03subset {

    HashSet<List<Integer>> result2 = new HashSet<>();

    // 回溯算法 求子集
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backTrack2(nums, track, 0);
        List<List<Integer>> result = new ArrayList<>(result2);
        return result;
    }

    public void backTrack2(int[] nums, List<Integer> track, int start) {
        List<Integer> list = new ArrayList<>(track);
        Collections.sort(list);
        result2.add(list);
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack2(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }


    List<List<Integer>> result = new ArrayList<>();

    // 回溯算法 求子集
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, track, 0);
        return result;
    }

    public void backTrack3(int[] nums, List<Integer> track, int start) {
        result.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }

    public void backTrack(int[] nums, List<Integer> track, int start) {
        result.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, track, i + 1);
            track.remove(track.size() - 1);
        }
    }



    // 递归算法
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, nums.length - 1);
        return result;
    }

    private void solve(int[] nums, int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            List<Integer> list2 = new ArrayList<>();
            list2.add(nums[n]);
            result.add(list2);
            return;
        }

        solve(nums, n - 1);
        int cur = nums[n];
        List<List<Integer>> temp = new ArrayList<>(result);
        temp.forEach(list -> {
            List<Integer> t = new ArrayList<>(list);
            t.add(cur);
            result.add(t);
        });
        return;
    }
}
