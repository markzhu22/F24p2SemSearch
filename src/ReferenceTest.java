import java.io.FileNotFoundException;

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
     * Test SemSearch
     */
    public void testSemSearch() {
        String[] args = new String[2];
        args[0] = "16";
        args[1] = "TestInput.txt";

        SemSearch.main(args);
        
        assertFuzzyEquals("Search FAILED -- There is no record with ID 1\r\n"
            + "Seminars matching keyword VT:\r\n"
            + "Successfully inserted record with ID 1\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 100\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Successfully inserted record with ID 2\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "Found record with ID 1:\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 100\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Seminars with costs in range 0 to 100:\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 100\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Seminars with dates in range 0 to 1:\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 1, Y: 10, Cost: 100\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "Seminars matching keyword VT:\r\n"
            + "VT\r\n"
            + "VT\r\n"
            + "ID Tree:\r\n"
            + "    (null)\r\n"
            + "        \\\r\n"
            + "        (1)\r\n"
            + "        /\r\n"
            + "(null)\r\n"
            + "    \\\r\n"
            + "    (2)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "Number of records: 2\r\n"
            + "Record with ID 1 successfully deleted from the database\r\n"
            + "Record with ID 1 not found.\r\n"
            + "Seminars with costs in range 0 to 1:\r\n"
            + "Search FAILED -- No seminars found in cost range 0 to 1\r\n"
            + "Seminars with dates in range 0 to 0:\r\n"
            + "Search FAILED -- No seminars found in date range 0 to 0\r\n"
            + "ID Tree:\r\n"
            + "(null)\r\n"
            + "    \\\r\n"
            + "    (2)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "Number of records: 2\r\n"
            + "Date Tree:\r\n"
            + "(null)\r\n"
            + "    \\\r\n"
            + "    (0610071600)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "Number of records: 2\r\n"
            + "Cost Tree:\r\n"
            + "(null)\r\n"
            + "    \\\r\n"
            + "    (30)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "Number of records: 2\r\n"
            + "Invalid field: :3\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, -1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, -1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 101, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 101\r\n", systemOut().getHistory());
    }
    
    public void testError() {
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
        
        fuzzyEquals("Invalid number format for worldSize. Please provide an integer.\r\n"
            + "An error occurred: null\r\n"
            + "java.lang.NullPointerException\r\n"
            + "    at java.base/java.io.File.<init>(File.java:276)\r\n"
            + "    at CommandProcessor.<init>(CommandProcessor.java:12)\r\n"
            + "    at SemSearch.main(SemSearch.java:49)\r\n"
            + "    at ReferenceTest.testError(ReferenceTest.java:117)\r\n"
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
            + "Usage: java SemSearch <worldSize> <commandFile>", systemOut().getHistory());
    }
}
