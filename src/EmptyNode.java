public class EmptyNode implements BinNode {
    private static EmptyNode instance = null;

    private EmptyNode() {
    }


    public static EmptyNode getInstance() {
        if (instance == null) {
            instance = new EmptyNode();
        }
        return instance;
    }


    @Override
    public boolean isLeaf() {
        return false;
    }


    @Override
    public void traverse() {
        // Do nothing, it’s an empty node
    }


    @Override
    public boolean intersects(double x, double y, double radius) {
        return false;
    }

    @Override
    public BinNode insert(Seminar seminar, int depth) {
        return new LeafNode(seminar);
    }

    @Override
    public Seminar search(double x, double y) {
        return null;
    }

    @Override
    public BinNode delete(double x, double y) {
        return this;
    }

    @Override
    public Seminar getSeminar() {
        return null;
    }

    @Override
    public double getMinX() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double getMinY() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double getMaxY() {
        return Double.NEGATIVE_INFINITY;
    }


    @Override
    public double getMaxX() {
        return Double.NEGATIVE_INFINITY;
    }


    @Override
    public BinNode getLeft() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public BinNode getRight() {
        // TODO Auto-generated method stub
        return null;
    }


       public String toString(int depth) {
        return String.format("%sE\n", "    ".repeat(depth));
    }
}

