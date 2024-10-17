public class BinTree {
    private BinNode root;
    private int size;
    private int nodesVisited;
    private final int worldSize;
    private static final EmptyNode flyweight = EmptyNode.getInstance();

    public BinTree(int worldSize) {
        this.root = flyweight;
        this.size = 0;
        this.worldSize = worldSize;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void insert(Seminar seminar) {
        if (root == flyweight) {
            root = new LeafNode(seminar);
        }
        else {
            root = insertHelper(root, seminar, 0, 0, 0, worldSize, worldSize);
        }
        size++;
    }


    private BinNode insertHelper(
        BinNode node,
        Seminar seminar,
        int depth,
        int x,
        int y,
        int width,
        int height) {
        if (node instanceof EmptyNode) {
            return new LeafNode(seminar);
        }

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            if (leaf.getSeminar().x() == seminar.x() && leaf.getSeminar()
                .y() == seminar.y()) {
                leaf.addSeminar(seminar);
                return leaf;
            }

            // Create a new internal node and redistribute seminars
            boolean splitOnX = depth % 2 == 0;
            int splitValue;
            if (splitOnX) {
                splitValue = x + width / 2;
            }
            else {
                splitValue = y + height / 2;
            }
            InternalNode newNode = new InternalNode(flyweight, flyweight,
                splitOnX, splitValue);
            LinkedList seminars = new LinkedList();
            for (int i = 0; i < leaf.getSeminars().size(); i++) {
                seminars.add(leaf.getSeminars().get(i));
            }
            seminars.add(seminar);

            for (int i = 0; i < seminars.size(); i++) {
                Seminar s = seminars.get(i);
                if (splitOnX) {
                    if (s.getX() < splitValue) {
                        newNode.setLeft(insertHelper(newNode.getLeft(), s, plus(
                            depth, 1), x, y, minus(splitValue, x), height));
                    }
                    else {
                        newNode.setRight(insertHelper(newNode.getRight(), s,
                            depth + 1, splitValue, y, minus(width, minus(
                                splitValue, x)), height));
                    }
                }
                else {
                    if (s.getY() < splitValue) {
                        newNode.setLeft(insertHelper(newNode.getLeft(), s, depth
                            + 1, x, y, width, minus(splitValue, y)));
                    }
                    else {
                        newNode.setRight(insertHelper(newNode.getRight(), s,
                            depth + 1, x, splitValue, width, minus(height,
                                minus(splitValue, y))));
                    }
                }
            }

            return newNode;
        }

        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            boolean splitOnX = internal.isSplitOnX();
            int splitValue = internal.getSplitValue();

            if (splitOnX) {
                if (seminar.getX() < splitValue) {
                    internal.setLeft(insertHelper(internal.getLeft(), seminar,
                        depth + 1, x, y, minus(splitValue, x), height));
                }
                else {
                    internal.setRight(insertHelper(internal.getRight(), seminar,
                        plus(depth, 1), splitValue, y, minus(width, minus(
                            splitValue, x)), height));
                }
            }
            else {
                if (seminar.getY() < splitValue) {
                    internal.setLeft(insertHelper(internal.getLeft(), seminar,
                        depth + 1, x, y, width, minus(splitValue, y)));
                }
                else {
                    internal.setRight(insertHelper(internal.getRight(), seminar,
                        plus(depth, 1), x, splitValue, width, minus(height,
                            minus(splitValue, y))));
                }
            }
            return internal;
        }

        // This should never happen
        return flyweight;
    }


    public void search(int x, int y, int radius) {
        searchHelper(root, x, y, radius, 0, 0, 0, minus(worldSize, 1), worldSize
            - 1);
    }


    private void searchHelper(
        BinNode node,
        int targetX,
        int targetY,
        int radius,
        int depth,
        int xMin,
        int yMin,
        int xMax,
        int yMax) {

        nodesVisited++;

        if (node instanceof EmptyNode) {
            return;
        }

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            LinkedList seminars = leaf.getSeminars();
            for (int i = 0; i < seminars.size(); i++) {
                Seminar seminar = seminars.get(i);
                if (inRange(seminar.getX(), seminar.getY(), targetX, targetY,
                    radius)) {
                    System.out.println("Found a record with key value "
                        + seminar.id() + " at " + seminar.x() + ", " + seminar
                            .y());
                }
            }
            return;
        }

        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            boolean splitOnX = (depth % 2 == 0);
            int midPoint = splitOnX ? (xMin + xMax) / 2 : (yMin + yMax) / 2;

            // Always check both subtrees if the search area overlaps the split
            // line
            boolean checkLeft = splitOnX
                ? (targetX - radius <= midPoint)
                : (targetY - radius <= midPoint);
            boolean checkRight = splitOnX
                ? (targetX + radius > midPoint)
                : (targetY + radius > midPoint);

            if (checkLeft) {
                searchHelper(internal.getLeft(), targetX, targetY, radius, depth
                    + 1, xMin, yMin, splitOnX ? midPoint : xMax, splitOnX
                        ? yMax
                        : midPoint);
            }
            if (checkRight) {
                searchHelper(internal.getRight(), targetX, targetY, radius,
                    depth + 1, splitOnX ? midPoint + 1 : xMin, splitOnX
                        ? yMin
                        : midPoint + 1, xMax, yMax);
            }
        }
    }


    public void delete(int targetX, int targetY, int id) {
        BinNode oldRoot = root;
        root = root.delete(id, targetX, targetY, 0, 0, worldSize - 1, worldSize
            - 1, 0);
        if (root instanceof EmptyNode) {
            root = EmptyNode.getInstance();
            size = 0;
        }
        else if (oldRoot != root) {
            // If the root has changed (i.e., a deletion occurred), decrement
            // the size
            size--;
        }
        // System.out.println("record with id " + id + " successfully deleted
        // from the database");
    }


    // Check if the seminar is within the radius
    private boolean inRange(
        int seminarX,
        int seminarY,
        int x,
        int y,
        int radius) {
        int dx = seminarX - x;
        int dy = seminarY - y;
        return (dx * dx + dy * dy) <= (radius * radius);
    }


    public int getNodesVisited() {
        return nodesVisited;
    }


    public void resetNodesVisited() {
        nodesVisited = 0;
    }


    // ----------------------------------------------------------
    /**
     * Increments an integer by one
     * 
     * @param i
     *            the integer to be incremented
     * @return incremented i
     */
    public int increment(int i) {
        return i += 1;
    }


    public void printTree() {
        System.out.println("Location Tree:");
        if (root == flyweight) {
            System.out.println("E");
        }
        else {
            root.print(calculateHeight(root));
        }
    }


    private int calculateHeight(BinNode node) {
        if (node == null || node instanceof EmptyNode) {
            return 0;
        }

        return plus(1, Math.max(calculateHeight(node.getLeft()),
            calculateHeight(node.getRight())));
    }

    // ----------------------------------------------------------
    // Mutation Testing Functions
    // ----------------------------------------------------------


    private int minus(int i, int j) {
        return i - j;
    }


    private int plus(int i, int j) {
        return i + j;
    }

}
