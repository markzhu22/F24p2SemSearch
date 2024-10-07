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
        double dist = Math.sqrt(Math.pow(seminar.getX() - x, 2) + Math.pow(
            seminar.getY() - y, 2));
        return dist <= radius;
    }

    @Override
    public BinNode insert(Seminar newSeminar) {
        return new InternalNode(
            new LeafNode(this.seminar), 
            new LeafNode(newSeminar), 
            this.seminar.getX() != newSeminar.getX()
        );
    }

    @Override
    public Seminar search(double x, double y) {
        if (seminar != null && 
            Math.abs(seminar.getX() - x) < 1e-6 && 
            Math.abs(seminar.getY() - y) < 1e-6) {
            return seminar;
        }
        return null;
    }

    @Override
    public BinNode delete(double x, double y) {
        if (Math.abs(seminar.getX() - x) < 1e-6 && 
            Math.abs(seminar.getY() - y) < 1e-6) {
            return EmptyNode.getInstance();
        }
        return this;
    }

    public Seminar getSeminar() {
        return seminar;
    }


    @Override
    public double getMinX() {
        return seminar.getX();
    }

    @Override
    public double getMinY() {
        return seminar.getY();
    }

    @Override
    public double getMaxY() {
        return seminar.getY();
    }


    @Override
    public double getMaxX() {
        return seminar.getX();
    }

    
}
