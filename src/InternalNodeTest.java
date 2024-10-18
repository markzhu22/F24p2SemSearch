// -------------------------------------------------------------------------
/**
 * Test class for the InternalNode class.
 * This class contains unit tests to verify the functionality of the
 * InternalNode class, such as construction, getter and setter methods, and
 * behavior of split operations.
 * 
 * Each test ensures that the InternalNode behaves as expected when interacting
 * with child nodes and that its internal state is correctly maintained and
 * modified.
 * 
 * @see InternalNode
 * @see LeafNode
 * @see Seminar
 * @see BinNode
 * 
 * @author markz + tarinid
 * @version Oct 14, 2024
 */
public class InternalNodeTest extends student.TestCase {

    private InternalNode node; // The InternalNode under test
    private BinNode leftChild; // The left child of the InternalNode
    private BinNode rightChild; // The right child of the InternalNode
    private Seminar leftSeminar; // Seminar object for the left child
    private Seminar rightSeminar; // Seminar object for the right child

    // ----------------------------------------------------------
    /**
     * Sets up the test environment by initializing the InternalNode and its
     * children before each test.
     * 
     * The left and right children of the node are LeafNodes containing
     * Seminars, and the node splits on the x-axis.
     */
    public void setUp() {
        leftSeminar = new Seminar();
        leftSeminar.setId(2); // Seminar with ID 2 is now the left child
        rightSeminar = new Seminar();
        rightSeminar.setId(1); // Seminar with ID 1 is now the right child
        leftChild = new LeafNode(leftSeminar);
        rightChild = new LeafNode(rightSeminar);
        node = new InternalNode(leftChild, rightChild, true, 0);
    }


    // ----------------------------------------------------------
    /**
     * Tests the constructor of InternalNode by verifying that the left and
     * right children, as well as the split axis, are correctly initialized.
     */
    public void testConstructor() {
        assertEquals(leftChild, node.getLeft());
        assertEquals(rightChild, node.getRight());
        assertTrue(node.isSplitOnX());
    }


    // ----------------------------------------------------------
    /**
     * Tests that InternalNode is not a leaf node by calling the isLeaf method.
     */
    public void testIsLeaf() {
        assertFalse(node.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests that InternalNode does not store a Seminar object by calling
     * getSeminar, which should return null.
     */
    public void testGetSeminar() {
        assertNull(node.getSeminar());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getLeft method by verifying that the correct left child is
     * returned.
     */
    public void testGetLeft() {
        assertEquals(leftChild, node.getLeft());
    }


    // ----------------------------------------------------------
    /**
     * Tests the setLeft method by changing the left child of the InternalNode
     * and verifying that the new left child is correctly set.
     */
    public void testSetLeft() {
        BinNode newLeft = new LeafNode(new Seminar());
        node.setLeft(newLeft);
        assertEquals(newLeft, node.getLeft());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getRight method by verifying that the correct right child is
     * returned.
     */
    public void testGetRight() {
        assertEquals(rightChild, node.getRight());
    }


    // ----------------------------------------------------------
    /**
     * Tests the setRight method by changing the right child of the InternalNode
     * and verifying that the new right child is correctly set.
     */
    public void testSetRight() {
        BinNode newRight = new LeafNode(new Seminar());
        node.setRight(newRight);
        assertEquals(newRight, node.getRight());
    }


    // ----------------------------------------------------------
    /**
     * Tests the isSplitOnX method by verifying whether the node splits on the
     * x-axis or y-axis.
     * 
     * Also tests the behavior when creating an InternalNode that splits on the
     * y-axis.
     */
    public void testIsSplitOnX() {
        assertTrue(node.isSplitOnX());
        InternalNode nodeY = new InternalNode(leftChild, rightChild, false, 0);
        assertFalse(nodeY.isSplitOnX());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getSplitValue method by verifying that the correct initial
     * split value is returned.
     */
    public void testGetSplitValue() {
        assertEquals(0, node.getSplitValue()); // Initial split value should be
                                               // 0
    }


    // ----------------------------------------------------------
    /**
     * Tests the setSplitValue method by changing the split value and verifying
     * that the new split value is correctly set.
     */
    public void testSetSplitValue() {
        node.setSplitValue(5);
        assertEquals(5, node.getSplitValue()); // Split value should now be 5
    }


    // ----------------------------------------------------------
    /**
     * Tests the incrementDepth method by verifying that the depth is correctly
     * decremented by 1.
     */
    public void testIncrementDepth() {
        int initialDepth = 5;
        int newDepth = node.incrementDepth(initialDepth);
        assertEquals(4, newDepth); // Should decrement the depth by 1
    }
}
