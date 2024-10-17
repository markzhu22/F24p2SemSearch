public class BinTree
{
    private BinNode root;
    private int size;
    private int nodesVisited;
    private final int worldSize;
    private EmptyNode flyweight;

    public BinTree(int worldSize)
    {
        flyweight = EmptyNode.getInstance();
        this.root = flyweight;
        this.size = 0;
        this.worldSize = worldSize;
    }


    public int size()
    {
        return size;
    }


    public boolean isEmpty()
    {
        return size == 0;
    }


    public void insert(Seminar seminar)
    {
        if (root == flyweight)
        {
            root = new LeafNode(seminar);
        }
        else
        {
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
        int height)
    {
        if (node instanceof EmptyNode)
        {
            return new LeafNode(seminar);
        }

        if (node instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode)node;
            if (leaf.getSeminars().size() < 2)
            {
                leaf.addSeminar(seminar);
                return leaf;
            }
            // Create a new internal node and redistribute seminars
            boolean splitOnX = depth % 2 == 0;
            int splitValue;
            if (splitOnX)
            {
                splitValue = x + width / 2;
            }
            else
            {
                splitValue = y + height / 2;
            }
            InternalNode newNode =
                new InternalNode(flyweight, flyweight, splitOnX, splitValue);
            LinkedList<Seminar> seminars = new LinkedList<Seminar>();
            for (int i = 0; i < leaf.getSeminars().size(); i++)
            {
                seminars.add(leaf.getSeminars().get(i));
            }
            seminars.add(seminar);

            for (int i = 0; i < seminars.size(); i++)
            {
                Seminar s = seminars.get(i);
                if (splitOnX)
                {
                    if (s.getX() < splitValue)
                    {
                        newNode.setLeft(
                            insertHelper(
                                newNode.getLeft(),
                                s,
                                depth + 1,
                                x,
                                y,
                                splitValue - x,
                                height));
                    }
                    else
                    {
                        newNode.setRight(
                            insertHelper(
                                newNode.getRight(),
                                s,
                                depth + 1,
                                splitValue,
                                y,
                                width - (splitValue - x),
                                height));
                    }
                }
                else
                {
                    if (s.getY() < splitValue)
                    {
                        newNode.setLeft(
                            insertHelper(
                                newNode.getLeft(),
                                s,
                                depth + 1,
                                x,
                                y,
                                width,
                                splitValue - y));
                    }
                    else
                    {
                        newNode.setRight(
                            insertHelper(
                                newNode.getRight(),
                                s,
                                depth + 1,
                                x,
                                splitValue,
                                width,
                                height - (splitValue - y)));
                    }
                }
            }

            return newNode;
        }

        if (node instanceof InternalNode)
        {
            InternalNode internal = (InternalNode)node;
            boolean splitOnX = internal.isSplitOnX();
            int splitValue = internal.getSplitValue();

            if (splitOnX)
            {
                if (seminar.getX() < splitValue)
                {
                    internal.setLeft(
                        insertHelper(
                            internal.getLeft(),
                            seminar,
                            depth + 1,
                            x,
                            y,
                            splitValue - x,
                            height));
                }
                else
                {
                    internal.setRight(
                        insertHelper(
                            internal.getRight(),
                            seminar,
                            depth + 1,
                            splitValue,
                            y,
                            width - (splitValue - x),
                            height));
                }
            }
            else
            {
                if (seminar.getY() < splitValue)
                {
                    internal.setLeft(
                        insertHelper(
                            internal.getLeft(),
                            seminar,
                            depth + 1,
                            x,
                            y,
                            width,
                            splitValue - y));
                }
                else
                {
                    internal.setRight(
                        insertHelper(
                            internal.getRight(),
                            seminar,
                            depth + 1,
                            x,
                            splitValue,
                            width,
                            height - (splitValue - y)));
                }
            }
            return internal;
        }

        // This should never happen
        return flyweight;
    }


// Helper function to create an internal node and split the seminars into
// children
    private BinNode createInternalNodeWithSeminars(
        LinkedList<Seminar> seminars,
        Seminar newSeminar,
        boolean splitOnX,
        int depth)
    {
        if (newSeminar != null)
        {
            seminars.add(newSeminar);
        }
        int splitValue = calculateSplitValue(seminars, splitOnX);

        InternalNode newNode =
            new InternalNode(flyweight, flyweight, splitOnX, splitValue);
        LinkedList<Seminar> leftSeminars = new LinkedList<>();
        LinkedList<Seminar> rightSeminars = new LinkedList<>();

        // First pass: distribute seminars based on split value
        for (int i = 0; i < seminars.size(); i++)
        {
            Seminar seminar = seminars.get(i);
            if (splitOnX)
            {
                if (seminar.getX() < splitValue)
                {
                    leftSeminars.add(seminar);
                }
                else
                {
                    rightSeminars.add(seminar);
                }
            }
            else
            {
                if (seminar.getY() < splitValue)
                {
                    leftSeminars.add(seminar);
                }
                else
                {
                    rightSeminars.add(seminar);
                }
            }
        }

        // Handle edge case: all seminars on one side
        if (leftSeminars.isEmpty() || rightSeminars.isEmpty())
        {
            // Adjust split value to force a more even split
            int medianIndex = seminars.size() / 2;
            Seminar medianSeminar = seminars.get(medianIndex);
            splitValue = splitOnX ? medianSeminar.getX() : medianSeminar.getY();
            newNode.setSplitValue(splitValue);
            // Redistribute seminars based on new split value
            leftSeminars = new LinkedList<>();
            rightSeminars = new LinkedList<>();
            for (int i = 0; i < seminars.size(); i++)
            {
                Seminar seminar = seminars.get(i);
                if (splitOnX)
                {
                    if (seminar.getX() <= splitValue)
                    {
                        leftSeminars.add(seminar);
                    }
                    else
                    {
                        rightSeminars.add(seminar);
                    }
                }
                else
                {
                    if (seminar.getY() <= splitValue)
                    {
                        leftSeminars.add(seminar);
                    }
                    else
                    {
                        rightSeminars.add(seminar);
                    }
                }
            }
        }

        // Ensure a more balanced split
        while (Math.abs(leftSeminars.size() - rightSeminars.size()) > 1)
        {
            if (leftSeminars.size() > rightSeminars.size())
            {
                rightSeminars.add(leftSeminars.removeLast());
            }
            else
            {
                leftSeminars.add(rightSeminars.removeLast());
            }
        }

        newNode.setLeft(
            createNodeFromSeminars(leftSeminars, !splitOnX, depth + 1));
        newNode.setRight(
            createNodeFromSeminars(rightSeminars, !splitOnX, depth + 1));

        return newNode;
    }


    private BinNode createNodeFromSeminars(
        LinkedList<Seminar> seminars,
        boolean splitOnX,
        int depth)
    {
        if (seminars.isEmpty())
        {
            return flyweight;
        }
        else if (seminars.size() <= 3)
        {
            return new LeafNode(seminars);
        }
        else
        {
            return createInternalNodeWithSeminars(
                seminars,
                null,
                splitOnX,
                depth);
        }
    }


    private
        int
        calculateSplitValue(LinkedList<Seminar> seminars, boolean splitOnX)
    {
        if (seminars.isEmpty())
        {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < seminars.size(); i++)
        {
            Seminar seminar = seminars.get(i);
            int value = splitOnX ? seminar.getX() : seminar.getY();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        return (min + max) / 2;
    }


    public Seminar search(int x, int y, int radius)
    {
        resetNodesVisited();
        Seminar result =
            searchHelper(root, x, y, 0, 0, 0, worldSize - 1, worldSize - 1);

        if (result != null)
        {
            System.out.println("Seminars within 1 units of (" + x + ", " + y + ")");
            System.out.println(
                "ID: " + result.getId() + ", Title: " + result.title());
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
        int depth)
    {

        nodesVisited++;

        int n = depth + 1;
        int k = width / 2;
        int l = height / 2;
        // Base case: node is an empty node
        if (node instanceof EmptyNode)
        {
            return null; // Nothing found
        }

        // Base case: node is a leaf node
        if (node instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();
            // Loop through seminars to find a matching one
            for (int i = 0; i < seminars.size(); i++)
            {
                Seminar seminar = seminars.get(i);
                if (seminar.getX() == x && seminar.getY() == y)
                {
                    return seminar; // Found the matching seminar
                }
            }
            return null; // No match found
        }

        // Recursive case: node is an internal node
        if (node instanceof InternalNode)
        {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Determine if we are splitting on X or Y
            if (depth % 2 == 0)
            {
                // Split on X, calculate X midpoint
                midPoint = (nodeX + width) / 2;

                // Go left if the target X is less than the midpoint
                if (x < midPoint)
                {
                    return searchHelper(
                        internal.getLeft(),
                        x,
                        y,
                        nodeX,
                        nodeY,
                        k,
                        height,
                        n);
                }
                // Go right if the target X is greater than or equal to the
                // midpoint
                else
                {
                    return searchHelper(
                        internal.getRight(),
                        x,
                        y,
                        midPoint,
                        nodeY,
                        k,
                        height,
                        n);
                }
            }
            else
            {
                // Split on Y, calculate Y midpoint
                midPoint = (nodeY + height) / 2;

                // Go left if the target Y is less than the midpoint
                if (y < midPoint)
                {
                    return searchHelper(
                        internal.getLeft(),
                        x,
                        y,
                        nodeX,
                        nodeY,
                        width,
                        l,
                        n);
                }
                // Go right if the target Y is greater than or equal to the
                // midpoint
                else
                {
                    return searchHelper(
                        internal.getRight(),
                        x,
                        y,
                        nodeX,
                        midPoint,
                        width,
                        l,
                        n);
                }
            }
        }

        return null; // Fallback case (shouldn't happen)
    }


    public void delete(int x, int y)
    {
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
        int depth)
    {

        int n = depth + 1;
        int w = width / 2;
        int h = height / 2;

        // If node is empty, return as is
        if (node instanceof EmptyNode)
        {
            return node;
        }

        // If node is a leaf, check if the seminar matches, and delete if found
        if (node instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();

            // Iterate through seminars and remove the one matching the x and y
            // coordinates
            for (int i = 0; i < seminars.size(); i++)
            {
                Seminar seminar = seminars.get(i);
                if (seminar.getX() == x && seminar.getY() == y)
                {
                    seminars.remove(i);
                    // If there are no more seminars in the leaf, return an
                    // EmptyNode
                    if (seminars.isEmpty())
                    {
                        return EmptyNode.getInstance();
                    }
                    return leaf; // Return the modified leaf node if there are
                                 // still seminars left
                }
            }
            return node; // If no seminar matches, return the node as is
        }

        // If node is an internal node, we decide whether to go left or right
        if (node instanceof InternalNode)
        {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Calculate the midpoint and decide whether to go left or right
            // based on depth
            if (depth % 2 == 0)
            { // Splitting based on X
                midPoint = (nodeX + width) / 2;
                if (x < midPoint)
                {
                    // Go left, as the seminar is on the left side
                    internal.setLeft(
                        deleteHelper(
                            internal.getLeft(),
                            x,
                            y,
                            nodeX,
                            nodeY,
                            w,
                            height,
                            n));
                }
                else
                {
                    // Go right, as the seminar is on the right side
                    internal.setRight(
                        deleteHelper(
                            internal.getRight(),
                            x,
                            y,
                            midPoint,
                            nodeY,
                            w,
                            height,
                            n));
                }
            }
            else
            { // Splitting based on Y
                midPoint = (nodeY + height) / 2;
                if (y < midPoint)
                {
                    // Go left, as the seminar is on the left side
                    internal.setLeft(
                        deleteHelper(
                            internal.getLeft(),
                            x,
                            y,
                            nodeX,
                            nodeY,
                            width,
                            h,
                            n));
                }
                else
                {
                    // Go right, as the seminar is on the right side
                    internal.setRight(
                        deleteHelper(
                            internal.getRight(),
                            x,
                            y,
                            nodeX,
                            midPoint,
                            width,
                            h,
                            n));
                }
            }

            // After the deletion, check if both children are empty
            if (internal.getLeft() instanceof EmptyNode
                && internal.getRight() instanceof EmptyNode)
            {
                return EmptyNode.getInstance();
            }

            // If one child is empty, return the non-empty child to collapse the
            // tree
            if (internal.getLeft() instanceof EmptyNode)
            {
                return internal.getRight();
            }
            if (internal.getRight() instanceof EmptyNode)
            {
                return internal.getLeft();
            }

            // Return the internal node if both children are still valid
            return internal;
        }

        // Fallback case (shouldn't happen)
        return node;
    }


    public void searchInRange(int x, int y, int radius)
    {
        nodesVisited = 0;
        Seminar[] results = new Seminar[size]; // Assume size is total number of
                                               // seminars
        int[] count = new int[1]; // To keep track of results found

        // Print the initial message about the search radius and center
        System.out.println(
            "Seminars within " + radius + " units of " + x + ", " + y + ":");

        // Call the recursive search helper
        searchInRangeHelper(
            root,
            x,
            y,
            radius,
            0,
            0,
            worldSize,
            worldSize,
            radius,
            results,
            count);

        // If no seminars found, print that no records were found
        if (count[0] == 0)
        {
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
        int[] count)
    {

        int n = depth + 1;
        int w = width / 2;
        int h = height / 2;
        nodesVisited++; // Count the number of nodes visited

        if (node instanceof EmptyNode)
        {
            return; // If node is empty, exit
        }

        // Check if the search circle intersects with the node's bounding box
        if (!intersects(
            x,
            y,
            radius,
            nodeX,
            nodeY,
            nodeX + width,
            nodeY + height))
        {
            return;
        }

        // Process leaf nodes (actual seminar data)
        if (node instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();

            // Loop through seminars in this leaf node and check if they're
            // within range
            for (int i = 0; i < seminars.size(); i++)
            {
                Seminar seminar = seminars.get(i);
                if (inRange(seminar.getX(), seminar.getY(), x, y, radius))
                {
                    System.out.println(
                        "Found a record with key value " + seminar.getId()
                            + " at " + seminar.getX() + ", " + seminar.getY());
                    results[count[0]++] = seminar; // Add seminar to results
                                                   // array
                }
            }
            return;
        }

        // Process internal nodes (recursive traversal through the tree)
        if (node instanceof InternalNode)
        {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Split based on depth (even -> X, odd -> Y)
            if (depth % 2 == 0)
            { // Splitting on X
                midPoint = (nodeX + width) / 2;

                // Recursively search left and right children based on the
                // x-coordinate
                searchInRangeHelper(
                    internal.getLeft(),
                    x,
                    y,
                    radius,
                    nodeX,
                    nodeY,
                    w,
                    height,
                    n,
                    results,
                    count);
                searchInRangeHelper(
                    internal.getRight(),
                    x,
                    y,
                    radius,
                    midPoint,
                    nodeY,
                    w,
                    height,
                    n,
                    results,
                    count);

            }
            else
            { // Splitting on Y
                midPoint = (nodeY + height) / 2;

                // Recursively search left and right children based on the
                // y-coordinate
                searchInRangeHelper(
                    internal.getLeft(),
                    x,
                    y,
                    radius,
                    nodeX,
                    nodeY,
                    width,
                    h,
                    n,
                    results,
                    count);
                searchInRangeHelper(
                    internal.getRight(),
                    x,
                    y,
                    radius,
                    nodeX,
                    midPoint,
                    width,
                    h,
                    n,
                    results,
                    count);
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
        int nodeHeight)
    {

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
    private
        boolean
        inRange(int seminarX, int seminarY, int x, int y, int radius)
    {
        int dx = seminarX - x;
        int dy = seminarY - y;
        return (dx * dx + dy * dy) <= (radius * radius);
    }


    public int getNodesVisited()
    {
        return nodesVisited;
    }


    public void resetNodesVisited()
    {
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
    public int increment(int i)
    {
        return i += 1;
    }


    public void printTree()
    {
        System.out.println("Location Tree:");
        if (root == flyweight)
        {
            System.out.println("E");
        }
        else
        {
            root.print(calculateHeight(root));
        }
    }


    private int calculateHeight(BinNode node)
    {
        if (node == null || node instanceof EmptyNode)
        {
            return 0;
        }

        return 1 + Math.max(
            calculateHeight(node.getLeft()),
            calculateHeight(node.getRight()));
    }

    // private void rebalanceTree() {
    // LinkedList<Seminar> allSeminars = new LinkedList<>();
    // collectAllSeminars(root, allSeminars);
    // root = createNodeFromSeminars(allSeminars, true, 0);
    // }

// private void collectAllSeminars(BinNode node, LinkedList<Seminar> seminars) {
// if (node instanceof LeafNode) {
// LeafNode leaf = (LeafNode) node;
// LinkedList<Seminar> leafSeminars = leaf.getSeminars();
// for (int i = 0; i < leafSeminars.size(); i++) {
// seminars.add(leafSeminars.get(i));
// }
// } else if (node instanceof InternalNode) {
// InternalNode internal = (InternalNode) node;
// collectAllSeminars(internal.getLeft(), seminars);
// collectAllSeminars(internal.getRight(), seminars);
// }
// }

}
