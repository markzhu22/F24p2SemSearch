public class InternalNode implements BinNode {
    private BinNode left; // Left child
    private BinNode right; // Right child
    private boolean splitOnX; // true for x split, false for y split

    public InternalNode(BinNode left, BinNode right, boolean splitOnX) {
        this.left = left;
        this.right = right;
        this.splitOnX = splitOnX;
    }


 
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


   
    public void traverse() {
        if (left != null)
            left.traverse();
        if (right != null)
            right.traverse();
    }


  
    public boolean intersects(double x, double y, double radius) {
        // Calculate bounding box for this internal node based on child nodes
        double minX = left.getMinX();
        double maxX = right.getMaxX();
        double minY = left.getMinY();
        double maxY = right.getMaxY();

        if (!splitOnX) {
            minY = Math.min(left.getMinY(), right.getMinY()); 
            maxY = Math.max(left.getMaxY(), right.getMaxY()); 
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

            if (xDist <= boxHalfWidth + radius && yDist <= boxHalfHeight + radius) {
                return left.intersects(x, y, radius) || right.intersects(x, y, radius);
            }
            return false;
    }

    
    public BinNode insert(Seminar seminar) {
        if (splitOnX) {
            if (seminar.getX() < right.getMinX()) {
                left = left.insert(seminar);
            } else {
                right = right.insert(seminar);
            }
        } else {
            if (seminar.getY() < right.getMinY()) {
                left = left.insert(seminar);
            } else {
                right = right.insert(seminar);
            }
        }
        return this;
    }

   
    public Seminar search(double x, double y) {
        if (intersects(x, y, 0)) {
            Seminar leftResult = left.search(x, y);
            if (leftResult != null) {
                return leftResult;
            }
            return right.search(x, y);
        }
        return null;
    }

  
    @Override
        public BinNode delete(double x, double y) {
            if (intersects(x, y, 0)) {
                left = left.delete(x, y);
                right = right.delete(x, y);
                
                // Case 1: Both children are EmptyNodes
                if (left instanceof EmptyNode && right instanceof EmptyNode) {
                    return EmptyNode.getInstance();
                }
                
                // Case 2: Left child is EmptyNode
                if (left instanceof EmptyNode) {
                    return right;
                }
                
                // Case 3: Right child is EmptyNode
                if (right instanceof EmptyNode) {
                    return left;
                }
                
                // Case 4: Both children are LeafNodes
                if (left instanceof LeafNode && right instanceof LeafNode) {
                    LeafNode leftLeaf = (LeafNode) left;
                    LeafNode rightLeaf = (LeafNode) right;
                    if (leftLeaf.getSeminar() == null && rightLeaf.getSeminar() == null) {
                        return EmptyNode.getInstance();
                    } else if (leftLeaf.getSeminar() == null) {
                        return right;
                    } else if (rightLeaf.getSeminar() == null) {
                        return left;
                    }
                }
            }
            return this;
        }


    public Seminar getSeminar() {
        return null;
    }


    public double getMinX() {
        return Math.min(left.getMinX(), right.getMinX());
    }


    public double getMaxX() {
        return Math.max(left.getMaxX(), right.getMaxX());
    }

    public double getMinY() {
        return Math.min(left.getMinY(), right.getMinY());
    }

    @Override
    public double getMaxY() {
        return Math.max(left.getMaxY(), right.getMaxY());
    }
}
