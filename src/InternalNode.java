public class InternalNode implements BinNode {
    private BinNode left;
    private BinNode right;
    private boolean splitOnX;

    public InternalNode(BinNode left, BinNode right, boolean splitOnX) {
        this.left = left;
        this.right = right;
        this.splitOnX = splitOnX;
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


    @Override
    public void print(BinNode node, int depth) {
        String space = "";

        for (int i = 0; i < depth; i++) {
            space += "    ";
        }
        System.out.print(space);
        System.out.println("(I)");
        int newDepth = depth-1;
        node.getLeft().print(left, newDepth);
        node.getRight().print(right, newDepth);
    }


}
