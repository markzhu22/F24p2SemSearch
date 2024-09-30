public class BinarySearchTree {
    public BSTNode root; // Root of the BST
    private int nodecount; // Number of nodes in the BST

    // ----------------------------------------------------------
    /**
     * Create a new BinarySearchTree object.
     */
    // constructor
    public BinarySearchTree() {
        root = null;
        nodecount = 0;
    }


    // Getter for the root node
    public BSTNode getRoot() {
        return root;
    }


    // Reinitialize tree
    public void clear() {
        root = null;
        nodecount = 0;
    }


    // Return the number of records in the dictionary
    public int size() {
        return nodecount;
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


    public Seminar findById(int id) {
        return findByIdHelp(root, id);
    }


    private boolean findByDateRangeHelper(BSTNode rt, String low, String high) {
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

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

        return found;
    }


    public boolean findByDateRange(String low, String high) {
        return findByDateRangeHelper(root, low, high);
    }


    private boolean findByCostRangeHelper(BSTNode rt, int low, int high) {
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

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

        return found;
    }


    public boolean findByCostRange(int low, int high) {
        return findByCostRangeHelper(root, low, high);
    }


    private boolean findByKeywordHelper(BSTNode rt, String keyword) {
        if (isNull(rt)) {
            return false;
        }

        boolean found = false;

        if (rt.stringValue().equals(keyword)) {
            System.out.println(rt.stringValue());
            found = true;
        }

        boolean foundInLeft = findByKeywordHelper(rt.left(), keyword);
        boolean foundInRight = findByKeywordHelper(rt.right(), keyword);

        return found || foundInLeft || foundInRight;
    }


    public boolean findByKeyword(String keyword) {
        return findByKeywordHelper(root, keyword);
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
            return new BSTNode(seminar);
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
            return new BSTNode(seminar);
        }

        if (seminar.date().compareTo(rt.semValue().date()) < 0) {
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
            return new BSTNode(seminar);
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


    private BSTNode insertByKeywordHelp(BSTNode rt, String keywords) {
        if (isNull(rt)) {
            nodecount++;
            return new BSTNode(keywords);
        }
        if (keywords.compareTo(rt.stringValue()) <= 0) {
            rt.setLeft(insertByKeywordHelp(rt.left(), keywords));
        }
        else {
            rt.setRight(insertByKeywordHelp(rt.right(), keywords));
        }
        return rt;
    }


    public void insertByKeyword(Seminar seminar) {
        for (String keyword : seminar.keywords()) {
            root = insertByKeywordHelp(root, keyword);
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


    public void removeById(int id) {
        root = removeByIdHelp(root, id);
        nodecount = decrement(nodecount);
    }


    private BSTNode removeByDateHelp(BSTNode rt, String date) {
        if (isNull(rt))
            return null;
        if (date.compareTo(rt.semValue().date()) < 0) {
            rt.setLeft(removeByDateHelp(rt.left(), date));
        }
        else if (date.compareTo(rt.semValue().date()) > 0) {
            rt.setRight(removeByDateHelp(rt.right(), date));
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
        return rt;
    }


    public void removeByDate(String date) {
        root = removeByDateHelp(root, date);
        nodecount = decrement(nodecount);
    }


    private BSTNode removeByCostHelp(BSTNode rt, int cost) {
        if (isNull(rt))
            return null;
        if (cost < rt.semValue().cost()) {
            rt.setLeft(removeByCostHelp(rt.left(), cost));
        }
        else if (cost > rt.semValue().cost()) {
            rt.setRight(removeByCostHelp(rt.right(), cost));
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
        return rt;
    }


    public void removeByCost(int cost) {
        root = removeByCostHelp(root, cost);
        nodecount = decrement(nodecount);
    }


    private BSTNode removeByKeywordHelp(BSTNode rt, String keyword) {
        if (rt == null)
            return null;
        if (rt.stringValue().compareTo(keyword) > 0) {
            rt.setLeft(removeByKeywordHelp(rt.left(), keyword));
        }
        else if (rt.stringValue().equals(keyword)) {
            if (isNull(rt.left()))
                return rt.right();
            else if (isNull(rt.right()))
                return rt.left();
            else {
                rt.setStringValue(findStringMax(rt.left()));
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        else {
            rt.setRight(removeByKeywordHelp(rt.right(), keyword));
        }
        return rt;
    }


    public void removeByKeyword(String keyword) {
        root = removeByKeywordHelp(root, keyword);
        nodecount = decrement(nodecount);
    }
    
    public boolean isNull(Object s) {
        return s == null;
    }

    public int decrement(int i) {
        return i--;
    }
}
