import student.TestCase;

public class BinTreeTest extends TestCase {
    private BinTree tree;

    public void setUp() {
        tree = new BinTree();
    }

    private Seminar createSeminar(int id, double x, double y) {
        return new Seminar(id, "Test Seminar " + id, "2023-01-01", 60, (short)x, (short)y, 100, new String[]{"test"}, "Test description");
    }

    public void testInsertAndSearch() {
        System.out.println("Starting testInsertAndSearch...");
        Seminar seminar1 = createSeminar(1, 2, 3);
        System.out.println("Inserting seminar: ID=" + seminar1.getId() + ", x=" + seminar1.getX() + ", y=" + seminar1.getY());
        tree.insert(seminar1);
        
        System.out.println("Searching for seminar at (2, 3)");
        Seminar found = tree.search(2, 3);
        if (found == null) {
            System.out.println("Search returned null");
        } else {
            System.out.println("Found seminar: ID=" + found.getId() + ", x=" + found.getX() + ", y=" + found.getY());
        }
        assertNotNull("Should find the inserted seminar", found);
        assertEquals("Found seminar should have correct ID", 1, found.getId());
    
        System.out.println("Searching for non-existent seminar at (4, 5)");
        Seminar notFound = tree.search(4, 5);
        assertNull("Should not find a seminar at non-existent coordinates", notFound);
    }

    public void testSearchWithinRadius() {
        tree.insert(createSeminar(1, 2, 3));
        tree.insert(createSeminar(2, 4, 5));
        tree.insert(createSeminar(3, 1, 6));

        assertTrue("Should find seminars within radius", tree.searchWithinRadius(3, 4, 2));
        assertFalse("Should not find seminars outside radius", tree.searchWithinRadius(10, 10, 1));
    }

    public void testDelete() {
        tree.insert(createSeminar(1, 2, 3));
        tree.insert(createSeminar(2, 4, 5));

        assertNotNull("Seminar should exist before deletion", tree.search(2, 3));
        tree.delete(2, 3);
        assertNull("Seminar should not exist after deletion", tree.search(2, 3));

        assertNotNull("Other seminar should still exist", tree.search(4, 5));
    }

    public void testEmptyTree() {
        assertNull("Search in empty tree should return null", tree.search(1, 1));
        assertFalse("SearchWithinRadius in empty tree should return false", tree.searchWithinRadius(1, 1, 5));
    }

    public void testMultipleInsertionsAndSearches() {
        for (int i = 0; i < 10; i++) {
            tree.insert(createSeminar(i, i, i));
        }

        for (int i = 0; i < 10; i++) {
            Seminar found = tree.search(i, i);
            assertNotNull("Should find seminar at (" + i + "," + i + ")", found);
            assertEquals("Found seminar should have correct ID", i, found.getId());
        }

        assertNull("Should not find seminar at non-existent coordinates", tree.search(10, 10));
    }
}