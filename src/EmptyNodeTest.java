import org.junit.Test;

public class EmptyNodeTest extends student.TestCase{

    @Test
    public void testSingleton() {
        EmptyNode node1 = EmptyNode.getInstance();
        EmptyNode node2 = EmptyNode.getInstance();
        assertSame("getInstance should always return the same instance", node1, node2);
    }

    @Test
    public void testIsLeaf() {
        EmptyNode node = EmptyNode.getInstance();
        assertFalse("EmptyNode should not be considered a leaf", node.isLeaf());
    }

    @Test
    public void testGetSeminar() {
        EmptyNode node = EmptyNode.getInstance();
        assertNull("getSeminar should return null for EmptyNode", node.getSeminar());
    }

    @Test
    public void testGetLeft() {
        EmptyNode node = EmptyNode.getInstance();
        assertNull("getLeft should return null for EmptyNode", node.getLeft());
    }

    @Test
    public void testGetRight() {
        EmptyNode node = EmptyNode.getInstance();
        assertNull("getRight should return null for EmptyNode", node.getRight());
    }

    @Test
    public void testSetLeft() {
        EmptyNode node = EmptyNode.getInstance();
        BinNode dummyNode = new LeafNode(new Seminar()); // Assuming LeafNode exists
        node.setLeft(dummyNode);
        // No assertion needed, just making sure it doesn't throw an exception
    }

    @Test
    public void testSetRight() {
        EmptyNode node = EmptyNode.getInstance();
        BinNode dummyNode = new LeafNode(new Seminar()); // Assuming LeafNode exists
        node.setRight(dummyNode);
        // No assertion needed, just making sure it doesn't throw an exception
    }

    @Test
    public void testIsSplitOnX() {
        EmptyNode node = EmptyNode.getInstance();
        assertFalse("isSplitOnX should always return false for EmptyNode", node.isSplitOnX());
    }

   
}