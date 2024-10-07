// -------------------------------------------------------------------------
/**
 * Binary search tree nodes object for the binary search tree object
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class BSTNode
{
    private Object element; // Element for this node
    private BSTNode left;          // Pointer to left child
    private BSTNode right;         // Pointer to right child
    private Seminar seminar;

    // ----------------------------------------------------------
    /**
     * Create a new BSTNode object.
     */
    public BSTNode()
    {
        left = right = null;
    }


    // ----------------------------------------------------------
    /**
     * Create a new BSTNode object.
     * 
     * @param val
     *            Object to store at this node
     * @param sem
     *            The seminar object the object is coming from
     */
    public BSTNode(Object val, Seminar sem)
    {
        left = right = null;
        element = val;
        seminar = sem;
    }


    // ----------------------------------------------------------
    /**
     * Create a new BSTNode object.
     * 
     * @param val
     *            Object to store at this node
     * @param l
     *            The left node
     * @param r
     *            The Right Node
     * @param sem
     *            The seminar object the object is coming from
     */
    public BSTNode(Object val, BSTNode l, BSTNode r, Seminar sem)
    {
        left = l;
        right = r;
        element = val;
    }


    // ----------------------------------------------------------
    /**
     * Getter for seminar
     * 
     * @return the seminar
     */
    public Seminar semValue()
    {
        return seminar;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the seminar
     * 
     * @param v
     */
    public void setValue(Seminar v)
    {
        seminar = v;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the string for keywords
     * 
     * @return the string for keywords
     */
    public String stringValue()
    {
        return (String)element;
    }


    // ----------------------------------------------------------
    /**
     * Setter for string for keywords
     * 
     * @param v
     */
    public void setStringValue(String v)
    {
        element = v;
    }


    // ----------------------------------------------------------
    /**
     * Getter for left child
     * 
     * @return the child
     */
    public BSTNode left()
    {
        return left;
    }


    // ----------------------------------------------------------
    /**
     * Setter for left child
     * 
     * @param p
     *            Node to set
     */
    public void setLeft(BSTNode p)
    {
        left = p;
    }


    // ----------------------------------------------------------
    /**
     * Getter for right child
     * 
     * @return the child
     */
    public BSTNode right()
    {
        return right;
    }


    // ----------------------------------------------------------
    /**
     * Setter for right child
     * 
     * @param p
     *            Node to set
     */
    public void setRight(BSTNode p)
    {
        right = p;
    }


    // ----------------------------------------------------------
    /**
     * Checks if is leaf node
     * 
     * @return true or false
     */
    public boolean isLeaf()
    {
        return (left == null) && (right == null);
    }
}
