public class BinTree {
    private BinNode root;

    public BinTree() {
        this.root = EmptyNode.getInstance();
    }

    public void insert(Seminar seminar) {
        root = root.insert(seminar);
    }

    public boolean searchWithinRadius(double x, double y, double radius) {
        return searchWithinRadius(root, x, y, radius);
    }

    private boolean searchWithinRadius(BinNode node, double x, double y, double radius) {
        if (node instanceof EmptyNode) {
            return false;
        }

        if (node.intersects(x, y, radius)) {
            if (node instanceof LeafNode) {
                LeafNode leaf = (LeafNode) node;
                Seminar seminar = leaf.getSeminar();
                System.out.println("Found a record with key value " + seminar.getId() + 
                                   " at " + seminar.getX() + ", " + seminar.getY());
                return true;
            } else if (node instanceof InternalNode) {
                InternalNode internal = (InternalNode) node;
                boolean leftFound = searchWithinRadius(internal.getLeft(), x, y, radius);
                boolean rightFound = searchWithinRadius(internal.getRight(), x, y, radius);
                return leftFound || rightFound;
            }
        }

        return false;
    }

    public Seminar search(int id) {
        return searchHelper(root, id);
    }

    private Seminar searchHelper(BinNode node, int id) {
        if (node instanceof EmptyNode) {
            return null;
        }
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            Seminar seminar = leaf.getSeminar();
            if (id == seminar.getId()) {
                return seminar;
            }
            return null;
        }
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode) node;
            if (id <= internal.getLeftmostId()) {
                return searchHelper(internal.getLeft(), id);
            } else {
                return searchHelper(internal.getRight(), id);
            }
        }
        return null;
    }

    public void delete(double x, double y) {
        root = root.delete(x, y);
    }
}