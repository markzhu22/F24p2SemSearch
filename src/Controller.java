public class Controller
{
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
    public Controller(int worldSize)
    {
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

        if (idTree.find(seminar)) {
            System.out.println("Insert FAILED - There is already a record with ID " + seminar.id());
            return;
        }
        
        idTree.insertById(seminar);
        dateTree.insertByDate(seminar);
        costTree.insertByCost(seminar);
        keywordTree.insertByKeyword(seminar);

        System.out.print("Successfully inserted record with ID " + seminar.id() + "\n");
        System.out.print(
            "ID: " + seminar.id() + ", Title: " + seminar.title() + "\r\n"
                + "Date: " + seminar.date() + ", Length: " + seminar.length()
                + ", X: " + seminar.x() + ", Y: " + seminar.y() + ", Cost: "
                + seminar.cost() + "\r\n" + "Description: " + seminar.desc()
                + "\r\n" + "Keywords: ");
        for (String kywd : seminar.keywords())
        {
            if (kywd.equals(seminar.keywords()[0]))
            {
                System.out.print(kywd);
            }
            else {
                System.out.print(", " + kywd);
            }
        }
        System.out.print("\n");
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

            dateTree.removeByDate(seminar.date());

            costTree.removeByCost(seminar.cost());

            keywordTree.removeByKeyword(seminar.keywords()[0]);

            System.out.println(
                "Record with ID " + id
                    + " successfully deleted from the database");
        }
        else
        {
            System.out.println("Record with ID " + id + " not found.");
        }
    }


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
            System.out.println(seminar);
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
    public void searchByKeyword(String keyword)
    {
        System.out.println("Seminars matching keyword " + keyword + ":");
        boolean found = keywordTree.findByKeyword(keyword);
    }


    /**
     * Searches for seminars within the given cost range.
     * 
     * @param low
     *            The lower bound of the cost range.
     * @param high
     *            The upper bound of the cost range.
     */
    public void searchByCostRange(int low, int high)
    {
        System.out
            .println("Seminars with costs in range " + low + " to " + high + ":");
        boolean found = costTree.findByCostRange(low, high);
        if (!found)
        {
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
    public void searchByDateRange(String low, String high)
    {
        System.out
            .println("Seminars with dates in range " + low + " to " + high + ":");
        boolean found = dateTree.findByDateRange(low, high);

        if (!found)
        {
            System.out.println(
                "Search FAILED -- No seminars found in date range " + low
                    + " to " + high);
        }
    }

    /**
     * Prints all the seminars based on a specific tree (id, date, cost,
     * keyword, location).
     * 
     * @param field
     *            The field to print by ("id", "date", "cost", "keyword", or
     *            "location").
     */
// public void print(String field) {
// switch (field) {
// case "ID":
// System.out.println("ID Tree:");
// printIndented(idTree, idTree.getRoot(), calculateHeight(idTree
// .getRoot()) + 1, false, field);
// break;
// case "date":
// System.out.println("Date Tree:");
// printIndented(dateTree, dateTree.getRoot(), 0, false, field);
// break;
// case "cost":
// System.out.println("Cost Tree:");
// printIndented(costTree, costTree.getRoot(), 0, false, field);
// break;
// case "keyword":
// System.out.println("Keyword Tree:");
// printIndented(keywordTree, keywordTree.getRoot(), 0, false,
// field);
// break;
// // case "location":
// // System.out.println("Location Tree:");
// // printPreOrder(locationTree.getRoot(), 0);
// // break;
// default:
// System.out.println("Invalid field: " + field);
// }
// }


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
            default:
                System.out.println("Invalid field: " + field);
        }
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

        return increment(Math
            .max(calculateHeight(node.left()), calculateHeight(node.right())));
    }

    /**
     * Prints all the seminars based on a specific tree (id, date, cost,
     * keyword, location).
     * 
     * @param field
     *            The field to print by ("ID", "date", "cost", "keyword", or
     *            "location").
     */
// public void print(String field) {
// int height;
// switch (field) {
// case "ID":
// System.out.println("ID Tree:");
// height = calculateHeight(idTree.getRoot());
// printIndented(idTree.getRoot(), 0, false, height, field);
// break;
// case "date":
// System.out.println("Date Tree:");
// height = calculateHeight(dateTree.getRoot());
// printIndented(dateTree.getRoot(), 0, false, height, field);
// break;
// case "cost":
// System.out.println("Cost Tree:");
// height = calculateHeight(costTree.getRoot());
// printIndented(costTree.getRoot(), 0, false, height, field);
// break;
// case "keyword":
// System.out.println("Keyword Tree:");
// height = calculateHeight(keywordTree.getRoot());
// printIndented(keywordTree.getRoot(), 0, false, height, field);
// break;
// default:
// System.out.println("Invalid field: " + field);
// }
// }

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
// private void printIndented(
// BSTNode node,
// int level,
// boolean traverseLeft,
// int height,
// String field) {
// if (node == null) {
// int indentLevel = height - level;
// for (int i = 0; i < indentLevel; i++) {
// System.out.print(" ");
// }
// System.out.println("(null)");
// System.out.println(traverseLeft ? "/" : "\\");
// return;
// }
//
// printIndented(node.left(), level + 1, true, height, field);
//
// int indentLevel = height - level;
// for (int i = 0; i < indentLevel; i++) {
// System.out.print(" ");
// }
//
// String nodeValue;
// switch (field) {
// case "ID":
// nodeValue = String.valueOf(node.value().id());
// break;
// case "date":
// nodeValue = node.value().date();
// break;
// case "cost":
// nodeValue = String.valueOf(node.value().cost());
// break;
// case "keyword":
// nodeValue = String.join(", ", node.value().keywords());
// break;
// // case "location":
// // System.out.println("Location Tree:");
// // printPreOrder(locationTree.getRoot(), 0);
// // break;
// default:
// nodeValue = "Invalid field";
// }
//
// System.out.println("(" + nodeValue + ")");
// System.out.println(traverseLeft ? "/" : "\\");
//
// printIndented(node.right(), level + 1, false, height, field);
// }

    /**
     * Preorder traversal for location tree (assuming BinTree or similar
     * structure).
     * 
     * @param node
     *            The current node being visited.
     * @param level
     *            The current level (used to calculate indentation). private
     *            void printPreOrder(BSTNode node, int level) { if (node ==
     *            null) { return; } for (int i = 0; i < level; i++) {
     *            System.out.print(" "); } System.out.println(node.value());
     *            printPreOrder(node.left(), level + 1);
     *            printPreOrder(node.right(), level + 1); }
     */

    public int increment(int i) {
        return i+=1;
    }
}
