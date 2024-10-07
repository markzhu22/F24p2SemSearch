public class BinTree {
    private BinNode root;

    public BinTree() {
        this.root = EmptyNode.getInstance(); // Initialize with an empty node
    }


    /**
     * Inserts a new seminar into the BinTree at the specified (x, y)
     * coordinates.
     * 
     * @param seminar
     *            The seminar to insert.
     * @param x
     *            The x-coordinate of the seminar.
     * @param y
     *            The y-coordinate of the seminar.
     */
    public void insert(Seminar seminar, double x, double y) {
        root = insert(root, seminar, x, y, true); // Start at root with an x
                                                  // split
    }


    private BinNode insert(
        BinNode node,
        Seminar seminar,
        double x,
        double y,
        boolean splitOnX) {
        if (node instanceof EmptyNode) {
            return new LeafNode(seminar); // Insert the seminar as a leaf node
        }

        if (node.isLeaf()) {
            // If the node is a leaf, we need to split and create an internal
            // node
            LeafNode leaf = (LeafNode)node;
            double leafX = leaf.getSeminar().getX();
            double leafY = leaf.getSeminar().getY();

            InternalNode internalNode;
            if (splitOnX) {
                if (x < leafX) {
                    internalNode = new InternalNode(new LeafNode(seminar), leaf,
                        splitOnX);
                }
                else {
                    internalNode = new InternalNode(leaf, new LeafNode(seminar),
                        splitOnX);
                }
            }
            else {
                if (y < leafY) {
                    internalNode = new InternalNode(new LeafNode(seminar), leaf,
                        splitOnX);
                }
                else {
                    internalNode = new InternalNode(leaf, new LeafNode(seminar),
                        splitOnX);
                }
            }
            return internalNode;
        }
        else {
            // If the node is an internal node, keep traversing
            InternalNode internal = (InternalNode)node;
            if (splitOnX) {
                if (x < internal.getLeft().getSeminar().getX()) {
                    internal.setLeft(insert(internal.getLeft(), seminar, x, y,
                        !splitOnX));
                }
                else {
                    internal.setRight(insert(internal.getRight(), seminar, x, y,
                        !splitOnX));
                }
            }
            else {
                if (y < internal.getLeft().getSeminar().getY()) {
                    internal.setLeft(insert(internal.getLeft(), seminar, x, y,
                        !splitOnX));
                }
                else {
                    internal.setRight(insert(internal.getRight(), seminar, x, y,
                        !splitOnX));
                }
            }
            return internal;
        }
    }


    /**
     * Searches for all seminars within the given radius from the point (x, y).
     * 
     * @param x
     *            The x-coordinate of the center of the search.
     * @param y
     *            The y-coordinate of the center of the search.
     * @param radius
     *            The radius within which to search.
     * @return True if any seminars are found, false otherwise.
     */
    public boolean searchWithinRadius(double x, double y, double radius) {
        return searchWithinRadius(root, x, y, radius);
    }


    private boolean searchWithinRadius(
        BinNode node,
        double x,
        double y,
        double radius) {
        if (node == null || node instanceof EmptyNode) {
            return false;
        }

        // Check if this is a leaf node
        if (node.isLeaf()) {
            LeafNode leaf = (LeafNode)node;
            Seminar seminar = leaf.getSeminar();

            // Calculate the distance from the point (x, y) to the seminar's
            // coordinates
            double dist = Math.sqrt(Math.pow(seminar.getX() - x, 2) + Math.pow(
                seminar.getY() - y, 2));

            if (dist <= radius) {
                System.out.println("Found a record with key value " + seminar
                    .getId() + " at " + seminar.getX() + ", " + seminar.getY());
                return true;
            }

            return false;
        }

        // Recursively search the left and right subtrees
        InternalNode internal = (InternalNode)node;
        boolean leftFound = searchWithinRadius(internal.getLeft(), x, y,
            radius);
        boolean rightFound = searchWithinRadius(internal.getRight(), x, y,
            radius);

        return leftFound || rightFound;
    }
}
