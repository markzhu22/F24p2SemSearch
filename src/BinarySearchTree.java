// -------------------------------------------------------------------------
/**
 * Binary Search Tree
 * 
 *  @author markz + tarinid
 *  @version Oct 4, 2024
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
     * Getter function for the size of the tree
     * @return the size
     */
    public int size() {
        return nodecount;
    }

    
    // ----------------------------------------------------------
    /**
     * Find using the ID
     * @param id
     *          ID to be searched
     * @return the seminar the id correlate to. Return null if did not find anything
     *          
     */
    public Seminar findById(int id) {
        return findByIdHelp(root, id);
    }
    
    private Seminar findByIdHelp(BSTNode rt, int id) {
        if (isNull(rt))
            return null;
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


    public boolean findByDateRange(String low, String high) {
        return findByDateRangeHelper(root, low, high);
    }
    
    private boolean findByDateRangeHelper(BSTNode rt, String low, String high) {
        traversalCount++;
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;
        
        if (low.equals(high) && rt.semValue().date().compareTo(low) == 0) {
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

    public boolean findByCostRange(int low, int high) {
        return findByCostRangeHelper(root, low, high);
    }
    
    private boolean findByCostRangeHelper(BSTNode rt, int low, int high) {
        traversalCount++;
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

        if (low == high && rt.semValue().cost() == low) {
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

    public String findByKeyword(String keyword) {
        return findByKeywordHelper(root, keyword);
    }
    
    private String findByKeywordHelper(BSTNode rt, String keyword) {
        String result = "";
        if (isNull(rt)) {
            return "";
        }

        if (rt.stringValue().equals(keyword)) {
            result = "ID: " + rt.semValue().id() + ", Title: " + rt.semValue().title() + "\r\n"
                    + "Date: " + rt.semValue().date() + ", Length: " + rt.semValue().length()
                    + ", X: " + rt.semValue().x() + ", Y: " + rt.semValue().y() + ", Cost: "
                    + rt.semValue().cost() + "\r\n" + "Description: " + rt.semValue().desc()
                    + "\r\n" + "Keywords: ";  
            for (String kywd : rt.semValue().keywords())
            {
                if (kywd.equals(rt.semValue().keywords()[0]))
                {
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

    public BSTNode findHelp(BSTNode rt, Seminar seminar) {
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
    
    public boolean find(Seminar seminar) {
        if (root == null) {
            return false;
        }
        
        if (findHelp(root, seminar) == null) {
            return false;
        }
        return true;
    }
    

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

    public void insertById(Seminar seminar) {
        root = insertByIdHelp(root, seminar);
    }


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


    public void insertByDate(Seminar seminar) {
        root = insertByDateHelp(root, seminar);
    }


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


    public void insertByCost(Seminar seminar) {
        root = insertByCostHelp(root, seminar);

    }


    private BSTNode insertByKeywordHelp(BSTNode rt, String keywords, Seminar sem) {
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


    public void insertByKeyword(Seminar seminar) {
        for (String keyword : seminar.keywords()) {
            root = insertByKeywordHelp(root, keyword, seminar);
        }
    }


    public Seminar findMax(BSTNode rt) {
        if (isNull(rt)) {
            return null;
        }

        while (!isNull(rt.right())) {
            rt = rt.right();
        }

        return rt.semValue();
    }
    
    public String findStringMax(BSTNode rt) {
        if (isNull(rt)) {
            return null;
        }

        while (!isNull(rt.right())) {
            rt = rt.right();
        }

        return rt.stringValue();
    }


    public BSTNode deleteMax(BSTNode rt) {
        if (isNull(rt.right()))
            return rt.left();
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }


    public void removeById(int id) {
        root = removeByIdHelp(root, id);
        nodecount = decrement(nodecount);
    }
    
    private BSTNode removeByIdHelp(BSTNode rt, int id) {
        if (isNull(rt))
            return null;
        if (id < rt.semValue().id()) {
            rt.setLeft(removeByIdHelp(rt.left(), id));
        }
        else if (id > rt.semValue().id()) {
            rt.setRight(removeByIdHelp(rt.right(), id));
        }
        else {
            // Node found, remove it
            if (isNull(rt.left()))
                return rt.right();
            else if (isNull(rt.right()))
                return rt.left();
            else {
                rt.setValue(findMax(rt.left()));
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    public void removeByDate(Seminar date) {
        root = removeByDateHelp(root, date);
        nodecount = decrement(nodecount);
    }
    
    private BSTNode removeByDateHelp(BSTNode rt, Seminar date) {
        if (isNull(rt))
            return null;
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
                if (isNull(rt.left()))
                    return rt.right();
                else if (isNull(rt.right()))
                    return rt.left();
                else {
                    rt.setValue(findMax(rt.left()));
                    rt.setLeft(deleteMax(rt.left()));
                }
            }
        }
        return rt;
    }


    private BSTNode removeByCostHelp(BSTNode rt, Seminar cost) {
        if (isNull(rt))
            return null;
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
                if (isNull(rt.left()))
                    return rt.right();
                else if (isNull(rt.right()))
                    return rt.left();
                else {
                    rt.setValue(findMax(rt.left()));
                    rt.setLeft(deleteMax(rt.left()));
                }
            }
        }
        return rt;
    }


    public void removeByCost(Seminar cost) {
        root = removeByCostHelp(root, cost);
        nodecount = decrement(nodecount);
    }


    private BSTNode removeByKeywordHelp(BSTNode rt, String keyword, Seminar sem) {
        if (rt == null)
            return null;
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
            if (isNull(rt.left()))
                return rt.right();
            else if (isNull(rt.right()))
                return rt.left();
            else {
                rt.setStringValue(findStringMax(rt.left()));
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }


    public void removeByKeyword(String keyword, Seminar sem) {
        root = removeByKeywordHelp(root, keyword, sem);
        nodecount = decrement(nodecount);
    }
    
    // ----------------------------------------------------------
    /**
     * Clears the trees
     */
    public void clear() {
        root = null;
        nodecount = 0;
    }
    
    // ----------------------------------------------------------
    /**
     * Getter for the root node
     * @return the root node
     */
    public BSTNode getRoot() {
        return root;
    }
    
    public int getTraversalCount() {
        return traversalCount;
    }
    
    public void resetTraversalCount() {
        traversalCount = 0;
    }
    
    // ----------------------------------------------------------
    // Mutation Testing Functions
    // ----------------------------------------------------------
    
    /**
     * Checks if the current object is null
     * @param s 
     *          object to check
     * @return if null or not
     */    
    public boolean isNull(Object s) {
        return s == null;
    }

    // ----------------------------------------------------------
    /**
     * Decreases an integer by one
     * @param i
     *          the integer to be decremented
     * @return decremented i 
     */
    public int decrement(int i) {
        return i-1;
    }
}
