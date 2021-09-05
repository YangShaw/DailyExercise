package leetcodegrindingguide.chapter16;

public class No684findRedundantConnection {

    class UF {
        int[] parent;
        int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pp = find(p);
            int pq = find(q);
            if (pp != pq) {
                if (size[pp] < size[pq]) {
                    // 把深度小的放到深度大的下面
                    parent[pp] = pq;
                    size[pq] += size[pp];
                } else {
                    parent[pq] = pp;
                    size[pp] += size[pq];
                }
            }
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }


    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // 有n条边，说明刚好多了一条边
        if (n == 0) {
            return new int[0];
        }
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int p1 = edge[0] - 1;
            int p2 = edge[1] - 1;
            if (uf.isConnected(p1, p2)) {
                return edge;
            }
            uf.union(p1, p2);
        }
        return new int[]{-1, -1};
    }
}
