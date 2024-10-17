public class BinTree
{
    private BinNode root;
    private int size;
    private int nodesVisited;
    private final int worldSize;
    private static final EmptyNode flyweight = EmptyNode.getInstance();

    public BinTree(int worldSize)
    {
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
            if (leaf.getSeminar().x() == seminar.x() && leaf.getSeminar().y() == seminar.y()) {
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
                                plus(depth,1),
                                x,
                                y,
                                minus(splitValue, x),
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
                                minus(width, minus(splitValue, x)),
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
                                minus(splitValue,y)));
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
                                minus(height, minus(splitValue, y))));
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
                            minus(splitValue,x),
                            height));
                }
                else
                {
                    internal.setRight(
                        insertHelper(
                            internal.getRight(),
                            seminar,
                            plus(depth, 1),
                            splitValue,
                            y,
                            minus(width, minus(splitValue,x)),
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
                            minus(splitValue, y)));
                }
                else
                {
                    internal.setRight(
                        insertHelper(
                            internal.getRight(),
                            seminar,
                            plus(depth, 1),
                            x,
                            splitValue,
                            width,
                            minus(height, minus(splitValue,y))));
                }
            }
            return internal;
        }

        // This should never happen
        return flyweight;
    }


    public void search(int x, int y, int radius)
    {
        searchHelper(root, x, y, radius, 0, 0, 0, minus(worldSize, 1), worldSize - 1);
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
        int yMax)
    {

        nodesVisited++;

        // Base case: node is an empty node
        if (node instanceof EmptyNode)
        {
            return; // Nothing found
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
                if (inRange(
                    seminar.getX(),
                    seminar.getY(),
                    targetX,
                    targetY,
                    radius))
                {
                    System.out.println(
                        "Found a record with key value " + seminar.id() + " at "
                            + seminar.x() + ", " + seminar.y());
                }
            }
            return;
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
                midPoint = xMin + xMax / 2;

                // Go left if the target X is less than the midpoint
                if (targetX + radius < midPoint || targetX - radius < midPoint)
                {
                    searchHelper(
                        internal.getLeft(),
                        targetX,
                        targetY,
                        radius,
                        depth + 1,
                        xMin,
                        yMin,
                        midPoint,
                        yMax);
                }
                // Go right if the target X is greater than or equal to the
                // midpoint
                if (targetX + radius >= midPoint
                    || minus(targetX,radius) >= midPoint)
                {
                    searchHelper(
                        internal.getRight(),
                        targetX,
                        targetY,
                        radius,
                        depth + 1,
                        midPoint,
                        yMin,
                        xMax,
                        yMax);
                }
            }
            else
            {
                // Split on Y, calculate Y midpoint
                midPoint = yMin + yMax / 2;

                // Go left if the target Y is less than the midpoint
                if (plus(targetY, radius) < midPoint || minus(targetY, radius) < midPoint)
                {
                    searchHelper(
                        internal.getLeft(),
                        targetX,
                        targetY,
                        radius,
                        depth + 1,
                        xMin,
                        yMin,
                        xMax,
                        midPoint);
                }
                // Go right if the target Y is greater than or equal to the
                // midpoint
                if (targetY + radius >= midPoint
                    || minus(targetY, radius) >= midPoint)
                {
                    searchHelper(
                        internal.getRight(),
                        targetX,
                        targetY,
                        radius,
                        plus(depth, 1),
                        xMin,
                        midPoint,
                        xMax,
                        yMax);
                }
            }
        }

        return;
    }


    public void delete(int targetX, int targetY, int id)
    {
        deleteHelper(
            root,
            id,
            targetX,
            targetY,
            0,
            0,
            worldSize - 1,
            minus(worldSize,1),
            0);
        if (root.isLeaf()) {
            LeafNode temp = (LeafNode)root;
            if (temp.getSeminars().isEmpty()) {
                root = flyweight;
            }
        }
    }


    private BinNode deleteHelper(
        BinNode node,
        int id,
        int targetX,
        int targetY,
        int xMin,
        int yMin,
        int xMax,
        int yMax,
        int depth)
    {

        // If node is empty, return as is
        if (node instanceof EmptyNode)
        {
            return null;
        }

        // If node is a leaf, check if the seminar matches, and delete if found
        else if (node instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode)node;
            LinkedList<Seminar> seminars = leaf.getSeminars();

            // Iterate through seminars and remove the one matching the x and y
            // coordinates
            for (int i = 0; i < seminars.size(); i++)
            {
                Seminar seminar = seminars.get(i);
                
                if (seminar.id() == id && seminar.getX() == targetX && seminar.getY() == targetY)
                {
                    seminars.remove(i);
                    size--;
                    i--;
                    // If there are no more seminars in the leaf, return an
                    // EmptyNode
                    if (seminars.isEmpty())
                    {
                        return flyweight;
                    }
                }
            }
        }

        // If node is an internal node, we decide whether to go left or right
        else if (node instanceof InternalNode)
        {
            InternalNode internal = (InternalNode)node;
            int midPoint;

            // Calculate the midpoint and decide whether to go left or right
            // based on depth
            if (depth % 2 == 0)
            { // Splitting based on X
                midPoint = plus(xMin, xMax) / 2;

                // Go left if the target X is less than the midpoint
                if (targetX < midPoint)
                {
                    BinNode result = deleteHelper(internal.getLeft(), id, targetX, targetY, xMin, midPoint, yMin, xMax, depth+1);
                    if (result == flyweight) {
                        // These doesn't work for some reason
                        node = internal.getRight();
                    }
                }
                else {
                    BinNode result = deleteHelper(internal.getRight(), id, targetX, targetY, midPoint, xMax, yMin, xMax, plus(depth,1));
                    if (result == flyweight) {
                        node = internal.getLeft();
                    }
                }
            }
            else {
                midPoint = plus(yMin, yMax) / 2;
                if (targetY < midPoint)
                {
                    BinNode result = deleteHelper(internal.getLeft(), id, targetX, targetY, xMin, xMax, yMin, midPoint, depth+1);
                    if (result == flyweight) {
                        node = internal.getRight();
                    }
                }
                else {
                    BinNode result = deleteHelper(internal.getRight(), id, targetX, targetY, xMin, xMax, midPoint, yMax, plus(depth,1));
                    if (result == flyweight) {
                        node = internal.getLeft();
                    }
                }
            }
        }
        return null;
    }


    // Check if the seminar is within the radius
    private boolean inRange(int seminarX, int seminarY, int x, int y, int radius)
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

        return plus(1, Math.max(
            calculateHeight(node.getLeft()),
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
