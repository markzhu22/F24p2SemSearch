import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinTreeTest extends student.TestCase {
    private BinTree tree;
    private final int WORLD_SIZE = 128;

    public void setUp() {
        tree = new BinTree(WORLD_SIZE);
    }

    private Seminar createSeminar(int id, String title, String date, int length, int x, int y, int cost, String[] keywords, String description) {
        return new Seminar(id, title, date, length, (short)x, (short)y, cost, keywords, description);
    }

    public void testInsertAndSearch() {
        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10, 100, new String[]{"keyword1"}, "Description1");
        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 20, 20, 200, new String[]{"keyword2"}, "Description2");

        tree.insert(seminar1);
        tree.insert(seminar2);

        assertEquals(2, tree.size());
        assertFalse(tree.isEmpty());

        Seminar result1 = tree.search(10, 10);
        Seminar result2 = tree.search(20, 20);

        assertNotNull(result1);
        assertNotNull(result2);
        assertEquals(seminar1.getId(), result1.getId());
        assertEquals(seminar2.getId(), result2.getId());
    }

    public void testDelete() {
        Seminar seminar = createSeminar(1, "Test", "20240101", 60, 10, 10, 100, new String[]{"keyword"}, "Description");
        tree.insert(seminar);

        assertEquals(1, tree.size());
        tree.delete(10, 10);
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        assertNull(tree.search(10, 10));
    }

    public void testSearchInRange() {
        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10, 100, new String[]{"keyword1"}, "Description1");
        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 20, 20, 200, new String[]{"keyword2"}, "Description2");
        Seminar seminar3 = createSeminar(3, "Test3", "20240103", 120, 30, 30, 300, new String[]{"keyword3"}, "Description3");

        tree.insert(seminar1);
        tree.insert(seminar2);
        tree.insert(seminar3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            tree.searchInRange(15, 15, 10);

            String output = outContent.toString();
            assertTrue(output.contains("Found a record with key value 1 at 10, 10"));
            assertTrue(output.contains("Found a record with key value 2 at 20, 20"));
            assertFalse(output.contains("Found a record with key value 3 at 30, 30"));
        } finally {
            System.setOut(originalOut);
        }
    }

//    public void testInsertOutOfBounds() {
//        Seminar seminarOutOfBounds = createSeminar(1, "OutOfBounds", "20240101", 60, -1, 10, 100, new String[]{"keyword"}, "Description");
//        tree.insert(seminarOutOfBounds);
//        assertEquals(0, tree.size());
//
//        seminarOutOfBounds = createSeminar(2, "OutOfBounds", "20240101", 60, 10, WORLD_SIZE, 100, new String[]{"keyword"}, "Description");
//        tree.insert(seminarOutOfBounds);
//        assertEquals(0, tree.size());
//    }
//
//    public void testInsertDuplicateCoordinates() {
//        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10, 100, new String[]{"keyword1"}, "Description1");
//        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 10, 10, 200, new String[]{"keyword2"}, "Description2");
//    
//        tree.insert(seminar1);
//        tree.insert(seminar2);
//    
//        assertEquals(1, tree.size()); // The size should be 1, not 2
//        Seminar result = tree.search(10, 10);
//        assertNotNull(result);
//        
//        // Check if both seminars are stored at the same location
//        assertEquals(10, result.getX());
//        assertEquals(10, result.getY());
//        
//        // Additional checks to ensure both seminars are stored
//        assertTrue(result.getId() == 1 || result.getId() == 2);
//        
//        // You might want to add a method to your BinTree class to get all seminars at a specific location
//        // For example: List<Seminar> seminarsAtLocation = tree.getAllSeminarsAt(10, 10);
//        // assertEquals(2, seminarsAtLocation.size());
//        // assertTrue(seminarsAtLocation.stream().anyMatch(s -> s.getId() == 1));
//        // assertTrue(seminarsAtLocation.stream().anyMatch(s -> s.getId() == 2));
//    }

    public void testEmptyTree() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertNull(tree.search(10, 10));
    }

    public void testPrintTree() {
        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10, 100, new String[]{"keyword1"}, "Description1");
        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 20, 20, 200, new String[]{"keyword2"}, "Description2");

        tree.insert(seminar1);
        tree.insert(seminar2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.printTree();

        String output = outContent.toString();
        System.setOut(System.out);  // Reset System.out

        System.out.println("Captured output:");
        System.out.println(output);

        assertFalse("Output should not be empty", output.isEmpty());
        assertTrue("Output should contain 'Location Tree:'", output.contains("Location Tree:"));
        // Add more assertions based on expected output
    }
}