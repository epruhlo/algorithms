package unionfind;

public class QuickUnion implements UnionFind {
    int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    private int root(int item) {
        if (id[item] == item) {
            return item;
        }
        return root(id[item]);
    }
}
