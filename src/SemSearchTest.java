import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class SemSearchTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testMInitx() {
        String[] args = { "100", "commands.txt" };
        SemSearch.main(args);

        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        SemSearch.main(null);
    }
}
