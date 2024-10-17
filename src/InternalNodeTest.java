import org.junit.Before;
import org.junit.Test;

public class InternalNodeTest extends student.TestCase {

    private InternalNode node;
    private BinNode leftChild;
    private BinNode rightChild;
    private Seminar leftSeminar;
    private Seminar rightSeminar;

    @Before
    public void setUp() {
        leftSeminar = new Seminar();
        leftSeminar.setId(2); // Seminar with ID 2 is now the left child
        rightSeminar = new Seminar();
        rightSeminar.setId(1); // Seminar with ID 1 is now the right child
        leftChild = new LeafNode(leftSeminar);
        rightChild = new LeafNode(rightSeminar);
        node = new InternalNode(leftChild, rightChild, true, 0);
    }


    @Test
    public void testConstructor() {
        assertEquals(leftChild, node.getLeft());
        assertEquals(rightChild, node.getRight());
        assertTrue(node.isSplitOnX());
    }


    @Test
    public void testIsLeaf() {
        assertFalse(node.isLeaf());
    }


    @Test
    public void testGetSeminar() {
        assertNull(node.getSeminar());
    }


    @Test
    public void testGetLeft() {
        assertEquals(leftChild, node.getLeft());
    }


    @Test
    public void testSetLeft() {
        BinNode newLeft = new LeafNode(new Seminar());
        node.setLeft(newLeft);
        assertEquals(newLeft, node.getLeft());
    }


    @Test
    public void testGetRight() {
        assertEquals(rightChild, node.getRight());
    }


    @Test
    public void testSetRight() {
        BinNode newRight = new LeafNode(new Seminar());
        node.setRight(newRight);
        assertEquals(newRight, node.getRight());
    }


    @Test
    public void testIsSplitOnX() {
        assertTrue(node.isSplitOnX());

//        InternalNode nodeY = new InternalNode(leftChild, rightChild, false);
//        assertFalse(nodeY.isSplitOnX());
    }


//    @Test
//    public void testToString() {
//        String expected =
//            "I\n    Leaf with 1 object(s): 1\n    Leaf with 1 object(s): 2\n";
//        assertEquals(expected, node.toString(0));
//
//        String expectedWithDepth =
//            "    I\n        Leaf with 1 object(s): 1\n        Leaf with 1 object(s): 2\n";
//        assertEquals(expectedWithDepth, node.toString(1));
//    }

}
