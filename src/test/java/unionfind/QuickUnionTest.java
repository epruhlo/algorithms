package unionfind;

import org.junit.Assert;
import org.junit.Test;


public class QuickUnionTest {


    private static final int size = 10;

    @Test
    public void testQuickUnion() {
        UnionFind target = new QuickUnion(size);
        testUnionFind(target);
    }

    @Test
    public void testQuickFind() {
        UnionFind target = new QuickFind(size);
        testUnionFind(target);
    }

    @Test
    public void testWeightedQuickFind() {
        UnionFind target = new WeightedQuickUnion(size);
        testUnionFind(target);
    }

    private void testUnionFind(UnionFind target) {
        target.union(3,4);
        Assert.assertTrue(target.connected(3,4));

        target.union(3,8);
        target.union(6,5);
        target.union(9,4);
        target.union(2,1);
        Assert.assertTrue(target.connected(8,9));
        Assert.assertFalse(target.connected(5,4));

        target.union(5,0);
        target.union(7,2);
        target.union(6,1);
        target.union(7,3);


        for(int i = 0; i< size; i++){
            for(int j = 0; i< size; i++){
                Assert.assertTrue(target.connected(i,j));
            }
        }
    }
}
