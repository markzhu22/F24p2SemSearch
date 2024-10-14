import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class BinTree {
    private BinNode root;
    private int size;
    private int nodesVisited;
    @SuppressWarnings("unused")
    private static final int MAX_OBJECTS_PER_LEAF = 2; 

    public BinTree() {
        this.root = EmptyNode.getInstance();
        this.size = 0;
    }

    public List<Seminar> searchByKeyword(String keyword) {
        List<Seminar> results = new ArrayList<>();
        searchByKeywordHelper(root, keyword, results);
        return results;
    }

    private void searchByKeywordHelper(BinNode node, String keyword, List<Seminar> results) {
        if (node instanceof LeafNode) {
            Seminar seminar = ((LeafNode) node).getSeminar();
            if (seminar.hasKeyword(keyword)) {
                results.add(seminar);
            }
        } else if (node instanceof InternalNode) {
            searchByKeywordHelper(((InternalNode) node).getLeft(), keyword, results);
            searchByKeywordHelper(((InternalNode) node).getRight(), keyword, results);
        }
    }

    public int getNodesVisited() {
        return nodesVisited;
    }

    public void resetNodesVisited() {
        nodesVisited = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Location Tree:\n");
        toString(root, sb, 0);
        return sb.toString();
    }

    private void toString(BinNode node, StringBuilder sb, int depth) {
       String indent = String.join("", Collections.nCopies(depth, "    "));
        if (node instanceof EmptyNode) {
            sb.append(indent).append("(E)\n");
        } else if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            sb.append(indent).append("(Leaf with 1 objects: ").append(leaf.getSeminar().getId()).append(")\n");
        } else if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode) node;
            sb.append(indent).append("(I)\n");
            toString(internal.getLeft(), sb, depth + 1);
            toString(internal.getRight(), sb, depth + 1);
        }
    }

    public void insert(Seminar seminar) {
        root = insertHelper(root, seminar, 0);
        size++;
    }

    private BinNode insertHelper(BinNode node, Seminar seminar, int depth) {
        if (node instanceof EmptyNode) {
            return new LeafNode(seminar);
        }
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            return splitNode(leaf, seminar, depth);
        }
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode) node;
            if ((depth % 2 == 0 && seminar.getX() < internal.getRight().getMinX()) ||
                (depth % 2 != 0 && seminar.getY() < internal.getRight().getMinY())) {
                return new InternalNode(insertHelper(internal.getLeft(), seminar, depth + 1), internal.getRight(), true, depth);
            } else {
                return new InternalNode(internal.getLeft(), insertHelper(internal.getRight(), seminar, depth + 1), false, depth);
            }
        }
        return node;
    }

    private BinNode splitNode(LeafNode leaf, Seminar newSeminar, int depth) {
        BinNode left, right;
        boolean isLeftSmaller;
    
        if (newSeminar.getId() < leaf.getSeminar().getId()) {
            left = new LeafNode(newSeminar);
            right = leaf;
            isLeftSmaller = true;
        } else {
            left = leaf;
            right = new LeafNode(newSeminar);
            isLeftSmaller = false;
        }
    
        return new InternalNode(left, right, isLeftSmaller, depth);
    }
    public Seminar search(int id) {
        return searchHelper(root, id);
    }

    private Seminar searchHelper(BinNode node, int id) {
        if (node instanceof EmptyNode) {
            return null;
        }
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            Seminar seminar = leaf.getSeminar();
            if (id == seminar.getId()) {
                return seminar;
            }
            return null;
        }
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode) node;
            if (id <= internal.getLeftmostId()) {
                return searchHelper(internal.getLeft(), id);
            } else {
                return searchHelper(internal.getRight(), id);
            }
        }
        return null;
    }

    public void delete(double x, double y) {
        root = root.delete(x, y);
        size--;
    }
}