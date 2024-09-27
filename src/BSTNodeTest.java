import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BSTNodeTest {
    private Seminar seminar1;
    private Seminar seminar2;
    private BSTNode node1;
    private BSTNode node2;
    private BSTNode nodeWithChildren;

    @Before
    public void setUp() {
        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230201", 60, (short)20,
            (short)20, 100, new String[] { "ML" }, "Description 2");

        node1 = new BSTNode(seminar1);
        node2 = new BSTNode(seminar2);
        nodeWithChildren = new BSTNode(seminar1, node1, node2);
    }


    @Test
    public void testDefaultConstructor() {
        BSTNode emptyNode = new BSTNode();
        assertNull(emptyNode.value());
        assertNull(emptyNode.left());
        assertNull(emptyNode.right());
        assertTrue(emptyNode.isLeaf());
    }


    @Test
    public void testConstructorWithValue() {
        assertEquals(seminar1, node1.value());
        assertNull(node1.left());
        assertNull(node1.right());
        assertTrue(node1.isLeaf());
    }


    @Test
    public void testConstructorWithChildren() {
        assertEquals(seminar1, nodeWithChildren.value());
        assertEquals(node1, nodeWithChildren.left());
        assertEquals(node2, nodeWithChildren.right());
        assertFalse(nodeWithChildren.isLeaf());
    }


    @Test
    public void testSetAndGetValue() {
        node1.setValue(seminar2);
        assertEquals(seminar2, node1.value());
    }


    @Test
    public void testSetAndGetLeftChild() {
        node1.setLeft(node2);
        assertEquals(node2, node1.left());
    }


    @Test
    public void testSetAndGetRightChild() {
        node1.setRight(node2);
        assertEquals(node2, node1.right());
    }


    @Test
    public void testIsLeaf() {
        assertTrue(node1.isLeaf());
        assertFalse(nodeWithChildren.isLeaf());
    }


    @Test
    public void testIsLeafWhenNoChildren() {
        assertTrue(node1.isLeaf());
    }


    @Test
    public void testIsLeafWhenOnlyRightChild() {
        BSTNode nodeWithRightChild = new BSTNode(seminar1);
        nodeWithRightChild.setRight(node2);
        assertFalse(nodeWithRightChild.isLeaf());
    }


    @Test
    public void testIsLeafWhenOnlyLeftChild() {
        BSTNode nodeWithLeftChild = new BSTNode(seminar1);
        nodeWithLeftChild.setLeft(node2);
        assertFalse(nodeWithLeftChild.isLeaf());
    }


    @Test
    public void testIsLeafWhenBothChildren() {
        assertFalse(nodeWithChildren.isLeaf());
    }
}
