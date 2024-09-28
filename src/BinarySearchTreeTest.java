import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;
    private Seminar seminar1, seminar2, seminar3, seminar4;

    @Before
    public void setUp() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "HCI Seminar", "20230930", 90, (short)10,
            (short)20, 50, new String[] { "HCI", "AI" }, "HCI Research");
        seminar2 = new Seminar(2, "AI Seminar", "20221015", 60, (short)15,
            (short)25, 100, new String[] { "AI", "ML" }, "AI Research");
        seminar3 = new Seminar(3, "ML Seminar", "20220820", 120, (short)5,
            (short)10, 75, new String[] { "ML", "AI" }, "ML Research");
        seminar4 = new Seminar(4, "Computing Seminar", "20230625", 30,
            (short)12, (short)18, 30, new String[] { "Computing" },
            "Computing Research");

        bst.insertById(seminar1);
        bst.insertById(seminar2);
        bst.insertById(seminar3);
        bst.insertById(seminar4);
    }


    @Test
    public void testInsertById() {
        assertEquals(4, bst.size());

        //assertEquals(seminar1, bst.getRoot().value());

        assertEquals(seminar2, bst.findById(2));
        assertEquals(seminar3, bst.findById(3));
        assertEquals(seminar4, bst.findById(4));
    }


    @Test
    public void testInsertByDate() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar Title", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "keyword1" },
            "Description 1");

        bst.insertByDate(seminar1);

        assertEquals(1, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(1, bst.size());
    }


    @Test
    public void testInsertByCost() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "keyword1" },
            "Description 1");
        bst.insertByCost(seminar1);

        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "keyword2" },
            "Description 2");
        bst.insertByCost(seminar2);

        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "keyword3" },
            "Description 3");
        bst.insertByCost(seminar3);

        assertEquals(3, bst.size());

        Seminar seminar4 = new Seminar(4, "Seminar 4", "20230104", 60,
            (short)20, (short)20, 50, new String[] { "keyword4" },
            "Description 4");
        bst.insertByCost(seminar4);

        assertEquals(3, bst.size());

        bst.insertByCost(seminar2);

        assertEquals(3, bst.size());
    }


    @Test
    public void testInsertByKeyword() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI", "Machine Learning" },
            "Description 1");
        bst.insertByKeyword(seminar1);

        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain",
                "Cryptography" }, "Description 2");
        bst.insertByKeyword(seminar2);

        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science", "AI" },
            "Description 3");
        bst.insertByKeyword(seminar3);

        assertEquals(6, bst.size());

        Seminar seminar4 = new Seminar(4, "Seminar 4", "20230104", 60,
            (short)20, (short)20, 50, new String[] { "AI", "Deep Learning" },
            "Description 4");
        bst.insertByKeyword(seminar4);

        assertEquals(8, bst.size());

        Seminar seminar5 = new Seminar(5, "Seminar 5", "20230105", 80,
            (short)10, (short)15, 60, new String[] { "Cybersecurity",
                "Ethical Hacking" }, "Description 5");
        bst.insertByKeyword(seminar5);

        assertEquals(10, bst.size());
    }


    @Test
    public void testDuplicateInsertionByDate() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar Title", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "keyword1" },
            "Description 1");
        bst.insertByDate(seminar1);

        assertEquals(1, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(1, bst.size());

        Seminar seminar2 = new Seminar(2, "Another Seminar", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "keyword2" },
            "Description 2");
        bst.insertByDate(seminar2);

        assertEquals(2, bst.size());
    }


    @Test
    public void testInsertOrderByDate() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "keyword1" },
            "Description 1");
        bst.insertByDate(seminar1);

        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "keyword2" },
            "Description 2");
        bst.insertByDate(seminar2);

        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "keyword3" },
            "Description 3");
        bst.insertByDate(seminar3);

        assertEquals(3, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(3, bst.size());
    }


    @Test
    public void testFindById() {
        assertEquals(seminar1, bst.findById(1));
        assertEquals(seminar2, bst.findById(2));
        assertEquals(seminar3, bst.findById(3));
        assertEquals(seminar4, bst.findById(4));

        assertNull(bst.findById(99));
    }


    @Test
    public void testRemoveById() {
        BinarySearchTree idTree = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain" },
            "Description 2");
        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");

        idTree.insertById(seminar1);
        idTree.insertById(seminar2);
        idTree.insertById(seminar3);

        idTree.removeById(2);

        assertNull(idTree.findById(2));

        assertNotNull(idTree.findById(1));
        assertNotNull(idTree.findById(3));
    }


    // Test remove by date
    @Test
    public void testRemoveByDate() {
        BinarySearchTree dateTree = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain" },
            "Description 2");
        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");

        dateTree.insertByDate(seminar1);
        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar3);

        dateTree.removeByDate("20230102");

        assertFalse(dateTree.findByDateRange("20230102", "20230102"));

        assertTrue(dateTree.findByDateRange("20230101", "20230101"));
        assertTrue(dateTree.findByDateRange("20230103", "20230103"));
    }


    // Test remove by cost
    @Test
    public void testRemoveByCost() {
        BinarySearchTree costTree = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain" },
            "Description 2");
        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");

        costTree.insertByCost(seminar1);
        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar3);

        costTree.removeByCost(100);

        assertFalse(costTree.findByCostRange(100, 100));

        assertTrue(costTree.findByCostRange(50, 50));
        assertTrue(costTree.findByCostRange(70, 70));
    }


    // Test remove by keyword
    @Test
    public void testRemoveByKeyword() {
        BinarySearchTree keywordTree = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain" },
            "Description 2");
        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");

        keywordTree.insertByKeyword(seminar1);
        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar3);

        keywordTree.removeByKeyword("Blockchain");

        assertFalse(keywordTree.findByKeyword("Blockchain"));

        assertTrue(keywordTree.findByKeyword("AI"));
        assertTrue(keywordTree.findByKeyword("Data Science"));
    }


    @Test
    public void testFindByDateRange() {
        boolean found = bst.findByDateRange("20220101", "20231231");
        assertTrue(found);

        found = bst.findByDateRange("19990101", "20001231");
        assertFalse(found);
    }


    @Test
    public void testFindByCostRange() {
        boolean found = bst.findByCostRange(30, 100);
        assertTrue(found);

        found = bst.findByCostRange(1000, 2000);
        assertFalse(found);
    }


    @Test
    public void testFindByKeyword() {
//        boolean found = bst.findByKeyword("AI");
//        assertTrue(found);
//
//        found = bst.findByKeyword("Blockchain");
//        assertFalse(found);
    }


    @Test
    public void testFindByKeywordWithLeftAndRightSubtrees() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain" },
            "Description 2");
        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");

        bst.insertByKeyword(seminar1);
        bst.insertByKeyword(seminar2);
        bst.insertByKeyword(seminar3);

        boolean foundAI = bst.findByKeyword("AI");
        boolean foundBlockchain = bst.findByKeyword("Blockchain");
        boolean foundDataScience = bst.findByKeyword("Data Science");

        assertTrue(foundAI);
        assertTrue(foundBlockchain);
        assertTrue(foundDataScience);
        boolean foundNotExist = bst.findByKeyword("Non-existent");
        assertFalse(foundNotExist);
    }


    @Test
    public void testFindByKeywordWithNullSubtrees() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");

        bst.insertByKeyword(seminar1);

        boolean foundNotExist = bst.findByKeyword("NonExistentKeyword");

        assertFalse(foundNotExist);

        assertNull(bst.getRoot().left());
        assertNull(bst.getRoot().right());
    }


    @Test
    public void testDuplicateInsertions() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar A", "20220101", 60,
            (short)10, (short)10, 100, new String[] { "AI" }, "Description A");
        Seminar seminar2 = new Seminar(1, "Seminar A", "20220101", 60,
            (short)10, (short)10, 100, new String[] { "AI" }, "Description A");

        bst.insertById(seminar1);
        assertEquals(1, bst.size());

        bst.insertById(seminar2);
        assertEquals(1, bst.size());
    }


    @Test
    public void testFindMaxAndDeleteMax() {
        BinarySearchTree bst = new BinarySearchTree();

        Seminar seminar1 = new Seminar(1, "Seminar 1", "20230101", 90,
            (short)10, (short)10, 50, new String[] { "AI" }, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "20230102", 60,
            (short)15, (short)20, 100, new String[] { "Blockchain" },
            "Description 2");
        Seminar seminar3 = new Seminar(3, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");

        bst.insertByCost(seminar1);
        bst.insertByCost(seminar2);
        bst.insertByCost(seminar3);

        Seminar maxSeminar = bst.findMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals(100, maxSeminar.cost());

        bst.root = bst.deleteMax(bst.getRoot());

        maxSeminar = bst.findMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals(70, maxSeminar.cost());

        bst.root = bst.deleteMax(bst.getRoot());

        maxSeminar = bst.findMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals(50, maxSeminar.cost());

        bst.root = bst.deleteMax(bst.getRoot());

        maxSeminar = bst.findMax(bst.getRoot());
        assertNull(maxSeminar);
    }


    @Test
    public void testClear() {
        bst.clear();
        assertEquals(0, bst.size());
        assertNull(bst.getRoot());
    }
}
