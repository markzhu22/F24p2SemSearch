import org.junit.Before;
import org.junit.Test;

public class BinTreeTest extends student.TestCase {
    private BinTree tree;

    @Before
    public void setUp() {
        tree = new BinTree();
    }

    private Seminar createSeminar(int string, double x, double y) {
        Seminar seminar = new Seminar();
        seminar.setId(string);
        seminar.setX(x);
        seminar.setY(y);
        return seminar;
    }

    @Test
    public void testInsertAndSearch() {
        Seminar seminar1 = createSeminar(1, 10, 20);
        Seminar seminar2 = createSeminar(2, 30, 40);

        tree.insert(seminar1);
        tree.insert(seminar2);

        assertEquals(seminar1, tree.search(1));
        assertEquals(seminar2, tree.search(2));
        assertNull(tree.search(3));
    }

    @Test
    public void testSearchWithinRadius() {
        Seminar seminar1 = createSeminar(1, 10, 20);
        Seminar seminar2 = createSeminar(2, 30, 40);

        tree.insert(seminar1);
        tree.insert(seminar2);

        assertTrue(tree.searchWithinRadius(15, 25, 10));
        assertFalse(tree.searchWithinRadius(0, 0, 5));
    }

    @Test
    public void testDelete() {
        Seminar seminar1 = createSeminar(1, 10, 20);
        Seminar seminar2 = createSeminar(2, 30, 40);

        tree.insert(seminar1);
        tree.insert(seminar2);

        tree.delete(10, 20);

        assertNull(tree.search(1));
        assertEquals(seminar2, tree.search(2));
    }
}