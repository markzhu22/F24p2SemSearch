/**
 * Interface for nodes in a binary tree structure.
 * 
 * This interface defines the essential operations for binary tree nodes,
 * including methods for accessing child nodes, checking node types, and
 * managing seminars associated with the nodes.
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
     * @param left
     *            the left child BinNode to set
     */
    void setLeft(BinNode left);


    /**
     * Sets the right child of this node.
     *
     * @param right
     *            the right child BinNode to set
     */
    void setRight(BinNode right);


    /**
     * Checks if this node is split on the X-axis.
     *
     * @return true if split on X-axis, false if split on Y-axis
     */
    boolean isSplitOnX();


    /**
     * Prints the node and its children at a specified depth.
     *
     * @param depth
     *            the current depth in the tree for indentation
     */
    void print(int depth);


    /**
     * Prints the specified node and its children at a specified depth.
     *
     * @param node
     *            the BinNode to print
     * @param depth
     *            the current depth in the tree for indentation
     */
    void print(BinNode node, int depth);


    /**
     * Increments the depth for printing or traversal purposes.
     *
     * @param depth
     *            the current depth to increment
     * @return the incremented depth
     */
    int incrementDepth(int depth);


    /**
     * Deletes a seminar from the node based on the specified parameters.
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
     * @return the updated BinNode after deletion
     */
    BinNode delete(
        int id,
        int targetX,
        int targetY,
        int xMin,
        int yMin,
        int xMax,
        int yMax,
        int depth);
}
