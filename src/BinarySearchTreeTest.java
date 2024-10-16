// -------------------------------------------------------------------------
/**
 * Test class for BinarySearchTree
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class BinarySearchTreeTest
    extends student.TestCase
{
    private BinarySearchTree bst;
    private Seminar seminar1, seminar2, seminar3, seminar4;

    public void setUp()
    {
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
        seminar1 = new Seminar(
            1,
            "HCI Seminar",
            "20230930",
            90,
            (short)10,
            (short)20,
            50,
            new String[] { "HCI", "AI" },
            "HCI Research");
        seminar2 = new Seminar(
            2,
            "AI Seminar",
            "20221015",
            60,
            (short)15,
            (short)25,
            100,
            new String[] { "AI", "ML" },
            "AI Research");
        seminar3 = new Seminar(
            3,
            "ML Seminar",
            "20220820",
            120,
            (short)5,
            (short)10,
            75,
            new String[] { "ML", "AI" },
            "ML Research");
        seminar4 = new Seminar(
            4,
            "Computing Seminar",
            "20230625",
            30,
            (short)12,
            (short)18,
            30,
            new String[] { "Computing" },
            "Computing Research");

        bst.insertById(seminar1);
        bst.insertById(seminar2);
        bst.insertById(seminar3);
        bst.insertById(seminar4);
    }


    // ----------------------------------------------------------
    /**
     * Test inserting ID
     */
    public void testInsertById()
    {
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
    public void testInsertByDate()
    {
        BinarySearchTree test = new BinarySearchTree();

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
        test.insertByDate(seminar1);

        assertEquals(1, test.size());

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
        test.insertByDate(seminar1);

        assertEquals(2, test.size());
    }


    // ----------------------------------------------------------
    /**
     * Test inserting cost
     */
    public void testInsertByCost()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "keyword1" }, "Description 1");
        bst.insertByCost(seminar1);

        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "keyword2" }, "Description 2");
        bst.insertByCost(seminar2);

        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "keyword3" }, "Description 3");
        seminar1 = new Seminar(
            1,
            "Seminar 1",
            "20230101",
            90,
            (short)10,
            (short)10,
            50,
            new String[] { "keyword1" },
            "Description 1");
        bst.insertByCost(seminar1);

        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "keyword2" },
            "Description 2");
        bst.insertByCost(seminar2);

        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "keyword3" },
            "Description 3");
        bst.insertByCost(seminar3);

        assertEquals(3, bst.size());

        seminar4 = new Seminar(4, "Seminar 4", "20230104", 60, (short)20,
            (short)20, 50, new String[] { "keyword4" }, "Description 4");
        seminar4 = new Seminar(
            4,
            "Seminar 4",
            "20230104",
            60,
            (short)20,
            (short)20,
            50,
            new String[] { "keyword4" },
            "Description 4");
        bst.insertByCost(seminar4);

        assertEquals(4, bst.size());

        bst.insertByCost(seminar2);

        assertEquals(5, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test inserting keyword
     */
    public void testInsertByKeyword()
    {
        BinarySearchTree test = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI", "Machine Learning" },
        seminar1 = new Seminar(
            1,
            "Seminar 1",
            "20230101",
            90,
            (short)10,
            (short)10,
            50,
            new String[] { "AI", "Machine Learning" },
            "Description 1");
        test.insertByKeyword(seminar1);

        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain", "Cryptography" },
            "Description 2");
        bst.insertByKeyword(seminar2);

        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science", "AI" },
        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain", "Cryptography" },
            "Description 2");
        test.insertByKeyword(seminar2);

        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science", "AI" },
            "Description 3");
        test.insertByKeyword(seminar3);

        assertEquals(6, test.size());

        seminar4 = new Seminar(4, "Seminar 4", "20230104", 60, (short)20,
            (short)20, 50, new String[] { "AI", "Deep Learning" },
        seminar4 = new Seminar(
            4,
            "Seminar 4",
            "20230104",
            60,
            (short)20,
            (short)20,
            50,
            new String[] { "AI", "Deep Learning" },
            "Description 4");
        test.insertByKeyword(seminar4);

        assertEquals(8, test.size());

        Seminar seminar5 = new Seminar(
            5,
            "Seminar 5",
            "20230105",
            80,
            (short)10,
            (short)15,
            60,
            new String[] { "Cybersecurity", "Ethical Hacking" },
            "Description 5");
        test.insertByKeyword(seminar5);

        assertEquals(10, test.size());
    }


    // ----------------------------------------------------------
    /**
     * Test inserting duplicate date
     */
    public void testDuplicateInsertionByDate()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar Title", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "keyword1" }, "Description 1");
        seminar1 = new Seminar(
            1,
            "Seminar Title",
            "20230101",
            90,
            (short)10,
            (short)10,
            50,
            new String[] { "keyword1" },
            "Description 1");
        bst.insertByDate(seminar1);

        assertEquals(1, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(2, bst.size());

        seminar2 = new Seminar(2, "Another Seminar", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "keyword2" }, "Description 2");
        seminar2 = new Seminar(
            2,
            "Another Seminar",
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "keyword2" },
            "Description 2");
        bst.insertByDate(seminar2);

        assertEquals(3, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test order inserting by date
     */
    public void testInsertOrderByDate()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "keyword1" }, "Description 1");
        bst.insertByDate(seminar1);

        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "keyword2" }, "Description 2");
        bst.insertByDate(seminar2);

        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "keyword3" }, "Description 3");
        seminar1 = new Seminar(
            1,
            "Seminar 1",
            "20230101",
            90,
            (short)10,
            (short)10,
            50,
            new String[] { "keyword1" },
            "Description 1");
        bst.insertByDate(seminar1);

        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "keyword2" },
            "Description 2");
        bst.insertByDate(seminar2);

        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "keyword3" },
            "Description 3");
        bst.insertByDate(seminar3);

        assertEquals(3, bst.size());

        bst.insertByDate(seminar1);

        assertEquals(4, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test find for ID
     */
    public void testFindById()
    {
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
    public void testRemoveById()
    {
        BinarySearchTree idTree = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
        idTree.removeById(2);

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
            3,
            "Seminar 2",
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain" },
            "Description 2");
        seminar3 = new Seminar(
            2,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 3");

        idTree.insertById(seminar1);
        idTree.insertById(seminar2);
        idTree.insertById(seminar3);

        idTree.removeById(3);
        assertNull(idTree.findById(3));
        assertNotNull(idTree.findById(1));
        assertNotNull(idTree.findById(2));

        idTree.insertById(seminar3);

        idTree.removeById(2);
        idTree.removeById(3);
        idTree.insertById(seminar2);
        idTree.insertById(seminar3);

        idTree.removeById(1);
        idTree.removeById(2);
        idTree.removeById(3);

        idTree.insertById(seminar3);
        idTree.insertById(seminar2);
        idTree.insertById(seminar1);

        idTree.removeById(1);
        idTree.insertById(seminar1);

        idTree.removeById(2);
        idTree.removeById(1);
        idTree.insertById(seminar2);
        idTree.insertById(seminar1);

        idTree.removeById(3);
        idTree.removeById(2);
        idTree.removeById(1);

        idTree.insertById(seminar2);
        idTree.insertById(seminar1);

        idTree.removeById(1);
        idTree.removeById(2);

        idTree.insertById(seminar1);
        idTree.insertById(seminar2);
        idTree.removeById(2);
        idTree.removeById(1);
    }


    // ----------------------------------------------------------
    /**
     * Test delete date
     */
    public void testRemoveByDate()
    {
        BinarySearchTree dateTree = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
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
            "20230103",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain" },
            "Description 2");
        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230102",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 3");

        dateTree.removeByDate(seminar3);

        dateTree.insertByDate(seminar1);
        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar3);

        dateTree.removeByDate(seminar3);

        dateTree.insertById(seminar3);

        dateTree.removeByDate(seminar2);
        dateTree.removeByDate(seminar3);
        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar3);

        dateTree.removeByDate(seminar1);
        dateTree.removeByDate(seminar2);
        dateTree.removeByDate(seminar3);

        dateTree.insertByDate(seminar3);
        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar1);

        dateTree.removeByDate(seminar1);
        dateTree.insertByDate(seminar1);

        dateTree.removeByDate(seminar2);
        dateTree.removeByDate(seminar1);
        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar1);

        dateTree.removeByDate(seminar3);
        dateTree.removeByDate(seminar2);
        dateTree.removeByDate(seminar1);

        dateTree.insertByDate(seminar2);
        dateTree.insertByDate(seminar1);

        dateTree.removeByDate(seminar1);
        dateTree.removeByDate(seminar2);

        dateTree.insertByDate(seminar1);
        dateTree.insertByDate(seminar2);
        dateTree.removeByDate(seminar2);
        dateTree.removeByDate(seminar1);

        seminar4 = new Seminar(
            4,
            "Seminar 4",
            "20230102",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 4");
        dateTree.insertByDate(seminar4);
        dateTree.insertByDate(seminar3);

        dateTree.removeByDate(seminar3);

    }


    // ----------------------------------------------------------
    /**
     * Test removing cost
     */
    public void testRemoveByCost()
    {
        BinarySearchTree costTree = new BinarySearchTree();

<<<<<<< Updated upstream
        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
        seminar4 = new Seminar(4, "Seminar 4", "20230103", 100, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
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
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain" },
            "Description 2");
        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 3");

        costTree.removeByCost(seminar3);

        costTree.insertByCost(seminar1);
        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar3);

        costTree.removeByCost(seminar3);
        costTree.insertById(seminar3);

        costTree.removeByCost(seminar2);
        costTree.removeByCost(seminar3);
        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar3);

        costTree.removeByCost(seminar1);
        costTree.removeByCost(seminar2);
        costTree.removeByCost(seminar3);

        costTree.insertByCost(seminar3);
        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar1);

        costTree.removeByCost(seminar1);
        costTree.insertByCost(seminar1);

        costTree.removeByCost(seminar2);
        costTree.removeByCost(seminar1);
        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar1);

        costTree.removeByCost(seminar3);
        costTree.removeByCost(seminar2);
        costTree.removeByCost(seminar1);

        costTree.insertByCost(seminar2);
        costTree.insertByCost(seminar1);

        costTree.removeByCost(seminar1);
        costTree.removeByCost(seminar2);

        costTree.insertByCost(seminar1);
        costTree.insertByCost(seminar2);
        costTree.removeByCost(seminar2);
        costTree.removeByCost(seminar1);

        seminar4 = new Seminar(
            4,
            "Seminar 4",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 4");
        costTree.insertByCost(seminar4);
        costTree.insertByCost(seminar3);

        costTree.removeByCost(seminar3);
    }


    // ----------------------------------------------------------
    /**
     * Test remove keywords
     */
    public void testRemoveByKeyword()
    {
        BinarySearchTree keywordTree = new BinarySearchTree();
        keywordTree.removeByKeyword("Blockchain", seminar2);

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");

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
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Data Science" },
            "Description 2");
        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Blockchain" },
            "Description 3");

        keywordTree.removeByKeyword("Data Science", seminar3);

        keywordTree.insertByKeyword(seminar1);
        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar3);

        keywordTree.removeByKeyword("Blockchain", seminar3);
        keywordTree.insertByKeyword(seminar3);

        keywordTree.removeByKeyword("Data Science", seminar2);
        keywordTree.removeByKeyword("Blockchain", seminar3);
        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar3);

        keywordTree.removeByKeyword("AI", seminar1);
        keywordTree.removeByKeyword("Data Science", seminar2);
        keywordTree.removeByKeyword("Blockchain", seminar3);

        keywordTree.insertByKeyword(seminar3);
        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar1);

        keywordTree.removeByKeyword("AI", seminar1);
        keywordTree.insertByKeyword(seminar1);

        keywordTree.removeByKeyword("Data Science", seminar2);
        keywordTree.removeByKeyword("AI", seminar1);
        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar1);

        keywordTree.removeByKeyword("Blockchain", seminar3);
        keywordTree.removeByKeyword("Data Science", seminar2);
        keywordTree.removeByKeyword("AI", seminar1);

        keywordTree.insertByKeyword(seminar2);
        keywordTree.insertByKeyword(seminar1);
        keywordTree.removeByKeyword("AI", seminar1);

        keywordTree.insertByKeyword(seminar1);
        keywordTree.insertByKeyword(seminar3);
        keywordTree.removeByKeyword("Data Science", seminar3);

        keywordTree.removeByKeyword("AI", seminar1);
        keywordTree.removeByKeyword("Data Science", seminar2);

        keywordTree.insertByKeyword(seminar1);
        keywordTree.insertByKeyword(seminar2);
        keywordTree.removeByKeyword("Data Science", seminar2);
        keywordTree.removeByKeyword("AI", seminar1);

        seminar4 = new Seminar(
            4,
            "Seminar 4",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Blockchain" },
            "Description 4");
        keywordTree.insertByKeyword(seminar4);
        keywordTree.insertByKeyword(seminar3);

        keywordTree.removeByKeyword("Blockchain", seminar3);
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
    public void testFindByDateRange()
    {
        BinarySearchTree test = new BinarySearchTree();

        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "0",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "keyword2" },
            "Description 2");
        test.insertByDate(seminar2);

        boolean found = test.findByDateRange("20230930", "20230930");
        assertFalse(found);

        found = test.findByDateRange("20230929", "20230930");
        assertFalse(found);

        found = test.findByDateRange("20230928", "20230929");
        assertFalse(found);

        found = test.findByDateRange("20230930", "20230931");
        assertFalse(found);

        found = test.findByDateRange("20230931", "20230932");
        assertFalse(found);

        found = test.findByDateRange("20230928", "20230927");
        assertFalse(found);

        found = test.findByDateRange("20230932", "20230931");
        assertFalse(found);

        seminar1 = new Seminar(
            1,
            "HCI Seminar",
            "20230930",
            90,
            (short)10,
            (short)20,
            50,
            new String[] { "HCI", "AI" },
            "HCI Research");

        test.insertByDate(seminar1);

        found = test.findByDateRange("20230930", "20230930");
        assertTrue(found);

        found = test.findByDateRange("20230930", "20230929");
        assertFalse(found);

        found = test.findByDateRange("20230929", "20230930");
        assertTrue(found);

        found = test.findByDateRange("20230927", "20230928");
        assertFalse(found);

        found = test.findByDateRange("20230931", "20230932");
        assertFalse(found);

        found = test.findByDateRange("20230928", "20230927");
        assertFalse(found);

        found = test.findByDateRange("20230932", "20230931");
        assertFalse(found);
    }


    // ----------------------------------------------------------
    /**
     * Find using cost
     */
    public void testFindByCostRange()
    {
        BinarySearchTree test = new BinarySearchTree();

        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "0",
            60,
            (short)15,
            (short)20,
            0,
            new String[] { "keyword2" },
            "Description 2");
        test.insertByCost(seminar2);

        boolean found = test.findByCostRange(100, 100);
        assertFalse(found);

        found = test.findByCostRange(99, 100);
        assertFalse(found);

        found = test.findByCostRange(98, 99);
        assertFalse(found);

        found = test.findByCostRange(98, 98);
        assertFalse(found);

        found = test.findByCostRange(100, 101);
        assertFalse(found);

        found = test.findByCostRange(101, 102);
        assertFalse(found);

        found = test.findByCostRange(101, 101);
        assertFalse(found);

        seminar1 = new Seminar(
            1,
            "HCI Seminar",
            "20230930",
            90,
            (short)10,
            (short)20,
            100,
            new String[] { "HCI", "AI" },
            "HCI Research");

        test.insertByCost(seminar1);

        found = test.findByCostRange(100, 100);
        assertTrue(found);

        found = test.findByCostRange(99, 100);
        assertTrue(found);

        found = test.findByCostRange(98, 99);
        assertFalse(found);

        found = test.findByCostRange(98, 98);
        assertFalse(found);

        found = test.findByCostRange(100, 101);
        assertTrue(found);

        found = test.findByCostRange(101, 102);
        assertFalse(found);

        found = test.findByCostRange(101, 101);
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
    public void testFindByKeywordWithLeftAndRightSubtrees()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
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
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain" },
            "Description 2");
        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 3");

        bst.insertByKeyword(seminar1);
        bst.insertByKeyword(seminar2);
        bst.insertByKeyword(seminar3);

        String foundAI = bst.findByKeyword("AI");
        String foundBlockchain = bst.findByKeyword("Blockchain");
        String foundDataScience = bst.findByKeyword("Data Science");

        assertNotNull(foundAI);
        assertNotNull(foundBlockchain);
        assertNotNull(foundDataScience);
        String foundNotExist = bst.findByKeyword("Non-existent");
        assertNotNull(foundNotExist);
    }


    // ----------------------------------------------------------
    /**
     * Find keywords with null as children
     */
    public void testFindByKeywordWithNullSubtrees()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
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

        bst.insertByKeyword(seminar1);

        String foundNotExist = bst.findByKeyword("NonExistentKeyword");

        assertNotNull(foundNotExist);

        assertNull(bst.getRoot().left());
        assertNull(bst.getRoot().right());
    }


    // ----------------------------------------------------------
    /**
     * Test duplicate insertions
     */
    public void testDuplicateInsertions()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar A", "20220101", 60, (short)10,
            (short)10, 100, new String[] { "AI" }, "Description A");
        seminar2 = new Seminar(1, "Seminar A", "20220101", 60, (short)10,
            (short)10, 100, new String[] { "AI" }, "Description A");
        seminar1 = new Seminar(
            1,
            "Seminar A",
            "20220101",
            60,
            (short)10,
            (short)10,
            100,
            new String[] { "AI" },
            "Description A");
        seminar2 = new Seminar(
            1,
            "Seminar A",
            "20220101",
            60,
            (short)10,
            (short)10,
            100,
            new String[] { "AI" },
            "Description A");

        bst.insertById(seminar1);
        assertEquals(1, bst.size());

        bst.insertById(seminar2);
        assertEquals(2, bst.size());
    }


    // ----------------------------------------------------------
    /**
     * Test findMax and deleteMax functions
     */
    public void testFindMaxAndDeleteMax()
    {
        bst = new BinarySearchTree();

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230102", 60, (short)15,
            (short)20, 100, new String[] { "Blockchain" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230103", 70, (short)12,
            (short)15, 70, new String[] { "Data Science" }, "Description 3");
        Seminar maxSeminar = bst.findMax(bst.getRoot());
        assertNull(maxSeminar);

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
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain" },
            "Description 2");
        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 3");

        bst.insertByCost(seminar1);
        bst.insertByCost(seminar2);
        bst.insertByCost(seminar3);

        maxSeminar = bst.findMax(bst.getRoot());
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
     * Test findStringMax function
     */
    public void testFind() {
        BinarySearchTree empty = new BinarySearchTree();
        assertFalse(empty.find(seminar1));

        assertTrue(bst.find(seminar1));
        assertTrue(bst.find(seminar2));
        assertTrue(bst.find(seminar3));
        assertTrue(bst.find(seminar4));
    public void testFindStringMax()
    {
        bst = new BinarySearchTree();

        String maxSeminar = bst.findStringMax(bst.getRoot());
        assertNull(maxSeminar);

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
            "20230102",
            60,
            (short)15,
            (short)20,
            100,
            new String[] { "Blockchain" },
            "Description 2");
        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "20230103",
            70,
            (short)12,
            (short)15,
            70,
            new String[] { "Data Science" },
            "Description 3");

        bst.insertByKeyword(seminar1);
        bst.insertByKeyword(seminar2);
        bst.insertByKeyword(seminar3);

        maxSeminar = bst.findStringMax(bst.getRoot());
        assertNotNull(maxSeminar);
        assertEquals("Data Science", maxSeminar);
    }


    // ----------------------------------------------------------
    /**
     * Test clear
     */
    public void testClear()
    {
        bst.clear();
        assertEquals(0, bst.size());
        assertNull(bst.getRoot());
    }


    // ----------------------------------------------------------
    /**
     * Test help function
     */
    public void testHelp()
    {
        BinarySearchTree test = new BinarySearchTree();

        seminar2 = new Seminar(
            2,
            "Seminar 2",
            "0",
            60,
            (short)15,
            (short)20,
            0,
            new String[] { "keyword2" },
            "Description 2");
        test.find(seminar2);
        test.insertById(seminar2);
        assertTrue(test.find(seminar2));

        seminar1 = new Seminar(
            1,
            "Seminar 1",
            "0",
            60,
            (short)15,
            (short)20,
            0,
            new String[] { "keyword1" },
            "Description 1");

        test.find(seminar1);
        test.insertById(seminar1);
        assertTrue(test.find(seminar1));

        seminar3 = new Seminar(
            3,
            "Seminar 3",
            "0",
            60,
            (short)15,
            (short)20,
            0,
            new String[] { "keyword3" },
            "Description 3");
        test.find(seminar3);
        test.insertById(seminar3);
        assertTrue(test.find(seminar3));
    }
}
