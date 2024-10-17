// -------------------------------------------------------------------------
/**
 * Test class for personal testing
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class ReferenceTest
    extends student.TestCase
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
     * Test SemSearch
     */
    public void testSemSearch()
    {
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "TestInput.txt";

        SemSearch.main(args);

        assertFuzzyEquals(
            "Delete FAILED -- There is no record with ID 1\n"
            + "ID Tree:\n"
            + "This tree is empty\n"
            + "Date Tree:\n"
            + "This tree is empty\n"
            + "Cost Tree:\n"
            + "This tree is empty\n"
            + "Keyword Tree:\n"
            + "This tree is empty\n"
            + "Location Tree:\n"
            + "E\n"
            + "Invalid field: :3\n"
            + "Search FAILED -- There is no record with ID 1\n"
            + "Seminars with dates in range 0 to 1:\n"
            + "1 nodes visited in this search\n"
            + "Seminars with costs in range 0 to 1:\n"
            + "1 nodes visited in this search\n"
            + "Seminars matching keyword VT:\n"
            + "Seminars within 0 units of 0, 0:\n"
            + "1 nodes visited in this search\n"
            + "Invalid keyword\n"
            + "Insert FAILED - Bad x, y coordinates: -1, -1\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 129\n"
            + "Insert FAILED - Bad x, y coordinates: 129, 129\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 0\n"
            + "Insert FAILED - Bad x, y coordinates: 0, -1\n"
            + "Insert FAILED - Bad x, y coordinates: 128, 129\n"
            + "Successfully inserted record with ID 1\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Insert FAILED - There is already a record with ID 1\n"
            + "ID Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (1)\n"
            + "    /\n"
            + "(null)\n"
            + "Number of records: 1\n"
            + "Date Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (0610051600)\n"
            + "    /\n"
            + "(null)\n"
            + "Number of records: 1\n"
            + "Cost Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (50)\n"
            + "    /\n"
            + "(null)\n"
            + "Number of records: 1\n"
            + "Keyword Tree:\n"
            + "        (null)\n"
            + "            \\\n"
            + "            (key1)\n"
            + "            /\n"
            + "    (null)\n"
            + "        \\\n"
            + "        (key2)\n"
            + "        /\n"
            + "(null)\n"
            + "    \\\n"
            + "    (key3)\n"
            + "    /\n"
            + "(null)\n"
            + "Number of records: 3\n"
            + "Location Tree:\n"
            + "(Leaf with 1 objects: 1)\n"
            + "Found record with ID 1:\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Seminars with dates in range 0 to 1:\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "3 nodes visited in this search\n"
            + "Seminars with costs in range 0 to 1:\n"
            + "2 nodes visited in this search\n"
            + "Seminars matching keyword VT:\n"
            + "Seminars within 20 units of 0, 0:\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "1 nodes visited in this search\n"
            + "Record with ID 1 successfully deleted from the database\n"
            + "Successfully inserted record with ID 1\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Successfully inserted record with ID 2\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "ID Tree:\n"
            + "    (null)\n"
            + "        \\\n"
            + "        (1)\n"
            + "        /\n"
            + "(null)\n"
            + "    \\\n"
            + "    (2)\n"
            + "    /\n"
            + "(null)\n"
            + "Number of records: 2\n"
            + "Date Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (0610051600)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (0610051600)\n"
            + "        /\n"
            + "    (null)\n"
            + "Number of records: 2\n"
            + "Cost Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (50)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (50)\n"
            + "        /\n"
            + "    (null)\n"
            + "Number of records: 2\n"
            + "Keyword Tree:\n"
            + "        (null)\n"
            + "            \\\n"
            + "            (key1)\n"
            + "            /\n"
            + "        (null)\n"
            + "                \\\n"
            + "                (key1)\n"
            + "                /\n"
            + "    (null)\n"
            + "        \\\n"
            + "        (key2)\n"
            + "        /\n"
            + "    (null)\n"
            + "            \\\n"
            + "            (key2)\n"
            + "            /\n"
            + "(null)\n"
            + "    \\\n"
            + "    (key3)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (key3)\n"
            + "        /\n"
            + "    (null)\n"
            + "Number of records: 6\n"
            + "Location Tree:\n"
            + "(Leaf with 2 objects: 1 2)\n"
            + "Found record with ID 1:\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Seminars with dates in range 0 to 1:\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "5 nodes visited in this search\n"
            + "Seminars with costs in range 0 to 100:\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "5 nodes visited in this search\n"
            + "Seminars matching keyword key1:\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Seminars within 20 units of 0, 0:\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "Found a record with key value 2 at 10, 10\n"
            + "1 nodes visited in this search\n"
            + "Record with ID 1 successfully deleted from the database\n"
            + "Record with ID 2 successfully deleted from the database\n"
            + "Successfully inserted record with ID 2\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "Successfully inserted record with ID 1\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Successfully inserted record with ID 3\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (1)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (2)\n"
            + "        /\n"
            + "(null)\n"
            + "    \\\n"
            + "    (3)\n"
            + "    /\n"
            + "(null)\n"
            + "Number of records: 3\n"
            + "Date Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (0610051600)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (0610051600)\n"
            + "        /\n"
            + "    (null)\n"
            + "            \\\n"
            + "            (0610051600)\n"
            + "            /\n"
            + "        (null)\n"
            + "Number of records: 3\n"
            + "Cost Tree:\n"
            + "(null)\n"
            + "    \\\n"
            + "    (50)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (50)\n"
            + "        /\n"
            + "    (null)\n"
            + "            \\\n"
            + "            (50)\n"
            + "            /\n"
            + "        (null)\n"
            + "Number of records: 3\n"
            + "Keyword Tree:\n"
            + "        (null)\n"
            + "            \\\n"
            + "            (key1)\n"
            + "            /\n"
            + "        (null)\n"
            + "                \\\n"
            + "                (key1)\n"
            + "                /\n"
            + "            (null)\n"
            + "                    \\\n"
            + "                    (key1)\n"
            + "                    /\n"
            + "    (null)\n"
            + "        \\\n"
            + "        (key2)\n"
            + "        /\n"
            + "    (null)\n"
            + "            \\\n"
            + "            (key2)\n"
            + "            /\n"
            + "        (null)\n"
            + "                \\\n"
            + "                (key2)\n"
            + "                /\n"
            + "(null)\n"
            + "    \\\n"
            + "    (key3)\n"
            + "    /\n"
            + "(null)\n"
            + "        \\\n"
            + "        (key3)\n"
            + "        /\n"
            + "    (null)\n"
            + "            \\\n"
            + "            (key3)\n"
            + "            /\n"
            + "        (null)\n"
            + "Number of records: 9\n"
            + "Location Tree:\n"
            + "(Leaf with 3 objects: 2 1 3)\n"
            + "Found record with ID 1:\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Seminars with dates in range 0 to 1:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "7 nodes visited in this search\n"
            + "Seminars with costs in range 0 to 100:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "7 nodes visited in this search\n"
            + "Seminars matching keyword key1:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "Seminars within 20 units of 0, 0:\n"
            + "Found a record with key value 2 at 10, 10\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "Found a record with key value 3 at 10, 10\n"
            + "1 nodes visited in this search\n"
            + "Seminars with dates in range 0610051600 to 0610051600:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "4 nodes visited in this search\n"
            + "Seminars with dates in range 0610051601 to 0610051601:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with dates in range 0610051599 to 0610051599:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with dates in range 0610051600 to 0610051601:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "7 nodes visited in this search\n"
            + "Seminars with dates in range 0610051599 to 0610051600:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "7 nodes visited in this search\n"
            + "Seminars with dates in range 0610051601 to 0610051602:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with dates in range 0610051598 to 0610051599:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with dates in range 0610051601 to 0610051600:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with dates in range 0610051600 to 0610051599:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with dates in range 0610051602 to 0610051601:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with dates in range 0610051599 to 0610051598:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with costs in range 50 to 50:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "4 nodes visited in this search\n"
            + "Seminars with costs in range 49 to 49:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with costs in range 51 to 51:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with costs in range 50 to 51:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "7 nodes visited in this search\n"
            + "Seminars with costs in range 49 to 50:\n"
            + "ID: 3, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 1, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "ID: 2, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 10, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "7 nodes visited in this search\n"
            + "Seminars with costs in range 51 to 52:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with costs in range 48 to 49:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with costs in range 51 to 50:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with costs in range 50 to 49:\n"
            + "4 nodes visited in this search\n"
            + "Seminars with costs in range 52 to 51:\n"
            + "2 nodes visited in this search\n"
            + "Seminars with costs in range 49 to 48:\n"
            + "4 nodes visited in this search\n"
            + "Successfully inserted record with ID 4\n"
            + "ID: 4, Title: Seminar 2\n"
            + "Date: 0610051600, Length: 100, X: 9, Y: 10, Cost: 50\n"
            + "Description: This is Seminar 2\n"
            + "Keywords: key1, key2, key3\n"
            + "Successfully inserted record with ID 5\n"
            + "ID: 5, Title: Seminar 1\n"
            + "Date: 0610051600, Length: 100, X: 13, Y: 4, Cost: 50\n"
            + "Description: This is Seminar 1\n"
            + "Keywords: key1, key2, key3\n"
            + "Successfully inserted record with ID 6\n"
            + "ID: 6, Title: Seminar 3\n"
            + "Date: 0610051600, Length: 100, X: 7, Y: 9, Cost: 50\n"
            + "Description: This is Seminar 3\n"
            + "Keywords: key1, key2, key3\n"
            + "Location Tree:\n"
            + "                                            (I)\n"
            + "                                        (E)\n"
            + "                                        (I)\n"
            + "                                    (E)\n"
            + "                                    (I)\n"
            + "                                (E)\n"
            + "                                (I)\n"
            + "                            (E)\n"
            + "                            (I)\n"
            + "                        (E)\n"
            + "                        (I)\n"
            + "                    (E)\n"
            + "                    (I)\n"
            + "                (I)\n"
            + "            (I)\n"
            + "        (E)\n"
            + "        (I)\n"
            + "    (E)\n"
            + "    (I)\n"
            + "(Leaf with 3 objects: 2 1 3)\n"
            + "(Leaf with 1 objects: 4)\n"
            + "            (Leaf with 1 objects: 5)\n"
            + "                (Leaf with 1 objects: 6)\n"
            + "Record with ID 3 successfully deleted from the database\n"
            + "Location Tree:\n"
            + "                                            (I)\n"
            + "                                        (E)\n"
            + "                                        (I)\n"
            + "                                    (E)\n"
            + "                                    (I)\n"
            + "                                (E)\n"
            + "                                (I)\n"
            + "                            (E)\n"
            + "                            (I)\n"
            + "                        (E)\n"
            + "                        (I)\n"
            + "                    (E)\n"
            + "                    (I)\n"
            + "                (I)\n"
            + "            (I)\n"
            + "        (E)\n"
            + "        (I)\n"
            + "    (E)\n"
            + "    (I)\n"
            + "(Leaf with 2 objects: 2 1)\n"
            + "(Leaf with 1 objects: 4)\n"
            + "            (Leaf with 1 objects: 5)\n"
            + "                (Leaf with 1 objects: 6)\n"
            + "Seminars within 1 units of 0, 0:\n"
            + "8 nodes visited in this search\n"
            + "Seminars within 4 units of 0, 0:\n"
            + "8 nodes visited in this search\n"
            + "Seminars within 10 units of 0, 0:\n"
            + "15 nodes visited in this search\n"
            + "Seminars within 20 units of 0, 0:\n"
            + "Found a record with key value 6 at 7, 9\n"
            + "Found a record with key value 5 at 13, 4\n"
            + "Found a record with key value 4 at 9, 10\n"
            + "Found a record with key value 2 at 10, 10\n"
            + "Found a record with key value 1 at 10, 10\n"
            + "19 nodes visited in this search",
            systemOut().getHistory());
    }


    public void testError()
    {
        String[] args = new String[2];
        args[0] = "a";
        args[1] = "TestInput";

        SemSearch.main(args);

        args[0] = "2";
        args[1] = null;

        SemSearch.main(args);

        args = null;
        SemSearch.main(args);

        args = new String[1];
        SemSearch.main(args);

        fuzzyEquals(
            "Invalid number format for worldSize. Please provide an integer.\r\n"
                + "An error occurred: null\r\n"
                + "java.lang.NullPointerException\r\n"
                + "    at java.base/java.io.File.<init>(File.java:276)\r\n"
                + "    at CommandProcessor.<init>(CommandProcessor.java:30)\r\n"
                + "    at SemSearch.main(SemSearch.java:68)\r\n"
                + "    at ReferenceTest.testError(ReferenceTest.java:85)\r\n"
                + "    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n"
                + "    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n"
                + "    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n"
                + "    at java.base/java.lang.reflect.Method.invoke(Method.java:566)\r\n"
                + "    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)\r\n"
                + "    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\r\n"
                + "    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)\r\n"
                + "    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\r\n"
                + "    at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n"
                + "    at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n"
                + "    at student.testingsupport.junit4.RunTestMethodWrapper.evaluate(RunTestMethodWrapper.java:74)\r\n"
                + "    at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)\r\n"
                + "    at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)\r\n"
                + "    at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)\r\n"
                + "    at java.base/java.lang.Thread.run(Thread.java:834)\r\n"
                + "Usage: java SemSearch <worldSize> <commandFile>\r\n"
                + "Usage: java SemSearch <worldSize> <commandFile>\r\n" + "",
            systemOut().getHistory());
    }
}
