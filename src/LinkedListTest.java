import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for the LinkedList class.
 * 
 * This class tests the functionality of the LinkedList, including methods for
 * adding, retrieving, removing, and printing seminars.
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class LinkedListTest {
    private LinkedList list; // The linked list to be tested
    private Seminar seminar1; // Seminar object for testing
    private Seminar seminar2; // Seminar object for testing
    private Seminar seminar3; // Seminar object for testing

    /**
     * Sets up the test environment before each test case.
     * Initializes a LinkedList and Seminar objects for testing.
     */
    @Before
    public void setUp() {
        list = new LinkedList();
        seminar1 = new Seminar();
        seminar1.setId(1);
        seminar2 = new Seminar();
        seminar2.setId(2);
        seminar3 = new Seminar();
        seminar3.setId(3);
    }


    /**
     * Tests the add method and size of the LinkedList.
     * Verifies that seminars are added correctly and the size is updated.
     */
    @Test
    public void testAddAndSize() {
        assertTrue(list.isEmpty());
        list.add(seminar2);
        assertEquals(1, list.size());
        list.add(seminar1);
        assertEquals(2, list.size());
        list.add(seminar3);
        assertEquals(3, list.size());
    }


    /**
     * Tests the get method of the LinkedList.
     * Verifies that the correct seminar is returned for each index.
     */
    @Test
    public void testGet() {
        list.add(seminar2);
        list.add(seminar1);
        list.add(seminar3);

        assertEquals(seminar1, list.get(0));
        assertEquals(seminar2, list.get(1));
        assertEquals(seminar3, list.get(2));
    }


    /**
     * Tests the get method for out-of-bounds access.
     * Verifies that an exception is thrown when accessing an invalid index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        list.get(0); // Should throw exception since the list is empty
    }


    /**
     * Tests the remove method of the LinkedList.
     * Verifies that seminars are removed correctly and the size is updated.
     */
    @Test
    public void testRemove() {
        list.add(seminar2);
        list.add(seminar1);
        list.add(seminar3);

        assertEquals(3, list.size());
        list.remove(1); // Remove seminar2
        assertEquals(2, list.size());
        assertEquals(seminar1, list.get(0));
        assertEquals(seminar3, list.get(1));

        list.remove(0); // Remove seminar1
        assertEquals(1, list.size());
        assertEquals(seminar3, list.get(0));

        list.remove(0); // Remove seminar3
        assertTrue(list.isEmpty());
    }


    /**
     * Tests the remove method for out-of-bounds access.
     * Verifies that an exception is thrown when removing from an invalid index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        list.remove(0); // Should throw exception since the list is empty
    }


    /**
     * Tests the isEmpty method of the LinkedList.
     * Verifies that the method correctly identifies an empty list.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(seminar1);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }


    /**
     * Tests the printList method of the LinkedList.
     * Verifies that the correct output is produced when printing the list.
     */
    @Test
    public void testPrintList() {
        // Capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.add(seminar2);
        list.add(seminar1);
        list.add(seminar3);
        list.printList(); // Should print: "1 2 3 "

        String expectedOutput = "1 2 3 \n";
        assertEquals(expectedOutput, outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }
}
