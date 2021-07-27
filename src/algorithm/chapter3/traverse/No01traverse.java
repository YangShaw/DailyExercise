package algorithm.chapter3.traverse;

import java.util.LinkedList;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/4/7 23:18
 */
public class No01traverse {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        //backTrack(nums, track);
        int[] visited = new int[nums.length];
        backTrack2(nums, track, visited);
        return result;
    }

    private void backTrack2(int[] nums, List<Integer> track, int[] visited) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            // 前序
            track.add(nums[i]);
            visited[i] = 1;
            backTrack2(nums, track, visited);
            visited[i] = 0;
            track.remove(track.size() - 1);
        }
        return;
    }

    private void backTrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            // 前序
            track.add(num);
            backTrack(nums, track);
            track.remove(track.size() - 1);
        }
        return;
    }
}
