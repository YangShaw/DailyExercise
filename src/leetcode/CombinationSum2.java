package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    /*
    当你又泪如雨下
    就变成七月的模样
    我是腐烂了花期的凶手
    你是藏起花瓣的牧童

    你有一只步履轻盈的猫
    它的心逆流而上
    从此你把鲜艳的衣服穿上
    好像东京也是红墙绿瓦

    在盒子里睡着的美梦
    一打开就无影无踪
    睡醒的人哭着想回家
    可离家的人不会相信他

    请你也把我遗弃在远方
    让我承受那可怕的绝望
    当你终于感到了悲伤
    我再回来为你歌唱

    可是你不要像我一样
    把浮躁的生活当作成长
    到最后才看到珍贵的人
    流着眼泪 带着微笑

    在盒子里睡着的美梦
    一打开就无影无踪
    睡醒的人哭着想回家
    可离家的人不会相信他

    在大海上抽烟的人
    和你的卡比巴拉一起睡着
    当你疲倦的船回到家乡
    我还能否成为你的船长
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();

        //  排序是解题模式了
        Arrays.sort(candidates);
        ArrayList<Integer> beChosen = new ArrayList<>();
        backTrack(result, beChosen, candidates, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, ArrayList<Integer> beChosen,
                           int[] candidates, int target, int start){
        if(target==0){
            result.add(new ArrayList<>(beChosen));
            return;
        }
        int n = candidates.length;
        for(int i=start;i<n;++i){
            //  这一步是剪枝
            if(candidates[i]>target){
                break;
            }
            //  这一步也是剪枝，但更是去重。旨在，某一层中有连续相同元素是去掉。这一层的第一个和上一层相同不算重复。
            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }

            
            beChosen.add(candidates[i]);
            backTrack(result, beChosen, candidates, target-candidates[i], i+1);
            beChosen.remove(beChosen.size()-1);
        }
    }
}
