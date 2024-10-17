/**
 * Interface for nodes in a binary tree structure.
 * 
 * @author markz + tarinid
 * @version Oct 14, 2024
 */
public interface BinNode {

    /**
     * Checks if this node is a leaf node.
     *
     * @return true if this is a leaf node, false otherwise
     */
    boolean isLeaf();

    /**
     * Gets the seminar associated with this node.
     *
     * @return the Seminar object, or null if not applicable
     */
    Seminar getSeminar();

    /**
     * Gets the left child of this node.
     *
     * @return the left child BinNode
     */
    BinNode getLeft();

    /**
     * Gets the right child of this node.
     *
     * @return the right child BinNode
     */
    BinNode getRight();

    /**
     * Sets the left child of this node.
     *
     * @param left the left child BinNode to set
     */
    void setLeft(BinNode left);

    /**
     * Sets the right child of this node.
     *
     * @param right the right child BinNode to set
     */
    void setRight(BinNode right);

    /**
     * Checks if this node is split on the X-axis.
     *
     * @return true if split on X-axis, false if split on Y-axis
     */
    boolean isSplitOnX();

    void print(int depth);
    void print(BinNode node, int depth);
    int incrementDepth(int depth);

    BinNode delete(int id, int targetX, int targetY, int xMin, int yMin, int xMax, int yMax, int depth);
}
