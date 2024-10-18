import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for the EmptyNode class.
 * 
 * This class tests the functionality of the EmptyNode singleton, including
 * methods for checking node properties, accessing child nodes, and printing
 * the node representation.
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class EmptyNodeTest extends student.TestCase {

    /**
     * Tests the singleton property of the EmptyNode.
     * Verifies that multiple calls to getInstance return the same instance.
     */
    @Test
    public void testSingleton() {
        EmptyNode node1 = EmptyNode.getInstance();
        EmptyNode node2 = EmptyNode.getInstance();
        assertSame("getInstance should always return the same instance", node1,
            node2);
    }


    /**
     * Tests the isLeaf method of the EmptyNode.
     * Verifies that an EmptyNode is not considered a leaf.
     */
    @Test
    public void testIsLeaf() {
        EmptyNode node = EmptyNode.getInstance();
        assertFalse("EmptyNode should not be considered a leaf", node.isLeaf());
    }


    /**
     * Tests the getSeminar method of the EmptyNode.
     * Verifies that getSeminar returns null for an EmptyNode.
     */
    @Test
    public void testGetSeminar() {
        EmptyNode node = EmptyNode.getInstance();
        assertNull("getSeminar should return null for EmptyNode", node
            .getSeminar());
    }


    /**
     * Tests the getLeft method of the EmptyNode.
     * Verifies that getLeft returns null for an EmptyNode.
     */
    @Test
    public void testGetLeft() {
        EmptyNode node = EmptyNode.getInstance();
        assertNull("getLeft should return null for EmptyNode", node.getLeft());
    }


    /**
     * Tests the getRight method of the EmptyNode.
     * Verifies that getRight returns null for an EmptyNode.
     */
    @Test
    public void testGetRight() {
        EmptyNode node = EmptyNode.getInstance();
        assertNull("getRight should return null for EmptyNode", node
            .getRight());
    }


    /**
     * Tests the setLeft method of the EmptyNode.
     * Verifies that setting the left child does not throw an exception.
     */
    @Test
    public void testSetLeft() {
        EmptyNode node = EmptyNode.getInstance();
        BinNode dummyNode = new LeafNode(new Seminar()); // Assuming LeafNode
                                                         // exists
        node.setLeft(dummyNode);
        // No assertion needed, just making sure it doesn't throw an exception
    }


    /**
     * Tests the setRight method of the EmptyNode.
     * Verifies that setting the right child does not throw an exception.
     */
    @Test
    public void testSetRight() {
        EmptyNode node = EmptyNode.getInstance();
        BinNode dummyNode = new LeafNode(new Seminar()); // Assuming LeafNode
                                                         // exists
        node.setRight(dummyNode);
        // No assertion needed, just making sure it doesn't throw an exception
    }


    /**
     * Tests the isSplitOnX method of the EmptyNode.
     * Verifies that isSplitOnX always returns false for an EmptyNode.
     */
    @Test
    public void testIsSplitOnX() {
        EmptyNode node = EmptyNode.getInstance();
        assertFalse("isSplitOnX should always return false for EmptyNode", node
            .isSplitOnX());
    }


    /**
     * Tests the print method of the EmptyNode.
     * Verifies that the correct output is produced when printing the node.
     */
    @Test
    public void testPrint() {
        EmptyNode node = EmptyNode.getInstance();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        node.print(2);

        assertEquals("    (E)\n", outContent.toString());
        System.setOut(System.out); // Reset System.out to its original
    }


    /**
     * Tests the print method of the EmptyNode with a specified node.
     * Verifies that the correct output is produced when printing the node.
     */
    @Test
    public void testPrintWithNode() {
        EmptyNode node = EmptyNode.getInstance();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        node.print(node, 2);

        assertEquals("    (E)\n", outContent.toString());
        System.setOut(System.out); // Reset System.out to its original
    }


    /**
     * Tests the incrementDepth method of the EmptyNode.
     * Verifies that the depth is incremented correctly.
     */
    @Test
    public void testIncrementDepth() {
        EmptyNode node = EmptyNode.getInstance();
        assertEquals(4, node.incrementDepth(5));
        assertEquals(-1, node.incrementDepth(0));
    }


    /**
     * Tests the delete method of the EmptyNode.
     * Verifies that deleting from an EmptyNode returns the singleton instance.
     */
    @Test
    public void testDelete() {
        EmptyNode node = EmptyNode.getInstance();
        BinNode result = node.delete(1, 0, 0, 0, 0, 10, 10, 0);
        assertSame("Delete should return the singleton EmptyNode instance",
            EmptyNode.getInstance(), result);
    }


    /**
     * Tests the print method of the EmptyNode with indentation.
     * Verifies that the correct output is produced when printing with
     * indentation.
     */
    @Test
    public void testPrintIndent() {
        EmptyNode node = EmptyNode.getInstance();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        node.print(3);

        assertEquals("        (E)\n", outContent.toString());
        System.setOut(System.out); // Reset System.out to its original
    }
}
