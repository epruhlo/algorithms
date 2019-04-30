package unionfind;

public class WeightedQuickUnion implements UnionFind {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    //takes lgN
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //takes lgN
    public void union(int p, int q) {
        final int rootP = root(p);
        final int rootQ = root(q);
        if (sz[rootP] > sz[rootQ]) {
            id[rootQ] = rootP;
            sz[rootP] += rootQ;
        } else {
            id[rootP] = rootQ;
            sz[rootQ] += rootP;
        }
    }

    private int root(int item) {
        if (id[item] == item) {
            return item;
        }
        id[item] = id[id[item]];//optimization for flattening (path compression)
        return root(id[item]);
    }
}
