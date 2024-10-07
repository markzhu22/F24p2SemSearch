public class InternalNode implements BinNode {
    private BinNode left; // Left child
    private BinNode right; // Right child
    @SuppressWarnings("unused")
    private boolean splitOnX; // true for x split, false for y split

    public InternalNode(BinNode left, BinNode right, boolean splitOnX) {
        this.left = left;
        this.right = right;
        this.splitOnX = splitOnX;
    }


    @Override
    public boolean isLeaf() {
        return false;
    }


    public BinNode getLeft() {
        return left;
    }


    public void setLeft(BinNode left) {
        this.left = left;
    }


    public BinNode getRight() {
        return right;
    }


    public void setRight(BinNode right) {
        this.right = right;
    }


    @Override
    public void traverse() {
        if (left != null)
            left.traverse();
        if (right != null)
            right.traverse();
    }


    @Override
    public boolean intersects(double x, double y, double radius) {
        // Calculate bounding box for this internal node based on child nodes
        double minX = left.getMinX();
        double maxX = right.getMaxX();
        double minY = left.getMaxY();
        double maxY = right.getMaxY();

        if (!splitOnX) {
            minY = left.getMinX();
            maxY = right.getMaxY();
        }

        // Calculate center of the bounding box
        double centerX = (minX + maxX) / 2;
        double centerY = (minY + maxY) / 2;

        // Calculate the distance from the circle's center to the bounding box
        // center
        double xDist = Math.abs(x - centerX);
        double yDist = Math.abs(y - centerY);

        // Half dimensions of the bounding box
        double boxHalfWidth = (maxX - minX) / 2;
        double boxHalfHeight = (maxY - minY) / 2;

        // Debug output to trace the values
        System.out.println("Bounding Box - minX: " + minX + ", maxX: " + maxX);
        System.out.println("Bounding Box - minY: " + minY + ", maxY: " + maxY);
        System.out.println("Center of Box - centerX: " + centerX + ", centerY: "
            + centerY);
        System.out.println("Circle Center - x: " + x + ", y: " + y
            + ", radius: " + radius);
        System.out.println("Distance - xDist: " + xDist + ", yDist: " + yDist);
        System.out.println("Box Half Width: " + boxHalfWidth
            + ", Box Half Height: " + boxHalfHeight);

        // Check if the circle's radius intersects with the bounding box
        return (xDist <= boxHalfWidth + radius) && (yDist <= boxHalfHeight
            + radius);
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
