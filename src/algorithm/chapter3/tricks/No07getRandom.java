package algorithm.chapter3.tricks;

import java.util.Random;

/**
 * @author YangShaw
 * @date 2021/4/5 10:36
 */
public class No07getRandom {

    // 水塘抽样算法
    // 在遍历的过程中，每一轮都会生成一个对当前已经看到的序列的随机值，后面每一轮在按照概率决定是否更新
    class ListNode {
        ListNode next;
        int val;
    }
    public int getRandom(ListNode head) {
        Random random = new Random();
        int res = 0;
        int i = 0;
        ListNode p = head;
        while (p != null) {
            if (random.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
