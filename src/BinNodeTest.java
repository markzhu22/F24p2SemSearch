public class BinNodeTest {
    public static void main(String[] args) {
        testLeafNode();
        testInternalNode();
        testEmptyNode();
    }

    private static Seminar createSeminar(int id, short x, short y) {
        return new Seminar(id, "Test Seminar " + id, "2023-01-01", 60, x, y, 100, new String[]{"test"}, "Test description");
    }

    public static void testLeafNode() {
        System.out.println("Testing LeafNode as BinNode...");
        BinNode node = new LeafNode(createSeminar(1, (short)2, (short)3));
        testBinNodeMethods(node);
    }

    public static void testInternalNode() {
        System.out.println("Testing InternalNode as BinNode...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        BinNode node = new InternalNode(left, right, true);
        testBinNodeMethods(node);
    }

    public static void testEmptyNode() {
        System.out.println("Testing EmptyNode as BinNode...");
        BinNode node = EmptyNode.getInstance();
        testBinNodeMethods(node);
    }

    private static void testBinNodeMethods(BinNode node) {
        System.out.println("isLeaf: " + node.isLeaf());
        System.out.println("getMinX: " + node.getMinX());
        System.out.println("getMaxX: " + node.getMaxX());
        System.out.println("getMinY: " + node.getMinY());
        System.out.println("getMaxY: " + node.getMaxY());
        
        Seminar testSeminar = createSeminar(3, (short)3, (short)4);
        BinNode insertResult = node.insert(testSeminar);
        System.out.println("Insert result type: " + insertResult.getClass().getSimpleName());
        
        Seminar searchResult = node.search(3, 4);
        System.out.println("Search result: " + (searchResult != null ? searchResult.id() : "Not found"));
        
        BinNode deleteResult = node.delete(3, 4);
        System.out.println("Delete result type: " + deleteResult.getClass().getSimpleName());
        
        boolean intersectsResult = node.intersects(3, 4, 1);
        System.out.println("Intersects result: " + intersectsResult);
        
        System.out.println();
    }
}