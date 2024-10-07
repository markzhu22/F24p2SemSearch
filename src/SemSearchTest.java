import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for the whole project
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class SemSearchTest
    extends TestCase
{
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp()
    {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testMInitx()
    {
        String[] args = { "100", "solutionTestData/P2_sampleInput.txt" };
        SemSearch.main(args);

        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        SemSearch.main(null);

        assertFuzzyEquals(
            "Location Tree:\r\n" + "E\r\n" + "ID Tree:\r\n"
                + "This tree is empty\r\n"
                + "Search FAILED -- There is no record with ID 1\r\n"
                + "Seminars matching keyword VT:\r\n"
                + "Insert FAILED - Bad x, y coordinates: -1, 10\r\n"
                + "Insert FAILED - Bad x, y coordinates: 10, 128\r\n"
                + "Successfully inserted record with ID 1\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Successfully inserted record with ID 2\r\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
                + "Description: Introduction to   bioinformatics and computation biology\r\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
                + "Successfully inserted record with ID 10\r\n"
                + "ID: 10, Title: Computing Systems Research at VT\r\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
                + "Description: Seminar about the      Computing systems research at      VT\r\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
                + "Successfully inserted record with ID 3\r\n"
                + "ID: 3, Title: Overview of HPC and CSE Research at VT\r\n"
                + "Date: 1203301125, Length: 35, X: 0, Y: 0, Cost: 25\r\n"
                + "Description: Learn what kind of    research is done on HPC  and CSE at VT\r\n"
                + "Keywords: HPC, CSE, computer_science\r\n" + "ID Tree:\r\n"
                + "            (null)\r\n" + "                \\\r\n"
                + "                (1)\r\n" + "                /\r\n"
                + "        (null)\r\n" + "            \\\r\n"
                + "            (2)\r\n" + "            /\r\n" + "(null)\r\n"
                + "    \\\r\n" + "    (3)\r\n" + "    /\r\n" + "(null)\r\n"
                + "        \\\r\n" + "        (10)\r\n" + "        /\r\n"
                + "    (null)\r\n" + "Number of records: 4\r\n"
                + "Date Tree:\r\n" + "            (null)\r\n"
                + "                \\\r\n" + "                (0610051600)\r\n"
                + "                /\r\n" + "        (null)\r\n"
                + "            \\\r\n" + "            (0610071600)\r\n"
                + "            /\r\n" + "    (null)\r\n" + "        \\\r\n"
                + "        (0701250830)\r\n" + "        /\r\n" + "(null)\r\n"
                + "    \\\r\n" + "    (1203301125)\r\n" + "    /\r\n"
                + "(null)\r\n" + "Number of records: 4\r\n"
                + "Keyword Tree:\r\n" + "                    (null)\r\n"
                + "                        \\\r\n"
                + "                        (Bioinformatics)\r\n"
                + "                        /\r\n" + "                (null)\r\n"
                + "                    \\\r\n"
                + "                    (Biology)\r\n"
                + "                    /\r\n" + "        (null)\r\n"
                + "            \\\r\n" + "            (CSE)\r\n"
                + "            /\r\n" + "        (null)\r\n"
                + "                \\\r\n"
                + "                (Computer_Science)\r\n"
                + "                /\r\n" + "            (null)\r\n"
                + "                            \\\r\n"
                + "                            (Computer_Science)\r\n"
                + "                            /\r\n"
                + "                        (null)\r\n"
                + "                                \\\r\n"
                + "                                (HCI)\r\n"
                + "                                /\r\n"
                + "            (null)\r\n" + "                \\\r\n"
                + "                (HPC)\r\n" + "                /\r\n"
                + "            (null)\r\n" + "                    \\\r\n"
                + "                    (VT)\r\n" + "                    /\r\n"
                + "                (null)\r\n"
                + "                        \\\r\n"
                + "                        (VT)\r\n"
                + "                        /\r\n"
                + "                    (null)\r\n"
                + "                            \\\r\n"
                + "                            (VT)\r\n"
                + "                            /\r\n"
                + "                (null)\r\n" + "                    \\\r\n"
                + "                    (Virginia_Tech)\r\n"
                + "                    /\r\n" + "                (null)\r\n"
                + "                        \\\r\n"
                + "                        (Virginia_Tech)\r\n"
                + "                        /\r\n" + "                (null)\r\n"
                + "                    \\\r\n"
                + "                    (computation_biology)\r\n"
                + "                    /\r\n" + "    (null)\r\n"
                + "        \\\r\n" + "        (computer)\r\n" + "        /\r\n"
                + "(null)\r\n" + "    \\\r\n" + "    (computer_science)\r\n"
                + "    /\r\n" + "(null)\r\n" + "            \\\r\n"
                + "            (grids)\r\n" + "            /\r\n"
                + "        (null)\r\n" + "                \\\r\n"
                + "                (high_performance_computing)\r\n"
                + "                /\r\n" + "        (null)\r\n"
                + "            \\\r\n" + "            (science)\r\n"
                + "            /\r\n" + "        (null)\r\n"
                + "Number of records: 18\r\n" + "Cost Tree:\r\n"
                + "    (null)\r\n" + "        \\\r\n" + "        (17)\r\n"
                + "        /\r\n" + "(null)\r\n" + "    \\\r\n" + "    (25)\r\n"
                + "    /\r\n" + "(null)\r\n" + "            \\\r\n"
                + "            (30)\r\n" + "            /\r\n"
                + "        (null)\r\n" + "                \\\r\n"
                + "                (45)\r\n" + "                /\r\n"
                + "            (null)\r\n" + "Number of records: 4\r\n"
                + "Location Tree:\r\n" + "E\r\n"
                + "Insert FAILED - There is already a record with ID 10\r\n"
                + "Seminars matching keyword VT:\r\n"
                + "ID: 10, Title: Computing Systems Research at VT\r\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
                + "Description: Seminar about the      Computing systems research at      VT\r\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
                + "Description: Introduction to   bioinformatics and computation biology\r\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Found record with ID 1:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "Seminars with costs in range 30 to 50:\r\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
                + "Description: Introduction to   bioinformatics and computation biology\r\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "4 nodes visited in this search\r\n" + "Invalid keyword\r\n"
                + "Invalid keyword\r\n" + "Invalid keyword\r\n"
                + "Invalid keyword\r\n" + "Invalid keyword\r\n"
                + "Seminars with dates in range 0 to 1:\r\n"
                + "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
                + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
                + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
                + "Description: Introduction to   bioinformatics and computation biology\r\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
                + "ID: 10, Title: Computing Systems Research at VT\r\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
                + "Description: Seminar about the      Computing systems research at      VT\r\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
                + "4 nodes visited in this search\r\n"
                + "Record with ID 1 successfully deleted from the database\r\n"
                + "ID Tree:\r\n" + "        (null)\r\n" + "            \\\r\n"
                + "            (2)\r\n" + "            /\r\n" + "(null)\r\n"
                + "    \\\r\n" + "    (3)\r\n" + "    /\r\n" + "(null)\r\n"
                + "        \\\r\n" + "        (10)\r\n" + "        /\r\n"
                + "    (null)\r\n" + "Number of records: 3\r\n"
                + "Location Tree:\r\n" + "E\r\n"
                + "Usage: java SemSearch <worldSize> <commandFile>",
            systemOut().getHistory());
    }
}
