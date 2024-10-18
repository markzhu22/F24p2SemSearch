/**
 * Binary Search Tree implementation for storing and retrieving Seminar objects
 * based on different attributes such as ID, date, cost, and keyword.
 * 
 * Provides methods for inserting, searching, and removing nodes from the tree,
 * ordered by the respective attribute. Also supports range searches for dates
 * and costs.
 * 
 * @author markz + tarinid
 * @version Oct 4, 2024
 */
public class BinarySearchTree {
    private BSTNode root; // Root of the BST
    private int nodecount; // Number of nodes in the BST
    private int traversalCount = 0;

    // ----------------------------------------------------------
    /**
     * Create a new BinarySearchTree object.
     */
    public BinarySearchTree() {
        root = null;
        nodecount = 0;
    }


    // ----------------------------------------------------------
    /**
     * Getter function for the size of the tree.
     * 
     * @return the size of the tree
     */
    public int size() {
        return nodecount;
    }


    // ----------------------------------------------------------
    /**
     * Find a seminar using the ID.
     * 
     * @param id
     *            ID to be searched
     * @return the seminar the id correlates to, or null if not found
     */
    public Seminar findById(int id) {
        return findByIdHelp(root, id);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method for finding a Seminar by its ID.
     * 
     * @param rt
     *            the current node being examined
     * @param id
     *            ID to be searched
     * @return the Seminar if found, or null otherwise
     */
    private Seminar findByIdHelp(BSTNode rt, int id) {
        if (isNull(rt)) {
            return null;
        }
        if (rt.semValue().id() > id) {
            return findByIdHelp(rt.left(), id);
        }
        else if (rt.semValue().id() == id) {
            return rt.semValue();
        }
        else {
            return findByIdHelp(rt.right(), id);
        }
    }


    // ----------------------------------------------------------
    /**
     * Find seminars using a range of date.
     * 
     * @param low
     *            lower bound of date
     * @param high
     *            upper bound of date
     * @return true if a seminar within that range was found
     */
    public boolean findByDateRange(String low, String high) {
        return findByDateRangeHelper(root, low, high);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to find Seminars within a date range.
     * 
     * @param rt
     *            the current node being examined
     * @param low
     *            lower bound of the date range
     * @param high
     *            upper bound of the date range
     * @return true if a Seminar within the range is found, false otherwise
     */
    private boolean findByDateRangeHelper(BSTNode rt, String low, String high) {
        traversalCount++;
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

        if (low.equals(high) && isEquals(rt.semValue().date().compareTo(low),
            0)) {
            found |= findByDateRangeHelper(rt.left(), low, high);
            if (rt.semValue().date().compareTo(low) >= 0 && rt.semValue().date()
                .compareTo(high) <= 0) {
                System.out.println(rt.semValue());
                found = true;
            }
        }
        else {
            if (rt.semValue().date().compareTo(low) >= 0) {
                found |= findByDateRangeHelper(rt.left(), low, high);
            }

            if (rt.semValue().date().compareTo(low) >= 0 && rt.semValue().date()
                .compareTo(high) <= 0) {
                System.out.println(rt.semValue());
                found = true;
            }
            if (rt.semValue().date().compareTo(high) <= 0) {
                found |= findByDateRangeHelper(rt.right(), low, high);
            }
        }

        return found;
    }


    // ----------------------------------------------------------
    /**
     * Find seminars using a range of cost.
     * 
     * @param low
     *            lower bound of cost
     * @param high
     *            upper bound of cost
     * @return true if a seminar within that cost range is found
     */
    public boolean findByCostRange(int low, int high) {
        return findByCostRangeHelper(root, low, high);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to find seminars within a cost range.
     * 
     * @param rt
     *            the current node being examined
     * @param low
     *            lower bound of the cost range
     * @param high
     *            upper bound of the cost range
     * @return true if a seminar within the range is found, false otherwise
     */
    private boolean findByCostRangeHelper(BSTNode rt, int low, int high) {
        traversalCount++;
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

        if (low == high && isEquals(rt.semValue().cost(), low)) {
            found |= findByCostRangeHelper(rt.left(), low, high);
            if (rt.semValue().cost() >= low && rt.semValue().cost() <= high) {
                System.out.println(rt.semValue());
                found = true;
            }
        }
        else {
            if (rt.semValue().cost() >= low) {
                found |= findByCostRangeHelper(rt.left(), low, high);
            }
            if (rt.semValue().cost() >= low && rt.semValue().cost() <= high) {
                System.out.println(rt.semValue());
                found = true;
            }
            if (rt.semValue().cost() <= high) {
                found |= findByCostRangeHelper(rt.right(), low, high);
            }
        }

        return found;
    }


    // ----------------------------------------------------------
    /**
     * Find seminars using a keyword.
     * 
     * @param keyword
     *            the keyword to search with
     * @return a string containing the seminar details if found, or an empty
     *         string otherwise
     */
    public String findByKeyword(String keyword) {
        return findByKeywordHelper(root, keyword);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to find seminars by keyword.
     * 
     * @param rt
     *            the current node being examined
     * @param keyword
     *            the keyword to search for
     * @return a string containing the seminar details if found, or an empty
     *         string otherwise
     */
    private String findByKeywordHelper(BSTNode rt, String keyword) {
        String result = "";
        if (isNull(rt)) {
            return "";
        }

        if (rt.stringValue().equals(keyword)) {
            result = "ID: " + rt.semValue().id() + ", Title: " + rt.semValue()
                .title() + "\r\n" + "Date: " + rt.semValue().date()
                + ", Length: " + rt.semValue().length() + ", X: " + rt
                    .semValue().x() + ", Y: " + rt.semValue().y() + ", Cost: "
                + rt.semValue().cost() + "\r\n" + "Description: " + rt
                    .semValue().desc() + "\r\n" + "Keywords: ";

            for (String kywd : rt.semValue().keywords()) {
                if (kywd.equals(rt.semValue().keywords()[0])) {
                    result = result + (kywd);
                }
                else {
                    result = result + ", " + kywd;
                }
            }
            result = result + "\n";
        }

        String foundInLeft = findByKeywordHelper(rt.left(), keyword);
        result = foundInLeft + result;
        String foundInRight = findByKeywordHelper(rt.right(), keyword);
        result = foundInRight + result;

        return result;
    }


    // ----------------------------------------------------------
    /**
     * Find if a seminar exists in the tree.
     * 
     * @param seminar
     *            the seminar to search for
     * @return true if the seminar is found, false otherwise
     */
    public boolean find(Seminar seminar) {
        return findHelp(root, seminar) != null;
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to find a seminar in the tree.
     * 
     * @param rt
     *            the current node being examined
     * @param seminar
     *            the seminar to search for
     * @return the BSTNode containing the seminar if found, or null otherwise
     */
    private BSTNode findHelp(BSTNode rt, Seminar seminar) {
        if (rt == null) {
            return null;
        }
        BSTNode temp = rt;

        if (seminar.id() != rt.semValue().id()) {
            if (seminar.id() < rt.semValue().id()) {
                temp = findHelp(rt.left(), seminar);
            }
            else {
                temp = findHelp(rt.right(), seminar);
            }
        }
        else {
            return temp;
        }

        return temp;
    }


    // ----------------------------------------------------------
    /**
     * Insert a seminar into the tree ordered by their ID.
     * 
     * @param seminar
     *            the seminar to be stored
     */
    public void insertById(Seminar seminar) {
        root = insertByIdHelp(root, seminar);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to insert a seminar by ID.
     * 
     * @param rt
     *            the current node being examined
     * @param seminar
     *            the seminar to insert
     * @return the updated BSTNode
     */
    private BSTNode insertByIdHelp(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(seminar, seminar);
        }

        if (seminar.id() < (rt.semValue().id())) {
            rt.setLeft(insertByIdHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByIdHelp(rt.right(), seminar));
        }

        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to insert a seminar by date.
     * 
     * @param rt
     *            the current node being examined
     * @param seminar
     *            the seminar to insert
     * @return the updated BSTNode
     */
    private BSTNode insertByDateHelp(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(seminar, seminar);
        }

        if (seminar.date().compareTo(rt.semValue().date()) <= 0) {
            rt.setLeft(insertByDateHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByDateHelp(rt.right(), seminar));
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Insert a seminar into the tree ordered by their date.
     * 
     * @param seminar
     *            the seminar to be stored
     */
    public void insertByDate(Seminar seminar) {
        root = insertByDateHelp(root, seminar);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to insert a seminar by cost.
     * 
     * @param rt
     *            the current node being examined
     * @param seminar
     *            the seminar to insert
     * @return the updated BSTNode
     */
    private BSTNode insertByCostHelp(BSTNode rt, Seminar seminar) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(seminar, seminar);
        }

        else if (seminar.cost() <= rt.semValue().cost()) {
            rt.setLeft(insertByCostHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByCostHelp(rt.right(), seminar));
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Insert a seminar into the tree ordered by their cost.
     * 
     * @param seminar
     *            the seminar to be stored
     */
    public void insertByCost(Seminar seminar) {
        root = insertByCostHelp(root, seminar);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to insert a seminar by keyword.
     * 
     * @param rt
     *            the current node being examined
     * @param keywords
     *            the keyword associated with the seminar
     * @param sem
     *            the seminar to insert
     * @return the updated BSTNode
     */
    private BSTNode insertByKeywordHelp(
        BSTNode rt,
        String keywords,
        Seminar sem) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(keywords, sem);
        }
        if (keywords.compareTo(rt.stringValue()) <= 0) {
            rt.setLeft(insertByKeywordHelp(rt.left(), keywords, sem));
        }
        else {
            rt.setRight(insertByKeywordHelp(rt.right(), keywords, sem));
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Insert a seminar into the tree ordered by their keywords.
     * 
     * @param seminar
     *            the seminar to be stored
     */
    public void insertByKeyword(Seminar seminar) {
        for (String keyword : seminar.keywords()) {
            root = insertByKeywordHelp(root, keyword, seminar);
        }
    }


    // ----------------------------------------------------------
    /**
     * Find the seminar with the maximum value in the tree.
     * 
     * @param rt
     *            the current node being examined
     * @return the seminar with the maximum value
     */
    public Seminar findMax(BSTNode rt) {
        BSTNode copy = rt;

        if (isNull(copy)) {
            return null;
        }

        while (!isNull(copy.right())) {
            copy = copy.right();
        }

        return copy.semValue();
    }


    // ----------------------------------------------------------
    /**
     * Find the maximum string value in the tree.
     * 
     * @param rt
     *            the current node being examined
     * @return the maximum string value
     */
    public String findStringMax(BSTNode rt) {
        BSTNode copy = rt;

        if (isNull(copy)) {
            return null;
        }

        while (!isNull(copy.right())) {
            copy = copy.right();
        }

        return copy.stringValue();
    }


    // ----------------------------------------------------------
    /**
     * Delete the node with the maximum value from the tree.
     * 
     * @param rt
     *            the current node being examined
     * @return the updated BSTNode after deletion
     */
    public BSTNode deleteMax(BSTNode rt) {
        if (isNull(rt.right())) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Remove the seminar with the given ID from the tree.
     * 
     * @param id
     *            ID of the seminar to be removed
     */
    public void removeById(int id) {
        root = removeByIdHelp(root, id);
        nodecount = decrement(nodecount);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to remove a seminar by ID.
     * 
     * @param rt
     *            the current node being examined
     * @param id
     *            ID of the seminar to be removed
     * @return the updated BSTNode after removal
     */
    private BSTNode removeByIdHelp(BSTNode rt, int id) {
        if (isNull(rt)) {
            return null;
        }
        if (id < rt.semValue().id()) {
            rt.setLeft(removeByIdHelp(rt.left(), id));
        }
        else if (id > rt.semValue().id()) {
            rt.setRight(removeByIdHelp(rt.right(), id));
        }
        else {
            if (isNull(rt.left())) {
                return rt.right();
            }
            else if (isNull(rt.right())) {
                return rt.left();
            }
            else {
                rt.setValue(findMax(rt.left()));
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Remove the seminar with the given date from the tree.
     * 
     * @param date
     *            the seminar containing the date to be removed
     */
    public void removeByDate(Seminar date) {
        root = removeByDateHelp(root, date);
        nodecount = decrement(nodecount);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to remove a seminar by date.
     * 
     * @param rt
     *            the current node being examined
     * @param date
     *            the seminar containing the date to be removed
     * @return the updated BSTNode after removal
     */
    private BSTNode removeByDateHelp(BSTNode rt, Seminar date) {
        if (isNull(rt)) {
            return null;
        }
        if (date.date().compareTo(rt.semValue().date()) < 0) {
            rt.setLeft(removeByDateHelp(rt.left(), date));
        }
        else if (date.date().compareTo(rt.semValue().date()) > 0) {
            rt.setRight(removeByDateHelp(rt.right(), date));
        }
        else {
            if (rt.semValue().id() != date.id()) {
                rt.setLeft(removeByDateHelp(rt.left(), date));
            }
            else {
                if (isNull(rt.left())) {
                    return rt.right();
                }
                else if (isNull(rt.right())) {
                    return rt.left();
                }
                else {
                    rt.setValue(findMax(rt.left()));
                    rt.setLeft(deleteMax(rt.left()));
                }
            }
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Remove the seminar with the given cost from the tree.
     * 
     * @param cost
     *            the seminar containing the cost to be removed
     */
    public void removeByCost(Seminar cost) {
        root = removeByCostHelp(root, cost);
        nodecount = decrement(nodecount);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to remove a seminar by cost.
     * 
     * @param rt
     *            the current node being examined
     * @param cost
     *            the seminar containing the cost to be removed
     * @return the updated BSTNode after removal
     */
    private BSTNode removeByCostHelp(BSTNode rt, Seminar cost) {
        if (isNull(rt)) {
            return null;
        }
        if (cost.cost() < rt.semValue().cost()) {
            rt.setLeft(removeByCostHelp(rt.left(), cost));
        }
        else if (cost.cost() > rt.semValue().cost()) {
            rt.setRight(removeByCostHelp(rt.right(), cost));
        }
        else {
            if (rt.semValue().id() != cost.id()) {
                rt.setLeft(removeByCostHelp(rt.left(), cost));
            }
            else {
                if (isNull(rt.left())) {
                    return rt.right();
                }
                else if (isNull(rt.right())) {
                    return rt.left();
                }
                else {
                    rt.setValue(findMax(rt.left()));
                    rt.setLeft(deleteMax(rt.left()));
                }
            }
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Remove the seminar associated with the given keyword from the tree.
     * 
     * @param keyword
     *            the keyword of the seminar to be removed
     * @param sem
     *            the corresponding seminar the keyword should be in
     */
    public void removeByKeyword(String keyword, Seminar sem) {
        root = removeByKeywordHelp(root, keyword, sem);
        nodecount = decrement(nodecount);
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to remove a seminar by keyword.
     * 
     * @param rt
     *            the current node being examined
     * @param keyword
     *            the keyword of the seminar to be removed
     * @param sem
     *            the corresponding seminar the keyword should be in
     * @return the updated BSTNode after removal
     */
    private BSTNode removeByKeywordHelp(
        BSTNode rt,
        String keyword,
        Seminar sem) {
        if (rt == null) {
            return null;
        }
        if (rt.stringValue().compareTo(keyword) > 0) {
            rt.setLeft(removeByKeywordHelp(rt.left(), keyword, sem));
        }
        else if (rt.stringValue().compareTo(keyword) < 0) {
            rt.setRight(removeByKeywordHelp(rt.right(), keyword, sem));
        }
        else {
            if (rt.semValue().id() != sem.id()) {
                rt.setLeft(removeByKeywordHelp(rt.left(), keyword, sem));
            }
            if (isNull(rt.left())) {
                return rt.right();
            }
            else if (isNull(rt.right())) {
                return rt.left();
            }
            else {
                rt.setStringValue(findStringMax(rt.left()));
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }


    // ----------------------------------------------------------
    /**
     * Clears the tree, removing all nodes.
     */
    public void clear() {
        root = null;
        nodecount = 0;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the root node.
     * 
     * @return the root node of the tree
     */
    public BSTNode getRoot() {
        return root;
    }


    // ----------------------------------------------------------
    /**
     * Retrieves the number of nodes traversed during searches.
     * 
     * @return the number of nodes traversed
     */
    public int getTraversalCount() {
        return traversalCount;
    }


    // ----------------------------------------------------------
    /**
     * Resets the traversal counter to zero.
     */
    public void resetTraversalCount() {
        traversalCount = 0;
    }


    // ----------------------------------------------------------
    // Mutation Testing Functions
    // ----------------------------------------------------------
    /**
     * Checks if the given object is null.
     * 
     * @param s
     *            object to check
     * @return true if null, false otherwise
     */
    public boolean isNull(Object s) {
        return s == null;
    }


    // ----------------------------------------------------------
    /**
     * Decreases an integer value by one.
     * 
     * @param i
     *            the integer to be decremented
     * @return the decremented integer
     */
    public int decrement(int i) {
        return i - 1;
    }


    // ----------------------------------------------------------
    /**
     * Checks if two objects are equal.
     * 
     * @param i
     *            first object
     * @param j
     *            second object
     * @return true if equal, false otherwise
     */
    public boolean isEquals(Object i, Object j) {
        return i.equals(j);
    }
}
