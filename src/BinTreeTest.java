import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinTreeTest {
    private BinTree binTree;
    private Seminar seminar1;
    private Seminar seminar2;
    private Seminar seminar3;

    @Before
    public void setUp() {
        binTree = new BinTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230201", 60, (short)30,
            (short)30, 100, new String[] { "ML" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230301", 120, (short)50,
            (short)50, 75, new String[] { "Data Science" }, "Description 3");
    }


    @Test
    public void testInsertIntoEmptyTree() {
        binTree.insert(seminar1, seminar1.getX(), seminar1.getY());

        boolean found = binTree.searchWithinRadius(seminar1.getX(), seminar1
            .getY(), 1);
        assertTrue("Seminar 1 should be found in the tree", found);
    }


    @Test
    public void testInsertWithSplit() {
        binTree.insert(seminar1, seminar1.getX(), seminar1.getY());
        binTree.insert(seminar2, seminar2.getX(), seminar2.getY());

        boolean foundSeminar1 = binTree.searchWithinRadius(seminar1.getX(),
            seminar1.getY(), 1);
        boolean foundSeminar2 = binTree.searchWithinRadius(seminar2.getX(),
            seminar2.getY(), 1);

        assertTrue("Seminar 1 should be found", foundSeminar1);
        assertTrue("Seminar 2 should be found", foundSeminar2);
    }


    @Test
    public void testSearchWithinRadius() {
        binTree.insert(seminar1, seminar1.getX(), seminar1.getY());
        binTree.insert(seminar2, seminar2.getX(), seminar2.getY());
        binTree.insert(seminar3, seminar3.getX(), seminar3.getY());
        
        boolean foundSeminar2 = binTree.searchWithinRadius(30, 30, 5);
        boolean foundSeminar3 = binTree.searchWithinRadius(50, 50, 5);

        assertTrue("Seminar 2 should be found within the radius",
            foundSeminar2);
        assertTrue("Seminar 3 should be found within the radius",
            foundSeminar3);
    }


    @Test
    public void testSearchOutsideRadius() {
        binTree.insert(seminar1, seminar1.getX(), seminar1.getY());
        binTree.insert(seminar2, seminar2.getX(), seminar2.getY());

        boolean foundSeminar1 = binTree.searchWithinRadius(0, 0, 5);
        assertFalse("Seminar 1 should not be found outside the radius",
            foundSeminar1);
    }
}
