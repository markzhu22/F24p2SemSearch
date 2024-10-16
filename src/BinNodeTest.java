import org.junit.Before;
import org.junit.Test;

public class BinNodeTest extends student.TestCase {

    private BinNode node;
    private BinNode leftChild;
    private BinNode rightChild;
    private Seminar seminar;

    @Before
    public void setUp() {
        seminar = new Seminar(1, "Test Seminar", "20240101", 60, (short)10, (short)20, 100, new String[]{"Test"}, "Test Description");
        
    
//        node = new InternalNode(null, null, true); 
//        leftChild = new LeafNode(seminar); 
//        rightChild = new LeafNode(null);
        
        
        node.setLeft(leftChild);
        node.setRight(rightChild);
    }

    @Test
    public void testIsLeaf() {
        assertFalse(node.isLeaf());
        assertTrue(leftChild.isLeaf());
        assertTrue(rightChild.isLeaf());
    }

    @Test
    public void testGetSeminar() {
        assertNull(node.getSeminar()); // Internal nodes don't have seminars
        assertEquals(seminar, leftChild.getSeminar());
        assertNull(rightChild.getSeminar());
    }

    @Test
    public void testGetLeft() {
        assertEquals(leftChild, node.getLeft());
    }

    @Test
    public void testGetRight() {
        assertEquals(rightChild, node.getRight());
    }

    @Test
    public void testIsSplitOnX() {
        assertTrue(node.isSplitOnX());
        // Leaf nodes don't have a split, so we shouldn't test isSplitOnX for them
    }
}