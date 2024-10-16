/**
 * Represents an empty node in a binary tree structure.
 * This class implements the Singleton pattern.
 * 
 * @author markz + tarinid
 * @version Oct 14, 2024
 */
public class EmptyNode implements BinNode {
    private static EmptyNode instance = null;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private EmptyNode() {
    }

    /**
     * Returns the singleton instance of EmptyNode.
     *
     * @return the EmptyNode instance
     */
    public static EmptyNode getInstance() {
        if (instance == null) {
            instance = new EmptyNode();
        }
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf() {
        return false;
    }

    /**
     * {@inheritDoc}
     * Always returns null for an empty node.
     */
    @Override
    public Seminar getSeminar() {
        return null;
    }

    /**
     * {@inheritDoc}
     * Always returns null for an empty node.
     */
    @Override
    public BinNode getLeft() {
        return null;
    }

    /**
     * {@inheritDoc}
     * Always returns null for an empty node.
     */
    @Override
    public BinNode getRight() {
        return null;
    }

    /**
     * {@inheritDoc}
     * Does nothing for an empty node.
     */
    @Override
    public void setLeft(BinNode left) {
        // Do nothing, empty nodes don't have children
    }

    /**
     * {@inheritDoc}
     * Does nothing for an empty node.
     */
    @Override
    public void setRight(BinNode right) {
        // Do nothing, empty nodes don't have children
    }

    /**
     * {@inheritDoc}
     * Always returns false for an empty node.
     */
    @Override
    public boolean isSplitOnX() {
        return false;
    }

    @Override
    public void print(BinNode node, int depth) {
        String space = "";

        for (int i = 0; i < depth; i++) {
            space += "    ";
        }
        System.out.print(space);
        System.out.println("(E)");
    }
}