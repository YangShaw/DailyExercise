package leetcode;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    public LRUCache(int capacity){
        //  true代表按照访问顺序排序
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    //  return -1 if key doesn't exists
    public int get(int key){
        return super.getOrDefault(key, -1);
    }


    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    //  在插入元素的时候自动调用该方法，判断是否要删除最老的元素
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}
