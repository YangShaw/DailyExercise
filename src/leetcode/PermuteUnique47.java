package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique47 {

    List<List<Integer>> result;
    int[] candidates;
    ArrayList<Integer> beChosen;

    public List<List<Integer>> permuteUnique(int[] nums){
        result = new ArrayList<>();

        candidates = nums;
        Arrays.sort(candidates);
        beChosen = new ArrayList<>();
        int[] visited = new int[candidates.length];
        backTrace(visited);
        return result;
    }

    private void backTrace(int visited[]){
        int n = candidates.length;
        if(beChosen.size()==n){
            result.add(new ArrayList<>(beChosen));
            return;
        }

        for(int i=0;i<n;++i){
            if(visited[i]==1){
                continue;
            }

            //  这一句是核心。最后一个条件很关键。
            if(i>0&&(candidates[i]==candidates[i-1]&&visited[i-1]==0)){
                continue;
            }

            visited[i]=1;
            beChosen.add(candidates[i]);
            backTrace(visited);
            beChosen.remove(beChosen.size()-1);
            visited[i]=0;
        }

    }
}
