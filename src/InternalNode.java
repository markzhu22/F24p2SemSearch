// -------------------------------------------------------------------------
/**
 * Represents an internal node in a binary tree structure. Internal nodes are
 * used to divide the 2D space based on the x or y coordinates. This class is
 * responsible for managing the left and right children of the node, as well
 * as determining whether the node splits based on the x or y axis.
 * 
 * The InternalNode class implements the BinNode interface and provides methods
 * for accessing and modifying its children, determining its split axis,
 * printing its structure, and performing deletions in the binary tree.
 * 
 * @see BinNode
 * @see BinTree
 * 
 * @see LeafNode
 * @see EmptyNode
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class InternalNode implements BinNode {
    private BinNode left; // Left child of the internal node
    private BinNode right; // Right child of the internal node
    private boolean splitOnX; // Determines whether the node splits on the
                              // x-axis or y-axis
    private int splitValue; // The value on which the node splits (either x or
                            // y)

    // ----------------------------------------------------------
    /**
     * Constructs a new InternalNode with specified left and right children,
     * the axis on which the node splits, and the value to split on.
     * 
     * @param left
     *            the left child node
     * @param right
     *            the right child node
     * @param splitOnX
     *            true if the node splits on the x-axis, false if it splits on
     *            the y-axis
     * @param splitValue
     *            the value at which the node splits (x or y)
     */
    public InternalNode(
        BinNode left,
        BinNode right,
        boolean splitOnX,
        int splitValue) {
        this.left = left;
        this.right = right;
        this.splitOnX = splitOnX;
        this.splitValue = splitValue;
    }


    // ----------------------------------------------------------
    /**
     * Indicates whether the node is a leaf node.
     * For InternalNode, this method always returns false.
     *
     * @return false, as InternalNode is not a leaf
     */
    @Override
    public boolean isLeaf() {
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Returns the Seminar object stored in the node.
     * For InternalNode, this method always returns null.
     *
     * @return null, as InternalNode does not store a Seminar
     */
    @Override
    public Seminar getSeminar() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Returns the left child of the internal node.
     *
     * @return the left child node
     */
    @Override
    public BinNode getLeft() {
        return left;
    }


    // ----------------------------------------------------------
    /**
     * Sets the left child of the internal node.
     *
     * @param left
     *            the left child node to set
     */
    @Override
    public void setLeft(BinNode left) {
        this.left = left;
    }


    // ----------------------------------------------------------
    /**
     * Returns the right child of the internal node.
     *
     * @return the right child node
     */
    @Override
    public BinNode getRight() {
        return right;
    }


    // ----------------------------------------------------------
    /**
     * Sets the right child of the internal node.
     *
     * @param right
     *            the right child node to set
     */
    @Override
    public void setRight(BinNode right) {
        this.right = right;
    }


    // ----------------------------------------------------------
    /**
     * Indicates whether the node splits on the x-axis or y-axis.
     * 
     * @return true if the node splits on the x-axis, false if it splits on the
     *         y-axis
     */
    @Override
    public boolean isSplitOnX() {
        return splitOnX;
    }


    // ----------------------------------------------------------
    /**
     * Returns the value at which the node splits (either x or y).
     * 
     * @return the split value of the node
     */
    public int getSplitValue() {
        return splitValue;
    }


    // ----------------------------------------------------------
    /**
     * Sets the value at which the node splits.
     * 
     * @param splitValue
     *            the value at which to split the node (either x or y)
     */
    public void setSplitValue(int splitValue) {
        this.splitValue = splitValue;
    }


    // ----------------------------------------------------------
    /**
     * Prints the structure of the internal node, displaying its position in the
     * tree. Internal nodes are represented by "(I)" and their children are
     * recursively printed.
     *
     * @param depth
     *            the depth of the node in the tree (for indentation purposes)
     */
    @Override
    public void print(int depth) {
        printIndent(depth);
        System.out.println("(I)");
        right.print(incrementDepth(depth));
        left.print(incrementDepth(depth));
    }


    // ----------------------------------------------------------
    /**
     * Prints the structure of a given node at the specified depth.
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
     * This method is used for tree traversal and indentation purposes.
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
     * Helper method to print indentation based on the depth of the node.
     *
     * @param depth
     *            the depth of the node for indentation purposes
     */
    private void printIndent(int depth) {
        for (int i = 0; i < incrementDepth(depth); i++) {
            System.out.print("    ");
        }
    }


    // ----------------------------------------------------------
    /**
     * Deletes a seminar from the tree based on its coordinates and ID.
     * 
     * The method determines whether to traverse left or right based on the
     * splitting axis, and adjusts the region boundaries accordingly.
     * 
     * @param id
     *            the ID of the seminar to delete
     * @param targetX
     *            the x-coordinate of the seminar
     * @param targetY
     *            the y-coordinate of the seminar
     * @param xMin
     *            the minimum x-bound of the current region
     * @param yMin
     *            the minimum y-bound of the current region
     * @param xMax
     *            the maximum x-bound of the current region
     * @param yMax
     *            the maximum y-bound of the current region
     * @param depth
     *            the current depth in the tree (used to alternate x/y splits)
     * @return the updated node after deletion
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
        int midPoint;
        if (depth % 2 == 0) { // Splitting based on X
            midPoint = (xMin + xMax) / 2;
            if (targetX <= midPoint) {
                left = left.delete(id, targetX, targetY, xMin, yMin, midPoint,
                    yMax, plus(depth, 1));
            }
            else {
                right = right.delete(id, targetX, targetY, midPoint + 1, yMin,
                    xMax, yMax, plus(depth, 1));
            }
        }
        else { // Splitting based on Y
            midPoint = (yMin + yMax) / 2;
            if (targetY <= midPoint) {
                left = left.delete(id, targetX, targetY, xMin, yMin, xMax,
                    midPoint, depth + 1);
            }
            else {
                right = right.delete(id, targetX, targetY, xMin, midPoint + 1,
                    xMax, yMax, plus(depth, 1));
            }
        }

        // If both children are empty, return the non-empty child
        if (left instanceof LeafNode && right instanceof EmptyNode) {
            return left;
        }
        else if (left instanceof EmptyNode && right instanceof LeafNode) {
            return right;
        }

        // Otherwise, return this node
        return this;
    }


    // ----------------------------------------------------------
    /**
     * Adds two integers.
     * 
     * @param i
     *            the first integer
     * @param j
     *            the second integer
     * @return the sum of i and j
     */
    private int plus(int i, int j) {
        return i + j;
    }
}
