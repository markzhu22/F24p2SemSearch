import java.util.List;

public class BinTreeTest extends student.TestCase {
    private BinTree tree;

    public void setUp() {
        tree = new BinTree();
    }

    public void testInsertAndSize() {
        assertTrue("Tree should be empty initially", tree.isEmpty());
        assertEquals("Initial size should be 0", 0, tree.size());
    
        Seminar s1 = new Seminar();
        tree.insert(s1);
        System.out.println("After inserting first seminar:");
        System.out.println("Tree isEmpty: " + tree.isEmpty());
        System.out.println("Tree size: " + tree.size());
        System.out.println("Tree toString: " + tree.toString());
        
        assertFalse("Tree should not be empty after insertion", tree.isEmpty());
        assertEquals("Size should be 1 after insertion", 1, tree.size());
    
        Seminar s2 = new Seminar();
        tree.insert(s2);
        System.out.println("After inserting second seminar:");
        System.out.println("Tree isEmpty: " + tree.isEmpty());
        System.out.println("Tree size: " + tree.size());
        System.out.println("Tree toString: " + tree.toString());
        
        assertEquals("Size should be 2 after second insertion", 2, tree.size());
    }

    public void testSearch() {
        Seminar s1 = new Seminar();
        s1.setId(1);  // Assuming there's a setId method
        Seminar s2 = new Seminar();
        s2.setId(2);  // Assuming there's a setId method
        tree.insert(s1);
        tree.insert(s2);
    
        Seminar found1 = tree.search(1);
        Seminar found2 = tree.search(2);
    
        assertNotNull("Search for seminar 1 should not return null", found1);
        assertNotNull("Search for seminar 2 should not return null", found2);
        assertEquals("ID of found seminar 1 should match", 1, found1.getId());
        assertEquals("ID of found seminar 2 should match", 2, found2.getId());
        assertNull("Search for non-existent seminar should return null", tree.search(3));
    }

    public void testSearchWithinRadius() {
        Seminar s1 = new Seminar();
        s1.setX(0);
        s1.setY(0);
        Seminar s2 = new Seminar();
        s2.setX(1);
        s2.setY(1);
        Seminar s3 = new Seminar();
        s3.setX(10);
        s3.setY(10);

        tree.insert(s1);
        tree.insert(s2);
        tree.insert(s3);

        List<Seminar> results = tree.searchWithinRadius(0, 0, 2);
        assertEquals(2, results.size());
        assertTrue(results.contains(s1));
        assertTrue(results.contains(s2));
        assertFalse(results.contains(s3));
    }

    public void testDelete() {
        Seminar s1 = new Seminar();
        s1.setX(0);
        s1.setY(0);
        s1.setId(1);
        Seminar s2 = new Seminar();
        s2.setX(1);
        s2.setY(1);
        s2.setId(2);

        System.out.println("Initial tree size: " + tree.size());

        tree.insert(s1);
        System.out.println("Tree size after inserting s1: " + tree.size());
        System.out.println("Tree after inserting s1: " + tree.toString());

        tree.insert(s2);
        System.out.println("Tree size after inserting s2: " + tree.size());
        System.out.println("Tree after inserting s2: " + tree.toString());

        assertEquals("Tree size should be 2 after inserting two seminars", 2, tree.size());

        tree.delete(0, 0);
        System.out.println("Tree size after deleting (0,0): " + tree.size());
        System.out.println("Tree after deleting (0,0): " + tree.toString());

        assertEquals("Tree size should be 1 after deleting one seminar", 1, tree.size());
        assertNull("Search for deleted seminar should return null", tree.search(s1.getId()));
        assertNotNull("Search for remaining seminar should not return null", tree.search(s2.getId()));
    }

    public void testNodesVisited() {
        tree.insert(new Seminar());
        tree.insert(new Seminar());
        tree.insert(new Seminar());

        tree.searchWithinRadius(0, 0, 2);
        assertTrue(tree.getNodesVisited() > 0);

        tree.resetNodesVisited();
        assertEquals(0, tree.getNodesVisited());
    }

    public void testToString() {
        assertEquals("Location Tree:\n(E)\n", tree.toString());

        Seminar s1 = new Seminar();
        tree.insert(s1);
        String expected = "Location Tree:\n(Leaf with 1 objects: " + s1.getId() + ")\n";
        assertEquals(expected, tree.toString());

        Seminar s2 = new Seminar();
        tree.insert(s2);
        expected = "Location Tree:\n(I)\n    (Leaf with 1 objects: " + s1.getId() + ")\n    (Leaf with 1 objects: " + s2.getId() + ")\n";
        assertEquals(expected, tree.toString());
    }
}