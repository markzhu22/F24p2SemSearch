public class LeafNode implements BinNode {
    private LinkedList<Seminar> seminars;

    public LeafNode(Seminar seminar) {
        this.seminars = new LinkedList<>();
        this.seminars.add(seminar);
    }


    public LinkedList<Seminar> getSeminars() {
        return seminars;
    }


    public void addSeminar(Seminar seminar) {
        if (seminars.size() < 3) {
            seminars.add(seminar);
        }
    }

    public LeafNode(LinkedList<Seminar> seminars) {
        this.seminars = seminars;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }


    @Override
    public BinNode getLeft() {
        return null;
    }


    @Override
    public BinNode getRight() {
        return null;
    }


    @Override
    public void setLeft(BinNode left) {
        // Do nothing, leaf nodes don't have children
    }


    @Override
    public void setRight(BinNode right) {
        // Do nothing, leaf nodes don't have children
    }


    @Override
    public boolean isSplitOnX() {
        // Leaf nodes are not split
        return false;
    }


   

    public Seminar getSeminar() {
        return seminars.isEmpty() ? null : seminars.get(0);
    }


    @Override
    public void print(int depth) {
        printIndent(depth);
        System.out.print("(Leaf with " + seminars.size() + " objects:");
        for (int i = 0; i < seminars.size(); i++) {
            Seminar seminar = seminars.get(i);
            System.out.print(" " + seminar.getId());
        }
        System.out.println(")");
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
