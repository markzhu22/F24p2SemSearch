public class InternalNode implements BinNode {
    private BinNode left;
    private BinNode right;
    private boolean splitOnX;
    private int splitValue;

    public InternalNode(BinNode left, BinNode right, boolean splitOnX, int splitValue) {
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
        return depth + 1;
    }

    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }
}
