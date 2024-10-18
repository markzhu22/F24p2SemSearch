// -------------------------------------------------------------------------
/**
 * A Binary Tree implementation designed to store and manage Seminar objects
 * based on spatial coordinates (x, y). The tree supports insertion, search
 * (with radius-based queries), and deletion of Seminar objects.
 * 
 * The tree alternates splitting on the x-axis and y-axis at each level to
 * divide the 2D space.
 * 
 * This class also provides functions for calculating the size, checking
 * if the tree is empty, and printing the structure of the tree.
 * 
 * @author markz + tarinid
 * @version Oct 17, 2024
 */
public class BinTree {
    private BinNode root; // Root of the binary tree
    private int size; // Number of nodes in the tree
    private int nodesVisited; // Tracks nodes visited during search
    private final int worldSize; // Maximum size of the 2D world (coordinate
                                 // bounds)
    private static final EmptyNode FLYWEIGHT = EmptyNode.getInstance();
    // Flyweight pattern for empty node

    // ----------------------------------------------------------
    /**
     * Constructs a new BinTree with a given world size.
     * 
     * @param worldSize
     *            the maximum size of the world (coordinate bounds)
     */
    public BinTree(int worldSize) {
        this.root = FLYWEIGHT;
        this.size = 0;
        this.worldSize = worldSize;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of nodes in the tree.
     * 
     * @return the size of the tree
     */
    public int size() {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * Inserts a Seminar object into the binary tree based on its coordinates.
     * 
     * @param seminar
     *            the Seminar object to insert
     */
    public void insert(Seminar seminar) {
        if (root == FLYWEIGHT) {
            root = new LeafNode(seminar);
        }
        else {
            root = insertHelper(root, seminar, 0, 0, 0, worldSize, worldSize);
        }
        size++;
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to insert a Seminar into the tree.
     * 
     * @param node
     *            the current node being examined
     * @param seminar
     *            the Seminar object to insert
     * @param depth
     *            the current depth in the tree (used to alternate x/y splits)
     * @param x
     *            the x-coordinate of the region being split
     * @param y
     *            the y-coordinate of the region being split
     * @param width
     *            the width of the region being split
     * @param height
     *            the height of the region being split
     * @return the updated BinNode after insertion
     */
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
            InternalNode newNode = new InternalNode(FLYWEIGHT, FLYWEIGHT,
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
                            plus(depth, 1), splitValue, y, minus(width, minus(
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
                        plus(depth, 1), x, y, minus(splitValue, x), height));
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
                        plus(depth, 1), x, y, width, minus(splitValue, y)));
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
        return FLYWEIGHT;
    }


    // ----------------------------------------------------------
    /**
     * Searches the tree for all seminars within a specified radius of the
     * given coordinates.
     * 
     * @param x
     *            the x-coordinate of the target point
     * @param y
     *            the y-coordinate of the target point
     * @param radius
     *            the search radius
     */
    public void search(int x, int y, int radius) {
        searchHelper(root, x, y, radius, 0, 0, 0, minus(worldSize, 1), minus(
            worldSize, 1));
    }


    // ----------------------------------------------------------
    /**
     * Recursive helper method to search for seminars within a specified
     * radius of a target point.
     * 
     * @param node
     *            the current node being examined
     * @param targetX
     *            the x-coordinate of the target point
     * @param targetY
     *            the y-coordinate of the target point
     * @param radius
     *            the search radius
     * @param depth
     *            the current depth in the tree (used to alternate x/y splits)
     * @param xMin
     *            the minimum x-coordinate of the current region
     * @param yMin
     *            the minimum y-coordinate of the current region
     * @param xMax
     *            the maximum x-coordinate of the current region
     * @param yMax
     *            the maximum y-coordinate of the current region
     */
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
            int midPoint;

            // Calculate midPoint without using ternary operator
            if (splitOnX) {
                midPoint = (xMin + xMax) / 2;
            }
            else {
                midPoint = (yMin + yMax) / 2;
            }

            // Check left and right without using ternary operator
            boolean checkLeft;
            boolean checkRight;

            if (splitOnX) {
                checkLeft = (targetX - radius <= midPoint);
                checkRight = (targetX + radius > midPoint);
            }
            else {
                checkLeft = (targetY - radius <= midPoint);
                checkRight = (targetY + radius > midPoint);
            }

            // Recursive calls
            if (checkLeft) {
                int newXMax = splitOnX ? midPoint : xMax;
                int newYMax = splitOnX ? yMax : midPoint;
                searchHelper(internal.getLeft(), targetX, targetY, radius, plus(
                    depth, 1), xMin, yMin, newXMax, newYMax);
            }
            if (checkRight) {
                int newXMin = splitOnX ? plus(midPoint, 1) : xMin;
                int newYMin = splitOnX ? yMin : plus(midPoint, 1);
                searchHelper(internal.getRight(), targetX, targetY, radius,
                    plus(depth, 1), newXMin, newYMin, xMax, yMax);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Deletes a seminar from the tree based on its coordinates and ID.
     * 
     * @param targetX
     *            the x-coordinate of the seminar
     * @param targetY
     *            the y-coordinate of the seminar
     * @param id
     *            the ID of the seminar to delete
     */
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
            decrement(size);
        }
        // System.out.println("record with id " + id + " successfully deleted
        // from the database");
    }


    // ----------------------------------------------------------
    /**
     * Checks if a seminar is within the specified radius of a target point.
     * 
     * @param seminarX
     *            the x-coordinate of the seminar
     * @param seminarY
     *            the y-coordinate of the seminar
     * @param x
     *            the x-coordinate of the target point
     * @param y
     *            the y-coordinate of the target point
     * @param radius
     *            the search radius
     * @return true if the seminar is within the radius, false otherwise
     */
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


    // ----------------------------------------------------------
    /**
     * Returns the number of nodes visited during the search.
     * 
     * @return the number of nodes visited
     */
    public int getNodesVisited() {
        return nodesVisited;
    }


    // ----------------------------------------------------------
    /**
     * Resets the nodesVisited counter to zero.
     */
    public void resetNodesVisited() {
        nodesVisited = 0;
    }


    // ----------------------------------------------------------
    /**
     * Increments an integer by one.
     * 
     * @param i
     *            the integer to increment
     * @return the incremented value
     */
    public int increment(int i) {
        return i++;
    }


    // ----------------------------------------------------------
    /**
     * Decrements an integer by one.
     * 
     * @param i
     *            the integer to decrement
     * @return the decremented value
     */
    public int decrement(int i) {
        return i--;
    }


    // ----------------------------------------------------------
    /**
     * Prints the structure of the tree, showing the nodes and their locations.
     */
    public void printTree() {
        System.out.println("Location Tree:");
        if (root == FLYWEIGHT) {
            System.out.println("E");
        }
        else {
            root.print(calculateHeight(root));
        }
    }


    // ----------------------------------------------------------
    /**
     * Calculates the height of the tree.
     * 
     * @param node
     *            the current node
     * @return the height of the tree
     */
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
    /**
     * Subtracts two integers.
     * 
     * @param i
     *            the first integer
     * @param j
     *            the second integer
     * @return the result of the subtraction
     */
    private int minus(int i, int j) {
        return i - j;
    }


    /**
     * Adds two integers.
     * 
     * @param i
     *            the first integer
     * @param j
     *            the second integer
     * @return the result of the addition
     */
    private int plus(int i, int j) {
        return i + j;
    }
}
