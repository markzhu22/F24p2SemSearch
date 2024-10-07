import org.junit.Test;

/**
 * Test for BSTNode
 * 
 * @author markz + tarinid
 * @version Oct 4, 2024
 */
public class BSTNodeTest
    extends student.TestCase
{
    private Seminar seminar1;
    private Seminar seminar2;
    private BSTNode node1;
    private BSTNode node2;
    private BSTNode nodeWithChildren;

    // ----------------------------------------------------------
    /**
     * Set Up
     */
    public void setUp()
    {
        seminar1 = new Seminar(
            1,
            "Seminar 1",
            "20230101",
            90,
            (short)10,
            (short)10,
            50,
            new String[] { "AI" },
            "Description 1");
        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "20230201",
            60,
            (short)20,
            (short)20,
            100,
            new String[] { "ML" },
            "Description 2");

        node1 = new BSTNode(seminar1, seminar1);
        node2 = new BSTNode(seminar2, seminar2);
        nodeWithChildren = new BSTNode(seminar1, node1, node2, seminar1);
    }


    // ----------------------------------------------------------
    /**
     * Test constructor
     */
    public void testDefaultConstructor()
    {
        BSTNode emptyNode = new BSTNode();
        // assertNull(emptyNode.value());
        assertNull(emptyNode.left());
        assertNull(emptyNode.right());
        assertTrue(emptyNode.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests loaded nodes
     */
    public void testConstructorWithValue()
    {
        // assertEquals(seminar1, node1.value());
        assertNull(node1.left());
        assertNull(node1.right());
        assertTrue(node1.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests nodes with children
     */
    public void testConstructorWithChildren()
    {
        // assertEquals(seminar1, nodeWithChildren.value());
        assertEquals(node1, nodeWithChildren.left());
        assertEquals(node2, nodeWithChildren.right());
        assertFalse(nodeWithChildren.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests getter and setter for value
     */
    public void testSetAndGetValue()
    {
        node1.setValue(seminar2);
        // assertEquals(seminar2, node1.value());
    }


    // ----------------------------------------------------------
    /**
     * Tests getter and setter for left child
     */
    public void testSetAndGetLeftChild()
    {
        node1.setLeft(node2);
        assertEquals(node2, node1.left());
    }


    // ----------------------------------------------------------
    /**
     * Tests getter and setter for right child
     */
    public void testSetAndGetRightChild()
    {
        node1.setRight(node2);
        assertEquals(node2, node1.right());
    }


    // ----------------------------------------------------------
    /**
     * Tests checker for leaf
     */
    public void testIsLeaf()
    {
        assertTrue(node1.isLeaf());
        assertFalse(nodeWithChildren.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests if leaf when it has no children
     */
    public void testIsLeafWhenNoChildren()
    {
        assertTrue(node1.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests if leaf when it has only right child
     */
    public void testIsLeafWhenOnlyRightChild()
    {
        BSTNode nodeWithRightChild = new BSTNode(seminar1, seminar1);
        nodeWithRightChild.setRight(node2);
        assertFalse(nodeWithRightChild.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests if leaf when it has only left child
     */
    public void testIsLeafWhenOnlyLeftChild()
    {
        BSTNode nodeWithLeftChild = new BSTNode(seminar1, seminar1);
        nodeWithLeftChild.setLeft(node2);
        assertFalse(nodeWithLeftChild.isLeaf());
    }


    // ----------------------------------------------------------
    /**
     * Tests if leaf when it has both children
     */
    public void testIsLeafWhenBothChildren()
    {
        assertFalse(nodeWithChildren.isLeaf());
    }
    
    @Test
    public void testSemValue() {
        BSTNode seminarNode = new BSTNode(seminar1, seminar1);
        assertEquals(seminar1, seminarNode.semValue());
    }

    @Test
    public void testStringValue() {
        BSTNode stringNode = new BSTNode("AI", seminar1);
        assertEquals("AI", stringNode.stringValue());
    }

    @Test(expected = ClassCastException.class)
    public void testSemValueException() {
        BSTNode stringNode = new BSTNode("AI", seminar1);
        stringNode.semValue();
    }

    @Test(expected = ClassCastException.class)
    public void testStringValueException() {
        BSTNode seminarNode = new BSTNode(seminar1, seminar1);
        seminarNode.stringValue();
    }
    
    @Test
    public void testSetStringValue() {
        BSTNode stringNode = new BSTNode("AI", seminar1);
        stringNode.setStringValue("ML");
        assertEquals("ML", stringNode.stringValue());
    }
    
  
}
