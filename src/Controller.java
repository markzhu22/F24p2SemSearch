/**
 * Controller object class for Graph project (CS3114/CS5040 Fall 2023 Project
 * 2). Runs the commands from the commandProcessor.
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class Controller
{
    private BinarySearchTree idTree; // BST for IDs
    private BinarySearchTree dateTree; // BST for dates
    private BinarySearchTree costTree; // BST for costs
    private BinarySearchTree keywordTree; // BST for keywords
    private BinTree locationTree;

    /**
     * Constructor to initialize all BSTs.
     * 
     * @param worldSize
     *            This is a placeholder for the world size, if needed.
     */
    public Controller(int worldSize)
    {
        idTree = new BinarySearchTree();
        dateTree = new BinarySearchTree();
        costTree = new BinarySearchTree();
        keywordTree = new BinarySearchTree();
        locationTree = new BinTree(worldSize);
    }


    /**
     * Inserts a new seminar into all the appropriate BinarySearchTrees.
     * 
     * @param seminar
     *            The seminar to insert.
     */
    public void insert(Seminar seminar)
    {
        // Check for invalid coordinates
        if (seminar.x() < 0 || seminar.y() < 0 || seminar.x() > 100
            || seminar.y() > 100)
        {
            System.out.println(
                "Insert FAILED - Bad x, y coordinates: " + seminar.x() + ", "
                    + seminar.y());
            return;
        }

        if (idTree.find(seminar))
        {
            System.out.println(
                "Insert FAILED - There is already a record with ID "
                    + seminar.id());
            return;
        }

        // Insert into all trees and print the insertion success message
        // immediately
        idTree.insertById(seminar);
        dateTree.insertByDate(seminar);
        costTree.insertByCost(seminar);
        keywordTree.insertByKeyword(seminar);
        locationTree.insert(seminar);

        // Print success message immediately after insertion
        System.out.println("Successfully inserted record with ID " + seminar.id());
        printSeminar(seminar);
    }
            


    /**
     * Deletes a seminar with the given ID from all trees (ID, date, cost,
     * keyword).
     * 
     * @param id
     *            The ID of the seminar to delete.
     */
    public void delete(int id)
    {
        Seminar seminar = idTree.findById(id);
        if (seminar != null)
        {
            idTree.removeById(id);

            dateTree.removeByDate(seminar);

            costTree.removeByCost(seminar);

            locationTree.delete(seminar.getX(), seminar.getY());

            for (String kywd : seminar.keywords())
            {

                keywordTree.removeByKeyword(kywd, seminar);
            }

            System.out.println(
                "Record with ID " + id
                    + " successfully deleted from the database");
        }

        else
        {
            System.out
                .println("Delete FAILED -- There is no record with ID " + id);
        }
    }


    // Search Functions
    /**
     * Searches for a seminar by its ID.
     * 
     * @param id
     *            The ID of the seminar to search for.
     */
    public void searchById(int id)
    {
        Seminar seminar = idTree.findById(id);
        if (seminar != null)
        {
            System.out.println("Found record with ID " + id + ":");
            printSeminar(seminar);
        }
        else
        {
            System.out
                .println("Search FAILED -- There is no record with ID " + id);
        }
    }


    /**
     * Searches for seminars that match the given keyword.
     * 
     * @param keyword
     *            The keyword to search for.
     */
    public void searchByKeyword(String keyword) {
        System.out.println("Seminars matching keyword " + keyword + ":");
        String found = keywordTree.findByKeyword(keyword);
        if (found != null && !found.isEmpty()) {
            String[] seminarIds = found.split(",");
            for (String id : seminarIds) {
                Seminar seminar = idTree.findById(Integer.parseInt(id.trim()));
                if (seminar != null) {
                    printSeminar(seminar);
                }
            }
        }
    }
    


    /**
     * Searches for seminars within the given cost range.
     * 
     * @param low
     *            The lower bound of the cost range.
     * @param high
     *            The upper bound of the cost range.
     */
    public void searchByCostRange(int low, int high) {
        System.out.println("Seminars with costs in range " + low + " to " + high + ":");
        boolean found = costTree.findByCostRange(low, high);
        if (!found) {
            System.out.println("No seminars found within the specified cost range.");
        }
        System.out.println(costTree.getTraversalCount() + " nodes visited in this search");
        costTree.resetTraversalCount();
    }


    /**
     * Searches for seminars within the given date range.
     * 
     * @param low
     *            The lower bound of the date range.
     * @param high
     *            The upper bound of the date range.
     */
    public void searchByDateRange(String low, String high) {
        System.out.println("Seminars with dates in range " + low + " to " + high + ":");
        boolean found = dateTree.findByDateRange(low, high);
        if (!found) {
            System.out.println("No seminars found within the specified date range.");
        }
        System.out.println(dateTree.getTraversalCount() + " nodes visited in this search");
        dateTree.resetTraversalCount();
    }


    public void searchByLocation(int x, int y)
    {
        System.out.println("Searching for seminar at " + x + ", " + y + ":");
        Seminar result = locationTree.search(x, y);
        if (result != null)
        {
            System.out.println("Found record with ID " + result.id() + ":");
            printSeminar(result);
        }
        else
        {
            System.out.println("No seminar found at the specified location.");
        }
        System.out.println(
            locationTree.getNodesVisited() + " nodes visited in this search");
        locationTree.resetNodesVisited();
    }

    private void printSeminar(Seminar seminar) {
        System.out.println("id " + seminar.id() + " title " + seminar.title());
        System.out.println("date " + seminar.date() + " length " + seminar.length() + 
                           " x " + seminar.x() + " y " + seminar.y() + " cost " + seminar.cost());
        System.out.println("description " + seminar.desc());
        System.out.print("keywords");
        for (String keyword : seminar.keywords()) {
            System.out.print(" " + keyword);
        }
        System.out.println();
    }

    /**
     * Prints all the seminars based on a specific tree (id, date, cost,
     * keyword, location).
     * 
     * @param field
     *            The field to print by ("id", "date", "cost", "keyword", or
     *            "location").
     */
    public void print(String field)
    {
        int height;
        switch (field)
        {
            case "ID":
                System.out.println("ID Tree:");
                if (idTree.getRoot() == null)
                {
                    System.out.println("This tree is empty");
                    break;
                }
                height = calculateHeight(idTree.getRoot());
                printIndented(idTree, idTree.getRoot(), 0, height, field);
                System.out.println("Number of records: " + idTree.size());
                break;
            case "date":
                System.out.println("Date Tree:");
                height = calculateHeight(dateTree.getRoot());
                if (dateTree.getRoot() == null)
                {
                    System.out.println("This tree is empty");
                    break;
                }
                printIndented(dateTree, dateTree.getRoot(), 0, height, field);
                System.out.println("Number of records: " + dateTree.size());
                break;
            case "cost":
                System.out.println("Cost Tree:");
                height = calculateHeight(costTree.getRoot());
                if (costTree.getRoot() == null)
                {
                    System.out.println("This tree is empty");
                    break;
                }
                printIndented(costTree, costTree.getRoot(), 0, height, field);
                System.out.println("Number of records: " + costTree.size());
                break;
            case "keyword":
                System.out.println("Keyword Tree:");
                if (keywordTree.getRoot() == null)
                {
                    System.out.println("This tree is empty");
                    break;
                }
                height = calculateHeight(keywordTree.getRoot());
                printIndented(
                    keywordTree,
                    keywordTree.getRoot(),
                    0,
                    height,
                    field);
                System.out.println("Number of records: " + keywordTree.size());
                break;
            case "location":
                locationTree.printTree();
                break;
            default:
                System.out.println("Invalid field: " + field);
        }

    }


    /**
     * Helper method to print the tree with slashes for the structure.
     * 
     * @param node
     *            The current node being visited.
     * @param level
     *            The current level (used to calculate indentation).
     * @param height
     *            The height of the tree.
     * @param field
     *            The field being printed (id, date, cost, keyword).
     */
    private void printIndented(
        BinarySearchTree tree,
        BSTNode node,
        int level,
        int height,
        String field)
    {

        int spacesCount = Math.max(0, height - level);
        String space = "";

        for (int i = 0; i < spacesCount; i++)
        {
            space += "    ";
        }

        if (node == null)
        {
            System.out.println(space + "(null)");
            return;
        }

        printIndented(tree, node.left(), increment(level), height, field);

        String nodeValue = getNodeValue(node, field);
        System.out.println(space + "\\");
        System.out.println(space + "(" + nodeValue + ")");
        System.out.println(space + "/");

        printIndented(tree, node.right(), increment(level), height, field);
    }


    /**
     * Helper method to get the appropriate node value based on the field.
     * 
     * @param node
     *            The current node.
     * @param field
     *            The field being printed.
     * @return The value of the node for the given field.
     */
    private String getNodeValue(BSTNode node, String field)
    {
        String nodeValue = "";
        switch (field)
        {
            case "ID":
                nodeValue = String.valueOf(node.semValue().id());
                break;
            case "date":
                nodeValue = node.semValue().date();
                break;
            case "cost":
                nodeValue = String.valueOf(node.semValue().cost());
                break;
            case "keyword":
                nodeValue = String.valueOf(node.stringValue());
                break;
            default:
                nodeValue = "Invalid field";
        }
        return nodeValue;
    }


    /**
     * Helper method to calculate the height of a tree.
     * 
     * @param node
     *            The current node.
     * @return The height of the tree.
     */
    private int calculateHeight(BSTNode node)
    {
        if (node == null)
        {
            return 0;
        }

        return increment(
            Math.max(
                calculateHeight(node.left()),
                calculateHeight(node.right())));
    }

    // ----------------------------------------------------------
    // Mutation Testing Functions
    // ----------------------------------------------------------


    // ----------------------------------------------------------
    /**
     * Increments an integer by one
     * 
     * @param i
     *            the integer to be incremented
     * @return incremented i
     */
    public int increment(int i)
    {
        int result = i + 1;
        return result;

    }
}
