package algorithm.chapter1.datastructure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author YangShaw
 * @date 2021/3/28 16:19
 */
public class No05LFU {

    Map<Integer, Integer> keyToVal;

    Map<Integer, Integer> keyToFreq;

    Map<Integer, LinkedHashSet> freqToKey;

    int minFreq;

    int cap;

    public No05LFU(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKey = new HashMap<>();
        minFreq = 0;
        cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加key对应的频率
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            // value可能修改了
            keyToVal.put(key, value);
            increaseFreq(key);
        } else {
            // 容量不足先删除
            if (keyToVal.size() >= cap) {
                removeMinFreq();
            }
            // 新增
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKey.putIfAbsent(1, new LinkedHashSet());
            freqToKey.get(1).add(key);
            // 最小频率一定是1
            this.minFreq = 1;
        }
    }

    private void removeMinFreq() {
        // 找到对应的链表
        LinkedHashSet<Integer> minSet = freqToKey.get(minFreq);
        // 用iter可以按照插入的次序来取出数据
        int toBeDeleted = minSet.iterator().next();
        minSet.remove(toBeDeleted);
        if (minSet.isEmpty()) {
            freqToKey.remove(minFreq);
            // 重点 不需要更新minFreq，因为只有put中调用该方法，而且会更新频率为1
        }
        keyToFreq.remove(toBeDeleted);
        keyToVal.remove(toBeDeleted);

    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        // 当前频率表中删除
        freqToKey.get(freq).remove(key);
        // +1后的频率表增加（或新建）
        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet());
        freqToKey.get(freq + 1).add(key);

        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            // 别忘了更新最小频率
            if (minFreq == freq) {
                minFreq++;
            }
        }
    }
}
