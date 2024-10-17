public class InternalNode implements BinNode {
    private BinNode left;
    private BinNode right;
    private boolean splitOnX;
    private int splitValue;

    public InternalNode(
        BinNode left,
        BinNode right,
        boolean splitOnX,
        int splitValue) {
        this.left = left;
        this.right = right;
        this.splitOnX = splitOnX;
        this.splitValue = splitValue;
    }


    @Override
    public boolean isLeaf() {
        return false;
    }


    @Override
    public Seminar getSeminar() {
        return null;
    }


    @Override
    public BinNode getLeft() {
        return left;
    }


    @Override
    public void setLeft(BinNode left) {
        this.left = left;
    }


    @Override
    public BinNode getRight() {
        return right;
    }


    @Override
    public void setRight(BinNode right) {
        this.right = right;
    }


    @Override
    public boolean isSplitOnX() {
        return splitOnX;
    }


    public int getSplitValue() {
        return splitValue;
    }


    public void setSplitValue(int splitValue) {
        this.splitValue = splitValue;
    }


    @Override
    public void print(int depth) {
        printIndent(depth);
        System.out.println("(I)");
        right.print(incrementDepth(depth));
        left.print(incrementDepth(depth));
    }


    @Override
    public void print(BinNode node, int depth) {
        print(depth);
    }


    @Override
    public int incrementDepth(int depth) {
        return depth - 1;
    }


    private void printIndent(int depth) {
        for (int i = 0; i < depth - 1; i++) {
            System.out.print("    ");
        }
    }


    @Override
    public BinNode delete(
        int id,
        int targetX,
        int targetY,
        int xMin,
        int yMin,
        int xMax,
        int yMax,
        int depth) {
        int midPoint;
        if (depth % 2 == 0) { // Splitting based on X
            midPoint = (xMin + xMax) / 2;
            if (targetX <= midPoint) {
                left = left.delete(id, targetX, targetY, xMin, yMin, midPoint,
                    yMax, depth + 1);
            }
            else {
                right = right.delete(id, targetX, targetY, midPoint + 1, yMin,
                    xMax, yMax, depth + 1);
            }
        }
        else { // Splitting based on Y
            midPoint = (yMin + yMax) / 2;
            if (targetY <= midPoint) {
                left = left.delete(id, targetX, targetY, xMin, yMin, xMax,
                    midPoint, depth + 1);
            }
            else {
                right = right.delete(id, targetX, targetY, xMin, midPoint + 1,
                    xMax, yMax, depth + 1);
            }
        }

        // If both children are empty, return an empty node
        if (left instanceof LeafNode && right instanceof EmptyNode) {
            return left;
        }
        // If one child is empty, return the other child
        else if (left instanceof EmptyNode && right instanceof LeafNode) {
            return right;
        }
        // Otherwise, return this node
        return this;
    }
}
