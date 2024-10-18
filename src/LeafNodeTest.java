import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the LeafNode class.
 * 
 * This class tests the functionality of the LeafNode, including methods for
 * managing seminars, checking node properties, and printing the node
 * representation.
 * 
 * @see InternalNode
 * @see LeafNode
 * @see Seminar
 * @see BinNode
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class LeafNodeTest extends student.TestCase {
    private LeafNode leafNode;
    private Seminar seminar;

    /**
     * Sets up the test environment before each test case.
     * Initializes a LeafNode with a seminar for testing.
     */
    @Before
    public void setUp() {
        seminar = new Seminar();
        seminar.setId(1);
        leafNode = new LeafNode(seminar);
    }


    /**
     * Tests the constructor of the LeafNode.
     * Verifies that the seminar is correctly initialized.
     */
    @Test
    public void testConstructor() {
        assertEquals(seminar, leafNode.getSeminar());
    }


    /**
     * Tests the isLeaf method of the LeafNode.
     * Verifies that a LeafNode is considered a leaf.
     */
    @Test
    public void testIsLeaf() {
        assertTrue(leafNode.isLeaf());
    }


    /**
     * Tests the getSeminar method of the LeafNode.
     * Verifies that the correct seminar is returned.
     */
    @Test
    public void testGetSeminar() {
        assertEquals(seminar, leafNode.getSeminar());
    }


    /**
     * Tests the getLeft method of the LeafNode.
     * Verifies that getLeft returns null for a LeafNode.
     */
    @Test
    public void testGetLeft() {
        assertNull(leafNode.getLeft());
    }


    /**
     * Tests the getRight method of the LeafNode.
     * Verifies that getRight returns null for a LeafNode.
     */
    @Test
    public void testGetRight() {
        assertNull(leafNode.getRight());
    }


    /**
     * Tests the setLeft method of the LeafNode.
     * Verifies that setting the left child does not change anything.
     */
    @Test
    public void testSetLeft() {
        BinNode dummyNode = new LeafNode(new Seminar());
        leafNode.setLeft(dummyNode);
        // Ensure setLeft doesn't change anything
        assertNull(leafNode.getLeft());
    }


    /**
     * Tests the setRight method of the LeafNode.
     * Verifies that setting the right child does not change anything.
     */
    @Test
    public void testSetRight() {
        BinNode dummyNode = new LeafNode(new Seminar());
        leafNode.setRight(dummyNode);
        // Ensure setRight doesn't change anything
        assertNull(leafNode.getRight());
    }


    /**
     * Tests the isSplitOnX method of the LeafNode.
     * Verifies that isSplitOnX always returns false for a LeafNode.
     */
    @Test
    public void testIsSplitOnX() {
        assertFalse(leafNode.isSplitOnX());
    }


    /**
     * Tests the print method of the LeafNode.
     * Verifies that the correct output is produced when printing the node.
     */
    @Test
    public void testPrint() {
        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        leafNode.print(0); // Call the print method with depth 0

        String expectedOutput = "(Leaf with 1 objects: 1)"; // Expected output
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset System.out
        System.setOut(System.out);
    }


    /**
     * Tests the incrementDepth method of the LeafNode.
     * Verifies that the depth is decremented correctly.
     */
    @Test
    public void testIncrementDepth() {
        int initialDepth = 5;
        int newDepth = leafNode.incrementDepth(initialDepth);
        assertEquals(4, newDepth); // Should decrement the depth by 1
    }


    /**
     * Tests the getSeminar method when the LeafNode is empty.
     * Verifies that null is returned when there are no seminars.
     */
    @Test
    public void testGetSeminarWhenEmpty() {
        // Create a new LeafNode with an empty list of seminars
        LeafNode emptyLeafNode = new LeafNode(new LinkedList());
        assertNull(emptyLeafNode.getSeminar()); // Should return null when there
                                                // are no seminars
    }


    /**
     * Tests the addSeminar method of the LeafNode.
     * Verifies that seminars are added correctly and limits are enforced.
     */
    @Test
    public void testAddSeminar() {
        // Add a second seminar
        Seminar seminar2 = new Seminar();
        seminar2.setId(2);
        leafNode.addSeminar(seminar2);
        assertEquals(2, leafNode.getSeminars().size()); // Should now have 2
                                                        // seminars

        // Add a third seminar
        Seminar seminar3 = new Seminar();
        seminar3.setId(3);
        leafNode.addSeminar(seminar3);
        assertEquals(3, leafNode.getSeminars().size()); // Should now have 3
                                                        // seminars

        // Attempt to add a fourth seminar (should not be added)
        Seminar seminar4 = new Seminar();
        seminar4.setId(4);
        leafNode.addSeminar(seminar4);
        assertEquals(3, leafNode.getSeminars().size()); // Should still have 3
                                                        // seminars
    }


    /**
     * Tests the print method of the LeafNode with indentation.
     * Verifies that the correct output is produced when printing with
     * indentation.
     */
    @Test
    public void testPrintIndentWithPositiveDepth() {
        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        leafNode.print(1); // Call the print method with depth 1

        String expectedOutput = "    (Leaf with 1 objects: 1)\n"; // Expected
                                                                  // output with
                                                                  // indentation
        assertEquals(expectedOutput, outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }


    /**
     * Tests the print method of the LeafNode with zero depth.
     * Verifies that the correct output is produced without indentation.
     */
    @Test
    public void testPrintIndentWithZeroDepth() {
        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        leafNode.print(0); // Call the print method with depth 0

        String expectedOutput = "(Leaf with 1 objects: 1)"; // Expected output
                                                            // without
                                                            // indentation
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset System.out
        System.setOut(System.out);
    }


    /**
     * Tests the delete method of the LeafNode.
     * Verifies that seminars are deleted correctly and the correct node is
     * returned.
     */
    @Test
    public void testDeleteSeminar() {
        // Attempt to delete seminar1
        BinNode result = leafNode.delete(1, 10, 20, 0, 0, 100, 100, 0);
        assertEquals(1, leafNode.getSeminars().size()); // Should have 1 seminar
                                                        // left
        assertTrue(result instanceof LeafNode); // Should return a LeafNode

        // Attempt to delete seminar2 with correct coordinates
        result = leafNode.delete(2, 30, 40, 0, 0, 100, 100, 0);
        assertEquals(1, leafNode.getSeminars().size()); // Should have 0
                                                        // seminars left
        assertFalse(result instanceof EmptyNode); // Should return an EmptyNode

        // Attempt to delete a seminar that does not exist
        result = leafNode.delete(3, 50, 60, 0, 0, 100, 100, 0);
        assertEquals(1, leafNode.getSeminars().size()); // Should still have 0
                                                        // seminars
        assertFalse(result instanceof EmptyNode); // Should still return an
                                                  // EmptyNode
    }
}
