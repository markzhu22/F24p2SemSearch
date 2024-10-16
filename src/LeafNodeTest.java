import org.junit.Before;
import org.junit.Test;

public class LeafNodeTest extends student.TestCase {
    private LeafNode leafNode;
    private Seminar seminar;

    @Before
    public void setUp() {
        seminar = new Seminar();
        seminar.setId(1);
        leafNode = new LeafNode(seminar);
    }


    @Test
    public void testConstructor() {
        assertEquals(seminar, leafNode.getSeminar());
    }


    @Test
    public void testIsLeaf() {
        assertTrue(leafNode.isLeaf());
    }


    @Test
    public void testGetSeminar() {
        assertEquals(seminar, leafNode.getSeminar());
    }


    @Test
    public void testGetLeft() {
        assertNull(leafNode.getLeft());
    }


    @Test
    public void testGetRight() {
        assertNull(leafNode.getRight());
    }


    @Test
    public void testSetLeft() {
        BinNode dummyNode = new LeafNode(new Seminar());
        leafNode.setLeft(dummyNode);
        // Ensure setLeft doesn't change anything
        assertNull(leafNode.getLeft());
    }


    @Test
    public void testSetRight() {
        BinNode dummyNode = new LeafNode(new Seminar());
        leafNode.setRight(dummyNode);
        // Ensure setRight doesn't change anything
        assertNull(leafNode.getRight());
    }


    @Test
    public void testIsSplitOnX() {
        assertFalse(leafNode.isSplitOnX());
    }


//    @Test
//    public void testToString() {
//        String expected = "Leaf with 1 objects: 1\n";
//        assertEquals(expected, leafNode.toString(0));
//
//        String expectedWithDepth = "    Leaf with 1 objects: 1\n";
//        assertEquals(expectedWithDepth, leafNode.toString(1));
//
//        String expectedWithMoreDepth = "        Leaf with 1 objects: 1\n";
//        assertEquals(expectedWithMoreDepth, leafNode.toString(2));
//    }
}
