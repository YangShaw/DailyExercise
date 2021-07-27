package algorithm.chapter1.array;

import java.util.*;

/**
 * 高效、随机的获取元素，需要使用数组作为底层元素
 * 保持数组的紧凑型，待删除的元素换到最后。这样需要一个哈希表来做映射。
 * @author YangShaw
 * @date 2021/4/4 22:07
 */
public class No06randomizedSet {

    /**
     * 710 黑名单随机数
     * 黑名单导致了物理离散，通过哈希表的映射来实现逻辑的紧凑。
     */
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int sz;
        public Solution(int n, int[] blacklist) {
            sz = n - blacklist.length;
            for (int i: blacklist) {
                map.put(i, -1);
            }

            int last = n - 1;
            for (int i: blacklist) {
                if (i >= sz) {
                    continue;
                }
                while (map.containsKey(last)) {
                    last--;
                }
                map.put(i, last);
                last--;
            }
        }

        public int pick() {
            Random random = new Random();
            int index = random.nextInt(sz);
            if (map.containsKey(index)) {
                return map.get(index);
            }
            return index;
        }
    }

    /**
     * 380 常数时间 随机集合
     */
    static class RandomizedSet {
        /** Initialize your data structure here. */
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            if (index == list.size() - 1) {
                // 直接删除
                list.remove(list.size() - 1);
                map.remove(val);
            } else {
                int lastEle = list.get(list.size() - 1);
                map.put(lastEle, index);
                map.remove(val);
                list.set(index, lastEle);
                list.remove(list.size() - 1);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int len = list.size();
            Random random = new Random();
            return list.get(random.nextInt(len));
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        set.getRandom();
        set.remove(1);
        set.insert(2);
        set.getRandom();
    }
}
