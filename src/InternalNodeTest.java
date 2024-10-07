import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InternalNodeTest {

    private InternalNode internalNode;
    private LeafNode leftNode;
    private LeafNode rightNode;
    private EmptyNode emptyNode;
    private Seminar seminar1;
    private Seminar seminar2;

    @Before
    public void setUp() {
        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)20, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230201", 60, (short)30,
            (short)40, 100, new String[] { "ML" }, "Description 2");

        leftNode = new LeafNode(seminar1);
        rightNode = new LeafNode(seminar2);
        emptyNode = EmptyNode.getInstance();

        internalNode = new InternalNode(leftNode, rightNode, true);
    }


    // Test if the node is not a leaf
    @Test
    public void testIsLeaf() {
        assertFalse(internalNode.isLeaf());
    }


    // Test getLeft and setLeft methods
    @Test
    public void testGetSetLeft() {
        assertEquals(leftNode, internalNode.getLeft());

        internalNode.setLeft(emptyNode);
        assertEquals(emptyNode, internalNode.getLeft());
    }


    // Test getRight and setRight methods
    @Test
    public void testGetSetRight() {
        assertEquals(rightNode, internalNode.getRight());

        internalNode.setRight(emptyNode);
        assertEquals(emptyNode, internalNode.getRight());
    }


    // Test the traverse method
    @Test
    public void testTraverse() {
        internalNode.traverse();
    }


    @Test
    public void testIntersectsTrue() {
        // Create some Seminar objects for the LeafNodes
        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230201", 60,
            (short)30, (short)30, 100, new String[] { "ML" }, "Description 2");

        // Create the left and right child nodes as LeafNodes
        LeafNode leftChild = new LeafNode(seminar1); // Left child
        LeafNode rightChild = new LeafNode(seminar2); // Right child

        // Create the InternalNode with these children
        InternalNode internalNode = new InternalNode(leftChild, rightChild,
            true);

        // Now test the intersects method
        // Adjust x, y, and radius to fit within the bounding box of the
        // InternalNode
        assertTrue(internalNode.intersects(20, 20, 20)); // Modify the values
                                                         // accordingly
    }


    @Test
    public void testIntersectsFalse() {
        // Given values for a bounding box and circle with radius that should
        // NOT intersect
        assertFalse(internalNode.intersects(100, 100, 5)); // These should be
                                                           // out of bounds
    }


    // Test unimplemented methods (getSeminar, getMinX, getMaxX, getMaxY)
    @Test
    public void testUnimplementedMethods() {
        assertNull(internalNode.getSeminar());
        assertEquals(0, internalNode.getMinX(), 0);
        assertEquals(0, internalNode.getMaxX(), 0);
        assertEquals(0, internalNode.getMaxY(), 0);
    }

}
