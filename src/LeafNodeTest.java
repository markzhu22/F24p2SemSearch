public class LeafNodeTest {
    public void main(String[] args) {
        testCreation();
        testInsert();
        testSearch();
        testDelete();
        testIntersects();
        testIsLeaf();
        testGetSetLeft();
        testGetSetRight();
        testTraverse();
    }

    private static Seminar createSeminar(int id, short x, short y) {
        return new Seminar(id, "Test Seminar", "2023-01-01", 60, x, y, 100, new String[]{"test"}, "Test description");
    }

    public static void testCreation() {
        System.out.println("Testing LeafNode creation...");
        @SuppressWarnings("unused")
        LeafNode node = new LeafNode(createSeminar(1, (short)2, (short)3));
        System.out.println("LeafNode created successfully.");
        System.out.println();
    }

    public static void testInsert() {
        System.out.println("Testing LeafNode insert...");
        LeafNode node = new LeafNode(createSeminar(1, (short)2, (short)3));
        BinNode result = node.insert(createSeminar(2, (short)4, (short)5));
        System.out.println("Insert result: " + (result instanceof InternalNode));
        System.out.println();
    }

    public static void testSearch() {
        System.out.println("Testing LeafNode search...");
        LeafNode node = new LeafNode(createSeminar(1, (short)2, (short)3));
        Seminar result = node.search(2, 3);
        System.out.println("Search result: " + (result != null ? result.id() : "Not found"));
        System.out.println();
    }

    public static void testDelete() {
        System.out.println("Testing LeafNode delete...");
        LeafNode node = new LeafNode(createSeminar(1, (short)2, (short)3));
        BinNode result = node.delete(2, 3);
        System.out.println("Delete result: " + (result instanceof EmptyNode));
        System.out.println();
    }

    public static void testIntersects() {
        System.out.println("Testing LeafNode intersects...");
        LeafNode node = new LeafNode(createSeminar(1, (short)2, (short)3));
        boolean result = node.intersects(2, 3, 1);
        System.out.println("Intersects result: " + result);
        System.out.println();
    }

    public static void testIsLeaf() {
        System.out.println("Testing InternalNode isLeaf...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right, true);
        boolean result = node.isLeaf();
        System.out.println("IsLeaf result: " + result);
        System.out.println();
    }

    public static void testGetSetLeft() {
        System.out.println("Testing InternalNode getLeft and setLeft...");
        LeafNode left1 = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left1, right, true);
        
        BinNode originalLeft = node.getLeft();
        System.out.println("Original left node: " + (originalLeft instanceof LeafNode));
        
        LeafNode left2 = new LeafNode(createSeminar(3, (short)1, (short)1));
        node.setLeft(left2);
        BinNode newLeft = node.getLeft();
        System.out.println("New left node: " + (newLeft instanceof LeafNode));
        System.out.println("Left node changed: " + (originalLeft != newLeft));
        System.out.println();
    }

    public static void testGetSetRight() {
        System.out.println("Testing InternalNode getRight and setRight...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right1 = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right1, true);
        
        BinNode originalRight = node.getRight();
        System.out.println("Original right node: " + (originalRight instanceof LeafNode));
        
        LeafNode right2 = new LeafNode(createSeminar(3, (short)6, (short)6));
        node.setRight(right2);
        BinNode newRight = node.getRight();
        System.out.println("New right node: " + (newRight instanceof LeafNode));
        System.out.println("Right node changed: " + (originalRight != newRight));
        System.out.println();
    }

    public static void testTraverse() {
        System.out.println("Testing InternalNode traverse...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right, true);
        
        System.out.println("Calling traverse method:");
        node.traverse();
        System.out.println("Traverse method called.");
        System.out.println();
    }

}