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
    public Seminar getSeminar() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public double getMinX() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public double getMaxY() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public double getMaxX() {
        // TODO Auto-generated method stub
        return 0;
    }
}
