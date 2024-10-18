// -------------------------------------------------------------------------
/**
 * Represents an empty node in a binary tree structure. This class follows the
 * Singleton pattern, ensuring that only one instance of EmptyNode exists.
 * 
 * This class is used as a placeholder for empty nodes in the binary tree, and
 * it defines behaviors specific to empty nodes, such as having no children,
 * returning null for Seminar objects, and doing nothing on certain method
 * calls.
 * 
 * The EmptyNode class implements the BinNode interface and overrides its
 * methods with behaviors appropriate for an empty node.
 * 
 * @see BinNode
 * @see BinTree
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class EmptyNode implements BinNode {
    private static EmptyNode instance = null;

    // ----------------------------------------------------------
    /**
     * Private constructor to prevent direct instantiation.
     * Use {@link #getInstance()} to obtain the singleton instance of this
     * class.
     */
    private EmptyNode() {
    }


    // ----------------------------------------------------------
    /**
     * Returns the singleton instance of EmptyNode.
     * Ensures that only one instance of EmptyNode exists across the
     * application.
     *
     * @return the singleton EmptyNode instance
     */
    public static EmptyNode getInstance() {
        if (instance == null) {
            instance = new EmptyNode();
        }
        return instance;
    }


    // ----------------------------------------------------------
    /**
     * Indicates whether the node is a leaf node.
     * For EmptyNode, this method always returns false.
     *
     * @return false, as EmptyNode is not a leaf
     */
    @Override
    public boolean isLeaf() {
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Returns the Seminar object stored in the node.
     * For EmptyNode, this method always returns null.
     *
     * @return null, as EmptyNode does not store a Seminar
     */
    @Override
    public Seminar getSeminar() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Returns the left child of the node.
     * For EmptyNode, this method always returns null.
     *
     * @return null, as EmptyNode does not have a left child
     */
    @Override
    public BinNode getLeft() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Returns the right child of the node.
     * For EmptyNode, this method always returns null.
     *
     * @return null, as EmptyNode does not have a right child
     */
    @Override
    public BinNode getRight() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Sets the left child of the node.
     * For EmptyNode, this method does nothing as it cannot have children.
     *
     * @param left
     *            the left child node (ignored)
     */
    @Override
    public void setLeft(BinNode left) {
        // Do nothing, empty nodes don't have children
    }


    // ----------------------------------------------------------
    /**
     * Sets the right child of the node.
     * For EmptyNode, this method does nothing as it cannot have children.
     *
     * @param right
     *            the right child node (ignored)
     */
    @Override
    public void setRight(BinNode right) {
        // Do nothing, empty nodes don't have children
    }


    // ----------------------------------------------------------
    /**
     * Indicates whether the node splits on the x-axis.
     * For EmptyNode, this method always returns false.
     *
     * @return false, as EmptyNode does not split on the x-axis
     */
    @Override
    public boolean isSplitOnX() {
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Prints the representation of an empty node. The node is represented as
     * "(E)".
     *
     * @param depth
     *            the depth of the node in the tree (for indentation purposes)
     */
    @Override
    public void print(int depth) {
        printIndent(depth);
        System.out.println("(E)");
    }


    // ----------------------------------------------------------
    /**
     * Prints the representation of the given node at the specified depth.
     *
     * @param node
     *            the node to be printed
     * @param depth
     *            the depth of the node in the tree
     */
    @Override
    public void print(BinNode node, int depth) {
        print(depth);
    }


    // ----------------------------------------------------------
    /**
     * Decrements the depth value.
     * In the context of EmptyNode, this method is used for tree traversal
     * purposes.
     *
     * @param depth
     *            the current depth of the node
     * @return the decremented depth
     */
    @Override
    public int incrementDepth(int depth) {
        return depth - 1;
    }


    // ----------------------------------------------------------
    /**
     * Deletes a node from the tree based on its ID and coordinates.
     * For EmptyNode, this method always returns the EmptyNode instance itself,
     * as there is nothing to delete.
     *
     * @param id
     *            the ID of the node to delete
     * @param targetX
     *            the x-coordinate of the node
     * @param targetY
     *            the y-coordinate of the node
     * @param xMin
     *            the minimum x-bound of the current region
     * @param yMin
     *            the minimum y-bound of the current region
     * @param xMax
     *            the maximum x-bound of the current region
     * @param yMax
     *            the maximum y-bound of the current region
     * @param depth
     *            the current depth in the tree
     * @return the EmptyNode instance, as nothing was deleted
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
        return instance; // Nothing to delete in an empty node
    }


    // ----------------------------------------------------------
    /**
     * Helper method to print indentation based on the depth of the node.
     *
     * @param depth
     *            the depth of the node for indentation purposes
     */
    private void printIndent(int depth) {
        for (int i = 0; i < depth - 1; i++) {
            System.out.print("    ");
        }
    }
}
