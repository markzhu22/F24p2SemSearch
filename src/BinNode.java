public interface BinNode {
    boolean isLeaf();


    void traverse();


    boolean intersects(double x, double y, double radius);


    Seminar getSeminar();


    double getMinX();


    double getMaxY();


    double getMaxX();
}
