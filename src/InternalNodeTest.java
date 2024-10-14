public class InternalNodeTest {
    public static void main(String[] args) {
        testCreation();
        testInsert();
        testSearch();
        testDelete();
        testIntersects();
    }

    private static Seminar createSeminar(int id, short x, short y) {
        return new Seminar(id, "Test Seminar", "2023-01-01", 60, x, y, 100, new String[]{"test"}, "Test description");
    }

    public static void testCreation() {
        System.out.println("Testing InternalNode creation...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        @SuppressWarnings("unused")
        InternalNode node = new InternalNode(left, right, true, 0);
        System.out.println("InternalNode created successfully.");
        System.out.println();
    }

    public static void testInsert() {
        System.out.println("Testing InternalNode insert...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right, true, 0);
        
        BinNode result = node.insert(createSeminar(3, (short)3, (short)4));
        System.out.println("Insert result: " + (result instanceof InternalNode));
        System.out.println();
    }

    public static void testSearch() {
        System.out.println("Testing InternalNode search...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right, true, 0);
        
        Seminar result = node.search(2, 3);
        System.out.println("Search result: " + (result != null ? result.id() : "Not found"));
        System.out.println();
    }

    public static void testDelete() {
        System.out.println("Testing InternalNode delete...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right, true, 0);
        
        BinNode result = node.delete(2, 3);
        System.out.println("Delete result: " + (result instanceof LeafNode));
        System.out.println();
    }

    public static void testIntersects() {
        System.out.println("Testing InternalNode intersects...");
        LeafNode left = new LeafNode(createSeminar(1, (short)2, (short)3));
        LeafNode right = new LeafNode(createSeminar(2, (short)4, (short)5));
        InternalNode node = new InternalNode(left, right, true, 0);
        
        boolean result = node.intersects(3, 4, 2);
        System.out.println("Intersects result: " + result);
        System.out.println();
    }
}