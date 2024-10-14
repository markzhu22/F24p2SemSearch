public class EmptyNodeTest {
    public static void main(String[] args) {
        testCreation();
        testInsert();
        testSearch();
        testDelete();
        testIntersects();
        testGetSeminar();
        testGetMinX();
        testGetMinY();
        testGetMaxX();
        testGetMaxY();
        testIsLeaf();
        testTraverse();
    }


    private static Seminar createSeminar(int id, short x, short y) {
        Seminar seminar = new Seminar();
        seminar.setId(id);
        seminar.setX(x);
        seminar.setY(y);
        seminar.addKeyword("test");
        return seminar;
    }


    public static void testCreation() {
        System.out.println("Testing EmptyNode creation...");
        @SuppressWarnings("unused")
        EmptyNode node = EmptyNode.getInstance();
        System.out.println("EmptyNode created successfully.");
        System.out.println();
    }


    public static void testInsert() {
        System.out.println("Testing EmptyNode insert...");
        EmptyNode node = EmptyNode.getInstance();
        BinNode result = node.insert(createSeminar(1, (short)2, (short)3), 0);
        System.out.println("Insert result: " + (result instanceof LeafNode));
        System.out.println();
    }


    public static void testSearch() {
        System.out.println("Testing EmptyNode search...");
        EmptyNode node = EmptyNode.getInstance();
        Seminar result = node.search(2, 3);
        System.out.println("Search result: " + (result == null
            ? "Not found"
            : result.id()));
        System.out.println();
    }


    public static void testDelete() {
        System.out.println("Testing EmptyNode delete...");
        EmptyNode node = EmptyNode.getInstance();
        BinNode result = node.delete(2, 3);
        System.out.println("Delete result: " + (result instanceof EmptyNode));
        System.out.println();
    }


    public static void testIntersects() {
        System.out.println("Testing EmptyNode intersects...");
        EmptyNode node = EmptyNode.getInstance();
        boolean result = node.intersects(2, 3, 1);
        System.out.println("Intersects result: " + result);
        System.out.println();
    }


    public static void testGetSeminar() {
        System.out.println("Testing EmptyNode getSeminar...");
        EmptyNode node = EmptyNode.getInstance();
        Seminar result = node.getSeminar();
        System.out.println("GetSeminar result: " + (result == null
            ? "null"
            : "not null"));
        System.out.println();
    }


    public static void testGetMinX() {
        System.out.println("Testing EmptyNode getMinX...");
        EmptyNode node = EmptyNode.getInstance();
        double result = node.getMinX();
        System.out.println("GetMinX result: "
            + (result == Double.POSITIVE_INFINITY
                ? "POSITIVE_INFINITY"
                : result));
        System.out.println();
    }


    public static void testGetMinY() {
        System.out.println("Testing EmptyNode getMinY...");
        EmptyNode node = EmptyNode.getInstance();
        double result = node.getMinY();
        System.out.println("GetMinY result: "
            + (result == Double.POSITIVE_INFINITY
                ? "POSITIVE_INFINITY"
                : result));
        System.out.println();
    }


    public static void testGetMaxX() {
        System.out.println("Testing EmptyNode getMaxX...");
        EmptyNode node = EmptyNode.getInstance();
        double result = node.getMaxX();
        System.out.println("GetMaxX result: "
            + (result == Double.NEGATIVE_INFINITY
                ? "NEGATIVE_INFINITY"
                : result));
        System.out.println();
    }


    public static void testGetMaxY() {
        System.out.println("Testing EmptyNode getMaxY...");
        EmptyNode node = EmptyNode.getInstance();
        double result = node.getMaxY();
        System.out.println("GetMaxY result: "
            + (result == Double.NEGATIVE_INFINITY
                ? "NEGATIVE_INFINITY"
                : result));
        System.out.println();
    }


    public static void testIsLeaf() {
        System.out.println("Testing EmptyNode isLeaf...");
        EmptyNode node = EmptyNode.getInstance();
        boolean result = node.isLeaf();
        System.out.println("IsLeaf result: " + result);
        System.out.println();
    }


    public static void testTraverse() {
        System.out.println("Testing EmptyNode traverse...");
        EmptyNode node = EmptyNode.getInstance();
        System.out.println("Calling traverse method (should do nothing):");
        node.traverse();
        System.out.println("Traverse method called.");
        System.out.println();
    }
}
