package leetcode;

import java.util.ArrayList;
import java.util.List;

//  回溯法的题目
public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[n];
        backTrack(result, nums, new ArrayList<Integer>(), visited);

        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums,
                           ArrayList<Integer> tmp, int[] visited) {
        //  找到最下面
        int n = nums.length;
        if (tmp.size() == n) {
            //  这里必须要new一个新的数组把tmp当前符合要求的情形拷贝进去。
            //  因为随后，tmp中的状态还会变化的。如果直接放tmp，放的是它本身，还会被修改。
            result.add(new ArrayList<>(tmp));
            return;
        }
        //  逐个往下找
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 1) {
                //  和已经进入序列的元素不重复
                continue;
            }
            tmp.add(nums[i]);
            visited[i] = 1;
            backTrack(result, nums, tmp, visited);
            //  选中当前元素的序列处理完了，下一轮重新选。
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}
