package algorithm.chapter1.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/3/20 15:03
 */
public class NestedIterator implements Iterator<Integer> {

    public class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedInteger(Integer val) {
            this.val = val;
            this.list = null;
        }
        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
            this.val = null;
        }

        // 如果其中存的是一个整数，则返回 true，否则返回 false
        public boolean isInteger() {
            return val != null;
        }

        // 如果其中存的是一个整数，则返回这个整数，否则返回 null
        public Integer getInteger() {
            return this.val;
        }

        // 如果其中存的是一个列表，则返回这个列表，否则返回 null
        public List<NestedInteger> getList() {
            return this.list;
        }
    }

    private LinkedList<NestedInteger> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> curList = this.list.remove(0).getList();
            for (int i = curList.size() - 1; i >= 0; i--) {
                list.addFirst(curList.get(i));
            }
        }
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }
}
