public class ReferenceTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Setup for tests
     */
    public void setUp()
    {
        // Empty on purpose
    }


    // ----------------------------------------------------------
    /**
     * Test Insert
     */
    public void testInsert() {
        String[] args = new String[2];
        args[0] = "16";
        args[1] = "InsertTestInput.txt";

        SemSearch.main(args);
        
        
    }
}
