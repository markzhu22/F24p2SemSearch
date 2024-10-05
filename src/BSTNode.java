public class BSTNode
{
    private Object element; // Element for this node
    private BSTNode left;          // Pointer to left child
    private BSTNode right;         // Pointer to right child
    private Seminar seminar;

    // Constructors
    public BSTNode()
    {
        left = right = null;
    }


    public BSTNode(Object val, Seminar sem)
    {
        left = right = null;
        element = val;
        seminar = sem;
    }


    public BSTNode(Object val, BSTNode l, BSTNode r, Seminar sem)
    {
        left = l;
        right = r;
        element = val;
    }


    // Get and set the element value
    public Seminar semValue()
    {
        return seminar;
    }
    
    public String stringValue()
    {
        return (String)element;
    }


    public void setValue(Seminar v)
    {
        element = v;
    }
    
    public void setStringValue(String v)
    {
        element = v;
    }


    // Get and set the left child
    public BSTNode left()
    {
        return left;
    }


    public void setLeft(BSTNode p)
    {
        left = p;
    }


    // Get and set the right child
    public BSTNode right()
    {
        return right;
    }


    public void setRight(BSTNode p)
    {
        right = p;
    }


    // return TRUE if a leaf node, FALSE otherwise
    public boolean isLeaf()
    {
        return (left == null) && (right == null);
    }
}
