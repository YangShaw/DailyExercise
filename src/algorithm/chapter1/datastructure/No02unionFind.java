package algorithm.chapter1.datastructure;

/**
 * @author YangShaw
 * @date 2021/3/26 0:37
 */
public class No02unionFind {

    // 连通分量个数
    private int count;
    // 并查集数组
    private int[] parent;
    // 辅助数组
    private int[] size;

    public No02unionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pp = find(p);
        int pq = find(q);
        if (pp == pq) {
            return;
        }
        if (size[pp] < size[pq]) {
            parent[pp] = pq;
            size[pq] += size[pp];
        } else {
            parent[pq] = pp;
            size[pp] += size[pq];
        }
        count--;
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int count() {
        return count;
    }
}
