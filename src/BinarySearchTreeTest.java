// -------------------------------------------------------------------------
/**
 * Test class for BinarySearchTree
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class BinarySearchTreeTest extends student.TestCase {
    private BinarySearchTree bst;
    private Seminar seminar1, seminar2, seminar3, seminar4;

    public void setUp() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar();
        seminar1.setId(1);
        seminar1.setX((short)10);
        seminar1.setY((short)20);
        seminar1.setCost(50);
        seminar1.setKeywords(new String[] { "HCI", "AI" });
        seminar1.setDescription("HCI Research");

        seminar2 = new Seminar();
        seminar2.setId(2);
        seminar2.setTitle("AI Seminar");
        seminar2.setDate("20221015");
        seminar2.setLength(60);
        seminar2.setX((short)15);
        seminar2.setY((short)25);
        seminar2.setCost(100);
        seminar2.setKeywords(new String[] { "AI", "ML" });
        seminar2.setDescription("AI Research");

        seminar3 = new Seminar();
        seminar3.setId(3);
        seminar3.setTitle("ML Seminar");
        seminar3.setDate("20220820");
        seminar3.setLength(120);
        seminar3.setX((short)5);
        seminar3.setY((short)10);
        seminar3.setCost(75);
        seminar3.setKeywords(new String[] { "ML", "AI" });
        seminar3.setDescription("ML Research");

        seminar4 = new Seminar();
        seminar4.setId(4);
        seminar4.setTitle("Computing Seminar");
        seminar4.setDate("20230625");
        seminar4.setLength(30);
        seminar4.setX((short)12);
        seminar4.setY((short)18);
        seminar4.setCost(30);
        seminar4.setKeywords(new String[] { "Computing" });
        seminar4.setDescription("Computing Research");

        bst.insertById(seminar1);
        bst.insertById(seminar2);
        bst.insertById(seminar3);
        bst.insertById(seminar4);
    }


    // ----------------------------------------------------------
    /**
     * Test inserting ID
     */
    public void testInsertById() {
        assertEquals(4, bst.size());

        // assertEquals(seminar1, bst.getRoot().value());

        assertEquals(seminar2, bst.findById(2));
        assertEquals(seminar3, bst.findById(3));
        assertEquals(seminar4, bst.findById(4));
    }


    // ----------------------------------------------------------
    /**
     * Test inserting date
     */
    public void testInsertByDate() {
        bst = new BinarySearchTree();

        Seminar seminarWithDate = new Seminar();
        seminarWithDate.setId(1);
        seminarWithDate.setTitle("Test Seminar");
        seminarWithDate.setDate("20230101"); // Make sure to set the date
        seminarWithDate.setLength(60);
        seminarWithDate.setX((short)10);
        seminarWithDate.setY((short)10);
        seminarWithDate.setCost(50);
        seminarWithDate.setKeywords(new String[] { "Test" });
        seminarWithDate.setDescription("Test Description");

        bst.insertByDate(seminarWithDate);

        assertEquals(1, bst.size());

        Seminar anotherSeminar = new Seminar();
        anotherSeminar.setId(2);
        anotherSeminar.setTitle("Another Test Seminar");
        anotherSeminar.setDate("20230102"); // Make sure to set the date
        anotherSeminar.setLength(90);
        anotherSeminar.setX((short)15);
        anotherSeminar.setY((short)15);
        anotherSeminar.setCost(75);
        anotherSeminar.setKeywords(new String[] { "Another", "Test" });
        anotherSeminar.setDescription("Another Test Description");

        bst.insertByDate(anotherSeminar);

        assertEquals(2, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test inserting cost
     */
    public void testInsertByCost() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "keyword1" }, "Description 1");
        bst.insertByCost(seminar1);

        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "keyword2" }, "Description 2");
        bst.insertByCost(seminar2);

        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "keyword3" }, "Description 3");
        bst.insertByCost(seminar3);

        assertEquals(3, bst.size());

        seminar4 = new Seminar(4, "Seminar 4", "20230104", 60, (short)20,
            (short)20, 50, new String[] { "keyword4" }, "Description 4");
        bst.insertByCost(seminar4);

        assertEquals(4, bst.size());

        bst.insertByCost(seminar2);

        assertEquals(5, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test inserting keyword
     */
    public void testInsertByKeyword() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI", "Machine Learning" },
            "Description 1");
        bst.insertByKeyword(seminar1);

        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain", "Cryptography" },
            "Description 2");
        bst.insertByKeyword(seminar2);

        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science", "AI" },
            "Description 3");
        bst.insertByKeyword(seminar3);

        assertEquals(6, bst.size());

        seminar4 = new Seminar(4, "Seminar 4", "20230104", 60, (short)20,
            (short)20, 50, new String[] { "AI", "Deep Learning" },
            "Description 4");
        bst.insertByKeyword(seminar4);

        assertEquals(8, bst.size());

        Seminar seminar5 = new Seminar(5, "Seminar 5", "20230105", 80,
            (short)10, (short)15, 60, new String[] { "Cybersecurity",
                "Ethical Hacking" }, "Description 5");
        bst.insertByKeyword(seminar5);

        assertEquals(10, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test inserting duplicate date
     */
    public void testDuplicateInsertionByDate() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar Title", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "keyword1" }, "Description 1");
        bst.insertByDate(seminar1);

        assertEquals(1, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(2, bst.size());

        seminar2 = new Seminar(2, "Another Seminar", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "keyword2" }, "Description 2");
        bst.insertByDate(seminar2);

        assertEquals(3, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test order inserting by date
     */
    public void testInsertOrderByDate() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "keyword1" }, "Description 1");
        bst.insertByDate(seminar1);

        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "keyword2" }, "Description 2");
        bst.insertByDate(seminar2);

        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "keyword3" }, "Description 3");
        bst.insertByDate(seminar3);

        assertEquals(3, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(4, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test find for ID
     */
    public void testFindById() {
        assertEquals(seminar1, bst.findById(1));
        assertEquals(seminar2, bst.findById(2));
        assertEquals(seminar3, bst.findById(3));
        assertEquals(seminar4, bst.findById(4));

        assertNull(bst.findById(99));
    }


    // ----------------------------------------------------------
    /**
     * Test remove ID
     */
    public void testRemoveById() {
        BinarySearchTree idTree = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        idTree.insertById(seminar1);
        idTree.insertById(seminar2);
        idTree.insertById(seminar3);

        idTree.removeById(2);

        assertNull(idTree.findById(2));

        assertNotNull(idTree.findById(1));
        assertNotNull(idTree.findById(3));
    }


    // ----------------------------------------------------------
    /**
     * Test delete date
     */
    public void testRemoveByDate() {
        BinarySearchTree dateTree = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        dateTree.insertByDate(seminar1);
        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar3);

        dateTree.removeByDate(seminar2);

        assertFalse(dateTree.findByDateRange("20230102", "20230102"));

        assertTrue(dateTree.findByDateRange("20230101", "20230101"));
        assertTrue(dateTree.findByDateRange("20230103", "20230103"));
    }


    // ----------------------------------------------------------
    /**
     * Test removing cost
     */
    public void testRemoveByCost() {
        BinarySearchTree costTree = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
        seminar4 = new Seminar(4, "Seminar 4", "20230103", 100, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        costTree.insertByCost(seminar1);
        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar3);

        costTree.removeByCost(seminar4);

        assertTrue(costTree.findByCostRange(100, 100));

        assertTrue(costTree.findByCostRange(50, 50));
        assertTrue(costTree.findByCostRange(70, 70));
    }


    // ----------------------------------------------------------
    /**
     * Test remove keywords
     */
    public void testRemoveByKeyword() {
        BinarySearchTree keywordTree = new BinarySearchTree();
        keywordTree.removeByKeyword("Blockchain", seminar2);

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        keywordTree.insertByKeyword(seminar1);
        keywordTree.removeByKeyword("AI", seminar1);

        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar1);
        keywordTree.removeByKeyword("AI", seminar1);

        keywordTree.insertByKeyword(seminar1);
        keywordTree.insertByKeyword(seminar3);
        keywordTree.removeByKeyword("Data Science", seminar3);

        keywordTree.removeByKeyword("Blockchain", seminar3);

        assertNotNull(keywordTree.findByKeyword("Blockchain"));

        assertNotNull(keywordTree.findByKeyword("AI"));
        assertNotNull(keywordTree.findByKeyword("Data Science"));
    }


    // ----------------------------------------------------------
    /**
     * Find using dates
     */
    public void testFindByDateRangeWithNullDate() {
        bst = new BinarySearchTree();

        Seminar s1 = new Seminar();
        s1.setId(1);
        s1.setDate("20230101");
        s1.setKeywords(new String[] {"Test1"});
        bst.insertByDate(s1);

        Seminar s2 = new Seminar();
        s2.setId(2);
        s2.setDate(null); // Null date
        s2.setKeywords(new String[] {"Test2"});
        bst.insertByDate(s2);

        Seminar s3 = new Seminar();
        s3.setId(3);
        s3.setDate("20230301");
        s3.setKeywords(new String[] {"Test3"});
        bst.insertByDate(s3);

        // Test with range including all dates
        assertTrue(bst.findByDateRange("20230101", "20230301"));

        // This should not throw an exception now
        bst.findByDateRange("20230101", "20230401");
    }


    // ----------------------------------------------------------
    /**
     * Find using cost
     */
    public void testFindByCostRange() {
        boolean found = bst.findByCostRange(30, 100);
        assertTrue(found);

        found = bst.findByCostRange(1000, 2000);
        assertFalse(found);
    }


    // ----------------------------------------------------------
    /**
     * Find using keywords
     */
    public void testFindByKeyword() {
        BinarySearchTree keywordTree = new BinarySearchTree();
        assertFalse(keywordTree.findByKeyword("Blockchain"));

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        keywordTree.insertByKeyword(seminar1);
        assertNotNull(keywordTree.findByKeyword("AI"));
    }


    // ----------------------------------------------------------
    /**
     * Find keywords with two children
     */
    public void testFindByKeywordWithLeftAndRightSubtrees() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        bst.insertByKeyword(seminar1);
        bst.insertByKeyword(seminar2);
        bst.insertByKeyword(seminar3);

        boolean foundAI = bst.findByKeyword("AI");
        boolean foundBlockchain = bst.findByKeyword("Blockchain");
        boolean foundDataScience = bst.findByKeyword("Data Science");

        assertNotNull(foundAI);
        assertNotNull(foundBlockchain);
        assertNotNull(foundDataScience);
        boolean foundNotExist = bst.findByKeyword("Non-existent");
        assertNotNull(foundNotExist);
    }


    // ----------------------------------------------------------
    /**
     * Find keywords with null as children
     */
    public void testFindByKeywordWithNullSubtrees() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");

        bst.insertByKeyword(seminar1);

        boolean foundNotExist = bst.findByKeyword("NonExistentKeyword");

        assertNotNull(foundNotExist);

        assertNull(bst.getRoot().left());
        assertNull(bst.getRoot().right());
    }


    // ----------------------------------------------------------
    /**
     * Test duplicate insertions
     */
    public void testDuplicateInsertions() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar A", "20220101", 60, (short)10,
            (short)10, 100, new String[] { "AI" }, "Description A");
        seminar2 = new Seminar(1, "Seminar A", "20220101", 60, (short)10,
            (short)10, 100, new String[] { "AI" }, "Description A");

        bst.insertById(seminar1);
        assertEquals(1, bst.size());

        bst.insertById(seminar2);
        assertEquals(2, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test findMax and deleteMax functions
     */
    public void testFindMaxAndDeleteMax() {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

        bst.insertByCost(seminar1);
        bst.insertByCost(seminar2);
        bst.insertByCost(seminar3);

        Seminar maxSeminar = bst.findMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals(100, maxSeminar.cost());

        bst.deleteMax(bst.getRoot());

        maxSeminar = bst.findMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals(70, maxSeminar.cost());

        bst.deleteMax(bst.getRoot());

        maxSeminar = bst.findMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals(50, maxSeminar.cost());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testFind() {
        BinarySearchTree empty = new BinarySearchTree();
        assertFalse(empty.find(seminar1));

        assertTrue(bst.find(seminar1));
        assertTrue(bst.find(seminar2));
        assertTrue(bst.find(seminar3));
        assertTrue(bst.find(seminar4));

        Seminar seminar0 = new Seminar(0, "Seminar 3", "20230103", 70,
            (short)12, (short)15, 70, new String[] { "Data Science" },
            "Description 3");
        assertFalse(bst.find(seminar0));

        bst.insertById(seminar0);
        assertTrue(bst.find(seminar0));
    }


    // ----------------------------------------------------------
    /**
     * Test clear
     */
    public void testClear() {
        bst.clear();
        assertEquals(0, bst.size());
        assertNull(bst.getRoot());
    }
}
