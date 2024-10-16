public class BinTree {
    private BinNode root;
    private int size;
    private int nodesVisited;
    private final int worldSize;
    private EmptyNode flyweight;

    public BinTree(int worldSize) {
        flyweight = EmptyNode.getInstance();
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
        if (seminar == null) {
            System.out.println("Attempted to insert null seminar");
            return;
        }
        if (seminar.getX() < 0 || seminar.getX() >= worldSize || seminar
            .getY() < 0 || seminar.getY() >= worldSize) {
            System.out.println("Insert FAILED - Bad x, y coordinates: "
                + seminar.getX() + ", " + seminar.getY());
            return;
        }
        BinNode newRoot = insertHelper(root, seminar, 0, 0, 0, worldSize - 1,
            worldSize - 1);
        if (newRoot != root) {
            root = newRoot;
            size++;
        }
    }


    private BinNode insertHelper(
        BinNode node,
        Seminar seminar,
        int depth,
        int xMin,
        int yMin,
        int xMax,
        int yMax) {

        // If the node is empty, create a new leaf node
        if (node instanceof EmptyNode  || node == null) {
            return new LeafNode(seminar);
        }

        // If the node is a leaf node, handle it
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            Seminar existingSeminar = leaf.getSeminars().get(0);

            // If the coordinates are the same, add the seminar to the existing
            // leaf
            if (existingSeminar.getX() == seminar.getX() && existingSeminar
                .getY() == seminar.getY()) {
                leaf.addSeminar(seminar);
                return leaf;
            }
            else {
                // To ensure splitting only happens at internal nodes, create a
                // new internal node
                // and redistribute both the existing and new seminar between
                // the children
                return createInternalNodeWithSeminars(leaf, seminar, depth,
                    xMin, yMin, xMax, yMax);
            }
        }

        // If the node is an internal node, recurse into the correct child
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;

            if (depth % 2 == 0) {
                internal.setLeft(insertHelper(internal.getLeft(), seminar, depth
                    + 1, xMin, yMin, (xMin + xMax) / 2, yMax));
            }
            else {
                internal.setRight(insertHelper(internal.getRight(), seminar,
                    depth + 1, (xMin + xMax) / 2, yMin, xMax, yMax));
            }

            return internal;
        }

        // Fallback (this shouldn't happen)
        return node;
    }


