public interface BinNode {
    boolean isLeaf();

    void traverse();

    boolean intersects(double x, double y, double radius);

    Seminar getSeminar();

    double getMinX();

    double getMinY();

    double getMaxY();

    double getMaxX();

    BinNode getLeft();

    BinNode getRight();

    BinNode insert(Seminar seminar, int depth);

    Seminar search(double x, double y);

    BinNode delete(double x, double y);

    String toString(int depth);
}
