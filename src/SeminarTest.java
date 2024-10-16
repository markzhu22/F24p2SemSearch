// -------------------------------------------------------------------------
/**
 * Test the Seminar class
 *
 * @author CS3114/CS5040 staff
 * @version July 2023, last updated September 2023
 */
public class SeminarTest extends student.TestCase {

    private Seminar seminar;
    private String[] keywords;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        keywords = new String[] { "AI", "ML" };
        seminar = new Seminar(1, "AI Seminar", "20240101", 120, (short)10,
            (short)20, 500, keywords, "An AI Seminar");
    }


    /**
     * Check the toString method
     */
    public void testtoString() {
        String[] testKeywords = { "Good", "Bad", "Ugly" }; // Renamed local
                                                           // variable
        String expected = "ID: 1729, Title: Seminar Title\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
            + "Description: This is a great seminar\n"
            + "Keywords: Good, Bad, Ugly";
        Seminar mysem = new Seminar(1729, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, testKeywords, "This is a great seminar");
        String semPrint = mysem.toString();
        System.out.println("testtoString");
        System.out.println(semPrint);
        assertTrue(semPrint.equals(expected));
        assertTrue(mysem.id() == 1729);
        assertTrue(mysem.cost() == 125);
        assertTrue(mysem.x() == 15);
        assertTrue(mysem.y() == 33);
        assertTrue(mysem.date().equals("2405231000"));
        String[] tempKeywords = mysem.keywords();
        for (int i = 0; i < testKeywords.length; i++) {
            assertTrue(tempKeywords[i].equals(testKeywords[i]));
        }
    }


    /**
     * Check the serialization/deserialization process
     * 
     * @throws Exception
     */
    public void testSeminarDS() throws Exception {
        String[] testKeywords = { "Good", "Bad", "Ugly" }; // Renamed local
                                                           // variable

        Seminar mysem = new Seminar(1729, "Seminar Title", "2405231000", 75,
            (short)15, (short)33, 125, testKeywords, "This is a great seminar");
        String semPrint = mysem.toString();
        System.out.println(semPrint);
        assertTrue(semPrint.equals("ID: 1729, Title: Seminar Title\n"
            + "Date: 2405231000, Length: 75, X: 15, Y: 33, Cost: 125\n"
            + "Description: This is a great seminar\n"
            + "Keywords: Good, Bad, Ugly"));
    }


    // ----------------------------------------------------------
    /**
     * Testing seminar title
     */
    public void testTitle() {
        assertEquals("AI Seminar", seminar.title());
    }


    // ----------------------------------------------------------
    /**
     * Testing seminar length
     */
    public void testLength() {
        assertEquals(120, seminar.length());
    }


    // ----------------------------------------------------------
    /**
     * Testing seminar description
     */
    public void testDesc() {
        assertEquals("An AI Seminar", seminar.desc());
    }


    // ----------------------------------------------------------
    /**
     * Testing seminar x
     */
    public void testGetX() {
        assertEquals(10, seminar.getX());
    }


    // ----------------------------------------------------------
    /**
     * Testing seminar y
     */
    public void testGetY() {
        assertEquals(20, seminar.getY());
    }


    // ----------------------------------------------------------
    /**
     * Testing seminar id
     */
    public void testGetId() {
        assertEquals(seminar.getId(), 1);
    }
}
