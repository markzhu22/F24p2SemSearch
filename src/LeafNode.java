public class LeafNode implements BinNode {
    private Seminar seminar;

    public LeafNode(Seminar seminar) {
        this.seminar = seminar;
    }


    @Override
    public boolean isLeaf() {
        return true;
    }


    @Override
    public void traverse() {
        System.out.println("Leaf node: " + seminar);
    }


    @Override
    public boolean intersects(double x, double y, double radius) {
        // Check if seminar is within the radius
        double dist = Math.sqrt(Math.pow(seminar.getX() - x, 2) + Math.pow(
            seminar.getY() - y, 2));
        return dist <= radius;
    }


    public Seminar getSeminar() {
        return seminar;
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
