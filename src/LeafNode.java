/**
 * Represents a leaf node in a binary tree that holds Seminar objects.
 * 
 * A LeafNode can contain a list of seminars and provides methods to manage
 * these seminars, including adding, retrieving, and deleting them.
 * 
 * * @see BinNode
 * 
 * @see BinTree
 * 
 * @see InternalNode
 * @see EmptyNode
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class LeafNode implements BinNode {
    private LinkedList seminars;

    /**
     * Constructs a LeafNode with a single seminar.
     *
     * @param seminar
     *            the Seminar object to be added to this LeafNode
     */
    public LeafNode(Seminar seminar) {
        this.seminars = new LinkedList();
        this.seminars.add(seminar);
    }


    /**
     * Constructs a LeafNode with a list of seminars.
     *
     * @param seminars
     *            the LinkedList of Seminar objects to be added to this LeafNode
     */
    public LeafNode(LinkedList seminars) {
        this.seminars = seminars;
    }


    /**
     * Gets the list of seminars associated with this LeafNode.
     *
     * @return the LinkedList of seminars
     */
    public LinkedList getSeminars() {
        return seminars;
    }


    /**
     * Adds a seminar to this LeafNode if the maximum limit is not exceeded.
     *
     * @param seminar
     *            the Seminar object to be added
     */
    public void addSeminar(Seminar seminar) {
        if (seminars.size() < 3) {
            seminars.add(seminar);
        }
    }


    @Override
    public boolean isLeaf() {
        return true;
    }


    @Override
    public BinNode getLeft() {
        return null;
    }


    @Override
    public BinNode getRight() {
        return null;
    }


    @Override
    public void setLeft(BinNode left) {
        // Do nothing, leaf nodes don't have children
    }


    @Override
    public void setRight(BinNode right) {
        // Do nothing, leaf nodes don't have children
    }


    @Override
    public boolean isSplitOnX() {
        // Leaf nodes are not split
        return false;
    }


    /**
     * Gets the first seminar associated with this LeafNode.
     *
     * @return the Seminar object, or null if there are no seminars
     */
    public Seminar getSeminar() {
        return seminars.isEmpty() ? null : seminars.get(0);
    }


    @Override
    public void print(int depth) {
        printIndent(depth);
        System.out.print("(Leaf with " + seminars.size() + " objects:");
        for (int i = 0; i < seminars.size(); i++) {
            Seminar seminar = seminars.get(i);
            System.out.print(" " + seminar.getId());
        }
        System.out.println(")");
    }


    @Override
    public void print(BinNode node, int depth) {
        print(depth);
    }


    @Override
    public int incrementDepth(int depth) {
        return depth - 1;
    }


    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
    }


    /**
     * Deletes a seminar from this LeafNode based on the specified parameters.
     *
     * @param id
     *            the ID of the seminar to delete
     * @param targetX
     *            the X coordinate of the seminar
     * @param targetY
     *            the Y coordinate of the seminar
     * @param xMin
     *            the minimum X boundary for the search
     * @param yMin
     *            the minimum Y boundary for the search
     * @param xMax
     *            the maximum X boundary for the search
     * @param yMax
     *            the maximum Y boundary for the search
     * @param depth
     *            the current depth in the tree
     * @return the updated BinNode after deletion, or EmptyNode if no seminars
     *         remain
     */
    @Override
    public BinNode delete(
        int id,
        int targetX,
        int targetY,
        int xMin,
        int yMin,
        int xMax,
        int yMax,
        int depth) {
        LinkedList seminarList = this.getSeminars(); // Renamed local variable
        for (int i = 0; i < seminarList.size(); i++) {
            Seminar seminar = seminarList.get(i);
            if (seminar.id() == id && seminar.getX() == targetX && seminar
                .getY() == targetY) {
                seminarList.remove(i);
                if (seminarList.isEmpty()) {
                    return EmptyNode.getInstance();
                }
                break;
            }
        }
        return this;
    }
}
