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
        this.seminars.add(seminar);
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
    public void print(BinNode node, int depth) {
        String space = "";

        for (int i = 0; i < depth; i++) {
            space += "    ";
        }
        System.out.print(space);
        System.out.print("(Leaf with " + seminars.size() + "objects:");
        for (int i = 0; i < seminars.size(); i++) {
            System.out.print(" " + seminars.get(i).getId());
        }
        System.out.println(")");
    }

}