// Helper function to create an internal node and split the seminars into
// children
    private InternalNode createInternalNodeWithSeminars(
        LeafNode leaf,
        Seminar newSeminar,
        int depth,
        int xMin,
        int yMin,
        int xMax,
        int yMax) {
        int n = depth + 1;
        InternalNode newInternal;
        Seminar existingSeminar = leaf.getSeminars().get(0);

        int midPoint;

        if (depth % 2 == 0) {
            newInternal = new InternalNode(flyweight, flyweight, true);
            midPoint = (xMin + xMax) / 2;
        }
        else {
            newInternal = new InternalNode(flyweight, flyweight, false);
            midPoint = (yMin + yMax) / 2;
        }

        // Split the seminars between left and right based on the dimension
        if (depth % 2 == 0) {
            if (existingSeminar.getX() <= midPoint) {
                newInternal.setLeft(leaf);
            }
            else {
                newInternal.setRight(leaf);
            }
            if (newSeminar.getX() <= midPoint) {
                newInternal.setLeft(insertHelper(root.getLeft(),
                    newSeminar, n, xMin, yMin, midPoint, yMax));
            }
            else {
                newInternal.setRight(insertHelper(root.getRight(),
                    newSeminar, n, midPoint, yMin, xMax, yMax));
            }
        }
        else {
            if (existingSeminar.getY() <= midPoint) {
                newInternal.setRight(leaf);
            }
            else {
                newInternal.setLeft(leaf);
            }
            if (newSeminar.getY() <= midPoint) {
                newInternal.setLeft(insertHelper(root.getLeft(),
                    newSeminar, n, xMin, yMin, xMax, midPoint));
            }
            else {
                newInternal.setRight(insertHelper(root.getRight(),
                    newSeminar, n, xMin, midPoint, xMax, yMax));
            }
        }

        return newInternal;
    }


    public Seminar search(int x, int y) {
        resetNodesVisited();
        Seminar result = searchHelper(root, x, y, 0, 0, 0, worldSize - 1,
            worldSize - 1);

        if (result != null) {
            System.out.println("Found 1 seminar at (" + x + ", " + y + ")");
            System.out.println("ID: " + result.getId() + ", Title: " + result
                .title());
        }
        else {
            System.out.println("No seminars found at (" + x + ", " + y + ")");
        }

        System.out.println(nodesVisited + " nodes visited in this search");
        return result;
    }


    private Seminar searchHelper(
        BinNode node,
        int x,
        int y,
        int nodeX,
        int nodeY,
        int width,
        int height,
        int depth) {

        nodesVisited++;

        int n = depth + 1;
        int k = width / 2;
        int l = height / 2;
        // Base case: node is an empty node
        if (node instanceof EmptyNode) {
            return null; // Nothing found
        }

        // Base case: node is a leaf node
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();
            // Loop through seminars to find a matching one
            for (int i = 0; i < seminars.size(); i++) {
                Seminar seminar = seminars.get(i);
                if (seminar.getX() == x && seminar.getY() == y) {
                    return seminar; // Found the matching seminar
                }
            }
            return null; // No match found
        }

        // Recursive case: node is an internal node
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Determine if we are splitting on X or Y
            if (depth % 2 == 0) {
                // Split on X, calculate X midpoint
                midPoint = (nodeX + width) / 2;

                // Go left if the target X is less than the midpoint
                if (x < midPoint) {
                    return searchHelper(internal.getLeft(), x, y, nodeX, nodeY,
                        k, height, n);
                }
                // Go right if the target X is greater than or equal to the
                // midpoint
                else {
                    return searchHelper(internal.getRight(), x, y, midPoint,
                        nodeY, k, height, n);
                }
            }
            else {
                // Split on Y, calculate Y midpoint
                midPoint = (nodeY + height) / 2;

                // Go left if the target Y is less than the midpoint
                if (y < midPoint) {
                    return searchHelper(internal.getLeft(), x, y, nodeX, nodeY,
                        width, l, n);
                }
                // Go right if the target Y is greater than or equal to the
                // midpoint
                else {
                    return searchHelper(internal.getRight(), x, y, nodeX,
                        midPoint, width, l, n);
                }
            }
        }

        return null; // Fallback case (shouldn't happen)
    }


    public void delete(int x, int y) {
        root = deleteHelper(root, x, y, 0, 0, 0, worldSize - 1, worldSize - 1);
        size--;
    }


    private BinNode deleteHelper(
        BinNode node,
        int x,
        int y,
        int nodeX,
        int nodeY,
        int width,
        int height,
        int depth) {

        int n = depth + 1;
        int w = width / 2;
        int h = height / 2;

        // If node is empty, return as is
        if (node instanceof EmptyNode) {
            return node;
        }

        // If node is a leaf, check if the seminar matches, and delete if found
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();

            // Iterate through seminars and remove the one matching the x and y
            // coordinates
            for (int i = 0; i < seminars.size(); i++) {
                Seminar seminar = seminars.get(i);
                if (seminar.getX() == x && seminar.getY() == y) {
                    seminars.remove(i);
                    // If there are no more seminars in the leaf, return an
                    // EmptyNode
                    if (seminars.isEmpty()) {
                        return EmptyNode.getInstance();
                    }
                    return leaf; // Return the modified leaf node if there are
                                 // still seminars left
                }
            }
            return node; // If no seminar matches, return the node as is
        }

        // If node is an internal node, we decide whether to go left or right
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Calculate the midpoint and decide whether to go left or right
            // based on depth
            if (depth % 2 == 0) { // Splitting based on X
                midPoint = (nodeX + width) / 2;
                if (x < midPoint) {
                    // Go left, as the seminar is on the left side
                    internal.setLeft(deleteHelper(internal.getLeft(), x, y,
                        nodeX, nodeY, w, height, n));
                }
                else {
                    // Go right, as the seminar is on the right side
                    internal.setRight(deleteHelper(internal.getRight(), x, y,
                        midPoint, nodeY, w, height, n));
                }
            }
            else { // Splitting based on Y
                midPoint = (nodeY + height) / 2;
                if (y < midPoint) {
                    // Go left, as the seminar is on the left side
                    internal.setLeft(deleteHelper(internal.getLeft(), x, y,
                        nodeX, nodeY, width, h, n));
                }
                else {
                    // Go right, as the seminar is on the right side
                    internal.setRight(deleteHelper(internal.getRight(), x, y,
                        nodeX, midPoint, width, h, n));
                }
            }

            // After the deletion, check if both children are empty
            if (internal.getLeft() instanceof EmptyNode && internal
                .getRight() instanceof EmptyNode) {
                return EmptyNode.getInstance();
            }

            // If one child is empty, return the non-empty child to collapse the
            // tree
            if (internal.getLeft() instanceof EmptyNode) {
                return internal.getRight();
            }
            if (internal.getRight() instanceof EmptyNode) {
                return internal.getLeft();
            }

            // Return the internal node if both children are still valid
            return internal;
        }

        // Fallback case (shouldn't happen)
        return node;
    }


    public void searchInRange(int x, int y, int radius) {
        nodesVisited = 0;
        Seminar[] results = new Seminar[size]; // Assume size is total number of
                                               // seminars
        int[] count = new int[1]; // To keep track of results found

        // Print the initial message about the search radius and center
        System.out.println("Seminars within " + radius + " units of " + x + ", "
            + y + ":");

        // Call the recursive search helper
        searchInRangeHelper(root, x, y, radius, 0, 0, worldSize, worldSize,
            radius, results, count);

        // If no seminars found, print that no records were found
        if (count[0] == 0) {
            System.out.println("No records found.");
        }

        // Print the number of nodes visited in the search
        System.out.println(nodesVisited + " nodes visited in this search\n");
    }


    private void searchInRangeHelper(
        BinNode node,
        int x,
        int y,
        int radius,
        int nodeX,
        int nodeY,
        int width,
        int height,
        int depth, // New depth parameter to track dimension splits
        Seminar[] results,
        int[] count) {

        int n = depth + 1;
        int w = width / 2;
        int h = height / 2;
        nodesVisited++; // Count the number of nodes visited

        if (node instanceof EmptyNode) {
            return; // If node is empty, exit
        }

        // Check if the search circle intersects with the node's bounding box
        if (!intersects(x, y, radius, nodeX, nodeY, nodeX + width, nodeY
            + height)) {
            return;
        }

        // Process leaf nodes (actual seminar data)
        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();

            // Loop through seminars in this leaf node and check if they're
            // within range
            for (int i = 0; i < seminars.size(); i++) {
                Seminar seminar = seminars.get(i);
                if (inRange(seminar.getX(), seminar.getY(), x, y, radius)) {
                    System.out.println("Found a record with key value "
                        + seminar.getId() + " at " + seminar.getX() + ", "
                        + seminar.getY());
                    results[count[0]++] = seminar; // Add seminar to results
                                                   // array
                }
            }
            return;
        }

        // Process internal nodes (recursive traversal through the tree)
        if (node instanceof InternalNode) {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Split based on depth (even -> X, odd -> Y)
            if (depth % 2 == 0) { // Splitting on X
                midPoint = (nodeX + width) / 2;

                // Recursively search left and right children based on the
                // x-coordinate
                searchInRangeHelper(internal.getLeft(), x, y, radius, nodeX,
                    nodeY, w, height, n, results, count);
                searchInRangeHelper(internal.getRight(), x, y, radius, midPoint,
                    nodeY, w, height, n, results, count);

            }
            else { // Splitting on Y
                midPoint = (nodeY + height) / 2;

                // Recursively search left and right children based on the
                // y-coordinate
                searchInRangeHelper(internal.getLeft(), x, y, radius, nodeX,
                    nodeY, width, h, n, results, count);
                searchInRangeHelper(internal.getRight(), x, y, radius, nodeX,
                    midPoint, width, h, n, results, count);
            }
        }
    }


    // Bounding box intersection check
    private boolean intersects(
        int x,
        int y,
        int radius,
        int nodeX,
        int nodeY,
        int nodeWidth,
        int nodeHeight) {

        int xmin = nodeX;
        int xmax = nodeX + nodeWidth;
        int ymin = nodeY;
        int ymax = nodeY + nodeHeight;

        // Adjust bounds to include extra space for pixelated grid handling
        int left = x - radius;
        int right = x + radius + 1;
        int top = y - radius;
        int bottom = y + radius + 1;

        // Check if bounding box intersects the node region
        return xmax >= left && xmin <= right && ymax >= top && ymin <= bottom;
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


    /**
     * Helper method to calculate the height of a tree.
     * 
     * @param node
     *            The current node.
     * @return The height of the tree.
     */
    private int calculateHeight(BinNode node) {
        if (node == null || node.isLeaf()) {
            return 0;
        }

        return increment(Math.max(calculateHeight(node.getLeft()),
            calculateHeight(node.getRight())));
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
            return;
        }
        root.print(this.root, calculateHeight(root));
    }

}
