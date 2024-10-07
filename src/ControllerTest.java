// -------------------------------------------------------------------------
/**
 *  Testing class for Controller
 * 
 *  @author markz + tarinid
 *  @version Oct 7, 2024
 */
public class ControllerTest {
    private Controller controller;
    private Seminar seminar1;
    private Seminar seminar2;
    private Seminar seminar3;

    // ----------------------------------------------------------
    /**
     * Set up for the tests
     */
    public void setUp() {
        controller = new Controller(100);

        seminar1 = new Seminar(1, "Seminar 1", "20230101", 90, (short)10,
            (short)10, 50, new String[] { "AI" }, "Description 1");
        seminar2 = new Seminar(2, "Seminar 2", "20230201", 60, (short)20,
            (short)20, 100, new String[] { "ML" }, "Description 2");
        seminar3 = new Seminar(3, "Seminar 3", "20230301", 120, (short)30,
            (short)30, 75, new String[] { "Data Science" }, "Description 3");
    }


    // ----------------------------------------------------------
    /**
     * Test inserting seminars
     */
    public void testInsertSeminars() {
        controller.insert(seminar1);
        controller.insert(seminar2);
        controller.insert(seminar3);

        controller.searchById(1);
        controller.searchById(2);
        controller.searchById(3);
    }

    // ----------------------------------------------------------
    /**
     * Test deleting seminars
     */
    public void testDeleteSeminarById() {
        controller.insert(seminar1);
        controller.insert(seminar2);

        controller.delete(1);

        controller.searchById(1);
        controller.searchById(2);
    }

    // ----------------------------------------------------------
    /**
     * Test searching by cost
     */
    public void testSearchByCostRange() {
        controller.insert(seminar1);
        controller.insert(seminar2);
        controller.insert(seminar3);

        controller.searchByCostRange(50, 100);

        controller.searchByCostRange(90, 110);
    }

    // ----------------------------------------------------------
    /**
     * Test searching by date
     */
    public void testSearchByDateRange() {
        controller.insert(seminar1);
        controller.insert(seminar2);
        controller.insert(seminar3);

        controller.searchByDateRange("20230101", "20230301");
        controller.searchByDateRange("20230201", "20230301");
    }

    // ----------------------------------------------------------
    /**
     * Test searching by keyword
     */
    public void testSearchByKeyword() {
        controller.insert(seminar1);
        controller.insert(seminar2);
        controller.insert(seminar3);

        controller.searchByKeyword("AI");
        controller.searchByKeyword("ML");
        controller.searchByKeyword("Data Science");
    }

    // ----------------------------------------------------------
    /**
     * Test inserting invalid coordinates
     */
    public void testInsertInvalidCoordinates() {
        Seminar invalidSeminar = new Seminar(4, "Invalid Seminar", "20230401",
            120, (short)-10, (short)10, 60, new String[] { "Invalid" },
            "Description 4");

        controller.insert(invalidSeminar);

        controller.searchById(4);
    }
}
