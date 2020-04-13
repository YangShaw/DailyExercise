package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  回溯法例题
public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int currentSum = 0;

        //  排序，可以提前终止某一轮循环
        Arrays.sort(candidates);
        ArrayList<Integer> beChosen = new ArrayList<>();
        backTrack(result, beChosen, candidates, target, 0);
        return result;
    }

    public void backTrack(List<List<Integer>> result, ArrayList<Integer> beChosen, int[] candidates, int target, int start) {
        if (target == 0) {
            //  new一个新数组把当前beChosen放进去，类似的题目学到的方法
            result.add(new ArrayList<>(beChosen));
            return;
        }
        int n = candidates.length;
        for (int i = start; i < n; ++i) {
            //  不符合要求
            if (candidates[i] > target) {
                break;
            }
            //  增加之，进入下一层
            beChosen.add(candidates[i]);
            backTrack(result, beChosen, candidates, target - candidates[i], i);
            //  回溯回来后，删除进入回溯的那个元素
            beChosen.remove(beChosen.size() - 1);
        }
    }
}
