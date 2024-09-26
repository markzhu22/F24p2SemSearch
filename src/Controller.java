public class Controller {
    private BinarySearchTree idTree; // BST for IDs
    private BinarySearchTree dateTree; // BST for dates
    private BinarySearchTree costTree; // BST for costs
    private BinarySearchTree keywordTree; // BST for keywords

    /**
     * Constructor to initialize all BSTs.
     * 
     * @param worldSize
     *            This is a placeholder for the world size, if needed.
     */
    public Controller(int worldSize) {
        idTree = new BinarySearchTree();
        dateTree = new BinarySearchTree();
        costTree = new BinarySearchTree();
        keywordTree = new BinarySearchTree();
    }


    /**
     * Inserts a new seminar into all the appropriate BinarySearchTrees.
     * 
     * @param seminar
     *            The seminar to insert.
     */
    public void insert(Seminar seminar) {
        // Check for invalid coordinates
        if (seminar.x() < 0 || seminar.y() < 0 || seminar.x() > 100 || seminar
            .y() > 100) {
            System.out.println("Insert FAILED - Bad x, y coordinates: "
                + seminar.x() + ", " + seminar.y());
            return;
        }

        idTree.insertById(seminar);
        dateTree.insertByDate(seminar);
        costTree.insertByCost(seminar);
        keywordTree.insertByKeyword(seminar);
    }


    /**
     * Removes a seminar from all the BinarySearchTrees.
     * 
     * @param id
     *            The ID of the seminar to remove.
     */
    public void remove(int id) {
        Seminar seminar = idTree.findById(id);
        if (seminar != null) {
            idTree.removeById(id);
            dateTree.removeByDate(seminar.date());
            costTree.removeByCost(seminar.cost());
            keywordTree.removeByKeyword(seminar.keywords()[0]);
        }
        else {
            System.out.println("Seminar with ID " + id + " not found.");
        }
    }


    /**
     * Searches for a seminar by its ID.
     * 
     * @param id
     *            The ID of the seminar to search for.
     */
    public void searchById(int id) {
        Seminar seminar = idTree.findById(id);
        if (seminar != null) {
            System.out.println("Found record with ID " + id + ":");
            System.out.println(seminar);
        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
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
        boolean found = keywordTree.findByKeyword(keyword);

        if (!found) {
            System.out.println(
                "Search FAILED -- No seminars found with keyword " + keyword);
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
        System.out.println("Searching seminars by cost range " + low + " - "
            + high);
        boolean found = costTree.findByCostRange(low, high);
        if (!found) {
            System.out.println(
                "Search FAILED -- No seminars found in cost range " + low
                    + " to " + high);
        }
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
        System.out.println("Searching seminars by date range " + low + " - "
            + high);
        boolean found = dateTree.findByDateRange(low, high);

        if (!found) {
            System.out.println(
                "Search FAILED -- No seminars found in date range " + low
                    + " to " + high);
        }
    }


    /**
     * Prints all the seminars based on a specific tree (id, date, cost,
     * keyword).
     * 
     * @param field
     *            The field to print by ("id", "date", "cost", or "keyword").
     */
    public void print(String field) {
        switch (field) {
            case "id":
                printInOrder(idTree);
                break;
            case "date":
                printInOrder(dateTree);
                break;
            case "cost":
                printInOrder(costTree);
                break;
            case "keyword":
                printInOrder(keywordTree);
                break;
            default:
                System.out.println("Invalid field: " + field);
        }
    }


    /**
     * Helper method to print the seminars in-order from a BinarySearchTree.
     * 
     * @param tree
     *            The BinarySearchTree to print.
     */
    private void printInOrder(BinarySearchTree tree) {
        printInOrderHelper(tree.getRoot());
    }


    /**
     * Recursive in-order traversal to print each seminar in the tree.
     * 
     * @param node
     *            The current node being visited.
     */
    private void printInOrderHelper(BSTNode node) {
        if (node != null) {
            printInOrderHelper(node.left());
            System.out.println(node.value());
            printInOrderHelper(node.right());
        }
    }
}
