import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinNodeTest {

    private LeafNode leafNode;
    private InternalNode internalNode;
    private EmptyNode emptyNode;
    private Seminar seminar1;
    @SuppressWarnings("unused")
    private Seminar seminar2;

    @Before
    public void setUp() {
        // Setup for testing
        seminar1 = new Seminar(1, "AI Seminar", "20240101", 120, (short)10,
            (short)20, 500, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "ML Seminar", "20240102", 90, (short)30,
            (short)40, 700, new String[] { "ML" }, "Description 2");

        leafNode = new LeafNode(seminar1);
        emptyNode = EmptyNode.getInstance();
        internalNode = new InternalNode(leafNode, emptyNode, true);
    }


    // Testing LeafNode
    @Test
    public void testLeafNodeIsLeaf() {
        assertTrue(leafNode.isLeaf());
    }


    @Test
    public void testLeafNodeTraverse() {
        leafNode.traverse();
    }


    @Test
    public void testLeafNodeIntersectsTrue() {
        assertTrue(leafNode.intersects(10, 20, 5));
    }


    @Test
    public void testLeafNodeIntersectsFalse() {
        assertFalse(leafNode.intersects(50, 50, 5));
    }


    @Test
    public void testLeafNodeGetSeminar() {
        assertEquals(seminar1, leafNode.getSeminar());
    }


    // Testing EmptyNode
    @Test
    public void testEmptyNodeIsLeaf() {
        assertFalse(emptyNode.isLeaf());
    }


    @Test
    public void testEmptyNodeTraverse() {
        emptyNode.traverse();
    }


    @Test
    public void testEmptyNodeIntersects() {
        assertFalse(emptyNode.intersects(10, 10, 5)); 
    }


    @Test
    public void testEmptyNodeGetSeminar() {
        assertNull(emptyNode.getSeminar()); 
    }


    // Testing InternalNode
    @Test
    public void testInternalNodeIsLeaf() {
        assertFalse(internalNode.isLeaf());
    }


    @Test
    public void testInternalNodeGetLeftAndRight() {
        assertEquals(leafNode, internalNode.getLeft());
        assertEquals(emptyNode, internalNode.getRight());
    }


    @Test
    public void testInternalNodeTraverse() {
        internalNode.traverse(); 
    }


    @Test
    public void testInternalNodeIntersectsTrue() {
        internalNode.setLeft(leafNode);
    }


    @Test
    public void testInternalNodeIntersectsFalse() {
        // Modify min/max to test this case
        assertFalse(internalNode.intersects(50, 50, 5));
    }


    // MinX, MaxX, MaxY tests
    @Test
    public void testMinMaxMethods() {
        assertEquals(0, leafNode.getMinX(), 0);
        assertEquals(0, leafNode.getMaxX(), 0);
        assertEquals(0, leafNode.getMaxY(), 0);

        assertEquals(0, emptyNode.getMinX(), 0);
        assertEquals(0, emptyNode.getMaxX(), 0);
        assertEquals(0, emptyNode.getMaxY(), 0);

        assertEquals(0, internalNode.getMinX(), 0);
        assertEquals(0, internalNode.getMaxX(), 0);
        assertEquals(0, internalNode.getMaxY(), 0);
    }

}
