import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for the BinTree class.
 * 
 * This class tests the functionality of the BinTree, including methods for
 * inserting seminars, searching for seminars, deleting seminars, and checking
 * the state of the tree (e.g., empty or not).
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class BinTreeTest extends student.TestCase {
    private BinTree tree;
    // Class field for the BinTree instance
    private final int worldSize = 128;

    /**
     * Sets up the test environment before each test case.
     * Initializes a BinTree instance for testing.
     */
    public void setUp() {
        tree = new BinTree(worldSize);
    }


    /**
     * Creates a Seminar object with the specified parameters.
     *
     * @param id
     *            the ID of the seminar
     * @param title
     *            the title of the seminar
     * @param date
     *            the date of the seminar
     * @param length
     *            the length of the seminar in minutes
     * @param x
     *            the X coordinate of the seminar
     * @param y
     *            the Y coordinate of the seminar
     * @param cost
     *            the cost of the seminar
     * @param keywords
     *            the keywords associated with the seminar
     * @param description
     *            a description of the seminar
     * @return a Seminar object with the specified parameters
     */
    private Seminar createSeminar(
        int id,
        String title,
        String date,
        int length,
        int x,
        int y,
        int cost,
        String[] keywords,
        String description) {
        return new Seminar(id, title, date, length, (short)x, (short)y, cost,
            keywords, description);
    }


    /**
     * Tests the insertion and searching of seminars in the BinTree.
     * Verifies that the size of the tree is correct after insertion
     * and that the seminars can be found.
     */
    public void testInsertAndSearch() {
        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10,
            100, new String[] { "keyword1" }, "Description1");
        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 20, 20,
            200, new String[] { "keyword2" }, "Description2");

        tree.insert(seminar1);
        tree.insert(seminar2);

        assertEquals(2, tree.size());
        assertFalse(tree.isEmpty());

        tree.search(10, 10, 0);
        tree.search(20, 20, 0);
    }


    /**
     * Tests the deletion of a seminar from the BinTree.
     * Verifies that the size of the tree is updated correctly after deletion.
     */
    public void testDelete() {
        Seminar seminar = createSeminar(1, "Test", "20240101", 60, 10, 10, 100,
            new String[] { "keyword" }, "Description");
        tree.insert(seminar);

        assertEquals(1, tree.size());
        tree.delete(10, 10, 1);
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }


    /**
     * Tests searching for seminars within a specified range.
     * Verifies that the correct seminars are found based on their coordinates.
     */
    public void testSearchInRange() {
        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10,
            100, new String[] { "keyword1" }, "Description1");
        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 20, 20,
            200, new String[] { "keyword2" }, "Description2");
        Seminar seminar3 = createSeminar(3, "Test3", "20240103", 120, 30, 30,
            300, new String[] { "keyword3" }, "Description3");

        tree.insert(seminar1);
        tree.insert(seminar2);
        tree.insert(seminar3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }


    /**
     * Tests inserting a seminar into an empty BinTree.
     * Verifies that the tree size is updated correctly after insertion.
     */
    public void testInsertIntoEmptyTree() {
        Seminar seminar = createSeminar(1, "Test Seminar", "20240101", 60, 10,
            10, 100, new String[] { "keyword" }, "Description");
        tree.insert(seminar);

        assertEquals(1, tree.size());
        assertFalse(tree.isEmpty());
    }


    /**
     * Tests the deletion of a non-existent seminar from the BinTree.
     * Verifies that the size of the tree remains unchanged.
     */
    public void testDeleteNonExistentSeminar() {
        Seminar seminar = createSeminar(1, "Test Seminar", "20240101", 60, 10,
            10, 100, new String[] { "keyword" }, "Description");
        tree.insert(seminar);

        assertEquals(1, tree.size());
        tree.delete(20, 20, 2); // Attempt to delete a seminar that doesn't
                                // exist
        assertEquals(1, tree.size()); // Size should remain 1
    }


    /**
     * Tests searching for seminars outside the range of existing seminars.
     * Verifies that no records are found in the output.
     */
    public void testSearchOutsideRange() {
        Seminar seminar = createSeminar(1, "Test Seminar", "20240101", 60, 10,
            10, 100, new String[] { "keyword" }, "Description");
        tree.insert(seminar);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        tree.search(50, 50, 5); // Search outside the range of the seminar

        String output = outContent.toString();
        System.setOut(originalOut); // Reset System.out

        assertFalse("Output should not contain any found records", output
            .contains("Found a record with key value"));
    }


    /**
     * Tests the state of an empty BinTree.
     * Verifies that the tree is empty and its size is zero.
     */
    public void testEmptyTree() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }


    /**
     * Tests the isEmpty method after inserting a seminar.
     * Verifies that the tree is not empty after insertion.
     */
    public void testIsEmptyFalse() {
        Seminar seminar = createSeminar(1, "Test Seminar", "20240101", 60, 10,
            10, 100, new String[] { "keyword" }, "Description");
        tree.insert(seminar);
        assertFalse("Tree should not be empty after inserting a seminar", tree
            .isEmpty());
    }


    /**
     * Tests the printTree method of the BinTree.
     * Verifies that the output is not empty and contains the expected header.
     */
    public void testPrintTree() {
        Seminar seminar1 = createSeminar(1, "Test1", "20240101", 60, 10, 10,
            100, new String[] { "keyword1" }, "Description1");
        Seminar seminar2 = createSeminar(2, "Test2", "20240102", 90, 20, 20,
            200, new String[] { "keyword2" }, "Description2");

        tree.insert(seminar1);
        tree.insert(seminar2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.printTree();

        String output = outContent.toString();
        System.setOut(System.out); // Reset System.out

        System.out.println("Captured output:");
        System.out.println(output);

        assertFalse("Output should not be empty", output.isEmpty());
        assertTrue("Output should contain 'Location Tree:'", output.contains(
            "Location Tree:"));
    }


    /**
     * Tests inserting seminars with different coordinates into the BinTree.
     * Verifies that the size of the tree is updated correctly.
     */
    public void testInsertDifferentCoordinates() {
        BinTree newTree = new BinTree(128); // Renamed local variable to avoid
                                            // conflict
        Seminar seminar1 = createSeminar(1, "Seminar 1", "0610051600", 100, 5,
            5, 50, new String[] { "key1" }, "Description 1");
        Seminar seminar2 = createSeminar(2, "Seminar 2", "0610051600", 100, 10,
            10, 50, new String[] { "key2" }, "Description 2");

        newTree.insert(seminar1);
        newTree.insert(seminar2); // This should create a new internal node

        assertEquals(2, newTree.size());
        // Additional assertions can be added to verify the structure of the
        // tree
    }


    /**
     * Tests inserting seminars into an internal node of the BinTree.
     * Verifies that the size of the tree is updated correctly after multiple
     * insertions.
     */
    public void testInsertIntoInternalNode() {
        BinTree newTree2 = new BinTree(128); // Renamed local variable to avoid
                                             // conflict
        Seminar seminar1 = createSeminar(1, "Seminar 1", "0610051600", 100, 5,
            5, 50, new String[] { "key1" }, "Description 1");
        Seminar seminar2 = createSeminar(2, "Seminar 2", "0610051600", 100, 10,
            10, 50, new String[] { "key2" }, "Description 2");

        newTree2.insert(seminar1);
        newTree2.insert(seminar2); // This should create an internal node

        // Now insert a seminar that should go to the right subtree
        Seminar seminar3 = createSeminar(3, "Seminar 3", "0610051600", 100, 15,
            15, 50, new String[] { "key3" }, "Description 3");
        newTree2.insert(seminar3); // This should go to the right of the
                                   // internal
                                   // node

        assertEquals(3, newTree2.size());
        // Additional assertions can be added to verify the structure of the
        // tree
    }
}
