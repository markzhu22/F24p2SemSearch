public class BinarySearchTree {
    private BSTNode root; // Root of the BST
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
        if (rt == null)
            return null;
        if (rt.value().id() > id) {
            return findByIdHelp(rt.left(), id);
        }
        else if (rt.value().id() == id) {
            return rt.value();
        }
        else {
            return findByIdHelp(rt.right(), id);
        }
    }


    public Seminar findById(int id) {
        return findByIdHelp(root, id);
    }


    private Seminar findByDateHelp(BSTNode rt, String date) {
        if (rt == null)
            return null;
        if (rt.value().date().compareTo(date) > 0) {
            return findByDateHelp(rt.left(), date);
        }
        else if (rt.value().date().equals(date)) {
            return rt.value();
        }
        else {
            return findByDateHelp(rt.right(), date);
        }
    }


    public Seminar findByDate(String date) {
        return findByDateHelp(root, date);
    }


    private Seminar findByCostHelp(BSTNode rt, int cost) {
        if (rt == null)
            return null;
        if (rt.value().cost() > cost) {
            return findByCostHelp(rt.left(), cost);
        }
        else if (rt.value().cost() == cost) {
            return rt.value();
        }
        else {
            return findByCostHelp(rt.right(), cost);
        }
    }


    public Seminar findByCost(int cost) {
        return findByCostHelp(root, cost);
    }


    private Seminar findByKeywordHelp(BSTNode rt, String keyword) {
        if (rt == null)
            return null;
        for (String k : rt.value().keywords()) {
            if (k.equals(keyword)) {
                return rt.value();
            }
        }

        Seminar leftResult = findByKeywordHelp(rt.left(), keyword);
        if (leftResult != null)
            return leftResult;
        return findByKeywordHelp(rt.right(), keyword);
    }


    public Seminar findByKeyword(String keyword) {
        return findByKeywordHelp(root, keyword);
    }


    private BSTNode insertByIdHelp(BSTNode rt, Seminar seminar) {
        if (rt == null) {
            return new BSTNode(seminar);
        }

        if (seminar.id() == rt.value().id()) {
            System.out.println("Duplicate seminar ID: " + seminar.id()
                + " - insertion ignored.");
            return rt;
        }
        else if (seminar.id() < rt.value().id()) {
            rt.setLeft(insertByIdHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByIdHelp(rt.right(), seminar));
        }
        return rt;
    }


    public void insertById(Seminar seminar) {
        root = insertByIdHelp(root, seminar);
        if (root != null) {
            nodecount++;
        }
    }


    private BSTNode insertByDateHelp(BSTNode rt, Seminar seminar) {
        if (rt == null)
            return new BSTNode(seminar);

        if (seminar.date().equals(rt.value().date())) {
            System.out.println("Duplicate seminar date: " + seminar.date()
                + " - insertion ignored.");
            return rt;
        }
        else if (seminar.date().compareTo(rt.value().date()) <= 0) {
            rt.setLeft(insertByDateHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByDateHelp(rt.right(), seminar));
        }
        return rt;
    }


    public void insertByDate(Seminar seminar) {
        root = insertByDateHelp(root, seminar);
        if (root != null) {
            nodecount++;
        }
    }


    private BSTNode insertByCostHelp(BSTNode rt, Seminar seminar) {
        if (rt == null)
            return new BSTNode(seminar);
        if (seminar.cost() == rt.value().cost()) {
            System.out.println("Duplicate seminar cost: " + seminar.cost()
                + " - insertion ignored.");
            return rt;
        }
        else if (seminar.cost() <= rt.value().cost()) {
            rt.setLeft(insertByCostHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByCostHelp(rt.right(), seminar));
        }
        return rt;
    }


    public void insertByCost(Seminar seminar) {
        root = insertByCostHelp(root, seminar);
        if (root != null) {
            nodecount++;
        }
    }


    private BSTNode insertByKeywordHelp(BSTNode rt, Seminar seminar) {
        if (rt == null)
            return new BSTNode(seminar);
        if (seminar.keywords()[0].equals(rt.value().keywords()[0])) {
            System.out.println("Duplicate seminar keyword: " + seminar
                .keywords()[0] + " - insertion ignored.");
            return rt;
        }
        else if (seminar.keywords()[0].compareTo(rt.value()
            .keywords()[0]) <= 0) {
            rt.setLeft(insertByKeywordHelp(rt.left(), seminar));
        }
        else {
            rt.setRight(insertByKeywordHelp(rt.right(), seminar));
        }
        return rt;
    }


    public void insertByKeyword(Seminar seminar) {
        root = insertByKeywordHelp(root, seminar);
        if (root != null) {
            nodecount++;
        }
    }


    private Seminar findMax(BSTNode rt) {
        if (rt == null) {
            return null;
        }

        while (rt.right() != null) {
            rt = rt.right();
        }

        return rt.value();
    }


    private BSTNode deleteMax(BSTNode rt) {
        if (rt.right() == null)
            return rt.left();
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }


    private BSTNode removeByIdHelp(BSTNode rt, int id) {
        if (rt == null)
            return null;
        if (id < rt.value().id()) {
            rt.setLeft(removeByIdHelp(rt.left(), id));
        }
        else if (id > rt.value().id()) {
            rt.setRight(removeByIdHelp(rt.right(), id));
        }
        else {
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
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
        nodecount--;
    }


    private BSTNode removeByDateHelp(BSTNode rt, String date) {
        if (rt == null)
            return null;
        if (date.compareTo(rt.value().date()) < 0) {
            rt.setLeft(removeByDateHelp(rt.left(), date));
        }
        else if (date.compareTo(rt.value().date()) > 0) {
            rt.setRight(removeByDateHelp(rt.right(), date));
        }
        else { // Node found
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
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
        nodecount--;
    }


    private BSTNode removeByCostHelp(BSTNode rt, int cost) {
        if (rt == null)
            return null;
        if (cost < rt.value().cost()) {
            rt.setLeft(removeByCostHelp(rt.left(), cost));
        }
        else if (cost > rt.value().cost()) {
            rt.setRight(removeByCostHelp(rt.right(), cost));
        }
        else {
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
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
        nodecount--;
    }


    private BSTNode removeByKeywordHelp(BSTNode rt, String keyword) {
        if (rt == null)
            return null;
        if (rt.value().keywords()[0].compareTo(keyword) > 0) {
            rt.setLeft(removeByKeywordHelp(rt.left(), keyword));
        }
        else if (rt.value().keywords()[0].equals(keyword)) {
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
                return rt.left();
            else {
                rt.setValue(findMax(rt.left()));
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
        nodecount--;
    }

}
