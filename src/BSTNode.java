public class BSTNode
{
    private Seminar element; // Element for this node
    private BSTNode left;          // Pointer to left child
    private BSTNode right;         // Pointer to right child

    // Constructors
    public BSTNode()
    {
        left = right = null;
    }


    public BSTNode(Seminar val)
    {
        left = right = null;
        element = val;
    }


    public BSTNode(Seminar val, BSTNode l, BSTNode r)
    {
        left = l;
        right = r;
        element = val;
    }


    // Get and set the element value
    public Seminar value()
    {
        return element;
    }


    public void setValue(Seminar v)
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
