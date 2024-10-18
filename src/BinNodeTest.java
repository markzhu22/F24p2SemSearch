import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the BinNode interface and its implementations.
 * 
 * This class tests the functionality of the BinNode interface, including
 * methods for checking node types, accessing child nodes, and retrieving
 * associated seminars.
 * 
 * @author markz + tarinid
 * @version Oct 14, 2024
 */
public class BinNodeTest extends student.TestCase {

    private BinNode node;
    private BinNode leftChild;
    private BinNode rightChild;
    private Seminar seminar;

    /**
     * Sets up the test environment before each test case.
     * Initializes a BinNode and its children for testing.
     */
    @Before
    public void setUp() {
        seminar = new Seminar(1, "Test Seminar", "20240101", 60, (short)10,
            (short)20, 100, new String[] { "Test" }, "Test Description");

        node = new InternalNode(null, null, true, 0);
        leftChild = new LeafNode(seminar);
        rightChild = new LeafNode(seminar);

        node.setLeft(leftChild);
        node.setRight(rightChild);
    }


    /**
     * Tests the isLeaf method of the BinNode interface.
     * Verifies that internal nodes are not leaves and leaf nodes are leaves.
     */
    @Test
    public void testIsLeaf() {
        assertFalse(node.isLeaf());
        assertTrue(leftChild.isLeaf());
        assertTrue(rightChild.isLeaf());
    }


    /**
     * Tests the getSeminar method of the BinNode interface.
     * Verifies that internal nodes do not have seminars and leaf nodes return
     * the correct seminar.
     */
    @Test
    public void testGetSeminar() {
        assertNull(node.getSeminar()); // Internal nodes don't have seminars
        assertEquals(seminar, leftChild.getSeminar());
        assertNotNull(rightChild.getSeminar());
    }


    /**
     * Tests the getLeft method of the BinNode interface.
     * Verifies that the left child is correctly returned.
     */
    @Test
    public void testGetLeft() {
        assertEquals(leftChild, node.getLeft());
    }


    /**
     * Tests the getRight method of the BinNode interface.
     * Verifies that the right child is correctly returned.
     */
    @Test
    public void testGetRight() {
        assertEquals(rightChild, node.getRight());
    }


    /**
     * Tests the isSplitOnX method of the BinNode interface.
     * Verifies that the internal node correctly indicates whether it is split
     * on the X-axis.
     */
    @Test
    public void testIsSplitOnX() {
        assertTrue(node.isSplitOnX());
        // Leaf nodes don't have a split, so we shouldn't test isSplitOnX for
        // them
    }
}
