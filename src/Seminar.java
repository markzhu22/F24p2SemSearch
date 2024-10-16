/**
 * Seminar class with getter methods for key fields. There is probably no
 * good reason why you would want to modify this class for your project.
 *
 * @author CS3114/CS5040 staff
 * @version July 2023, last updated September 2023
 */

public class Seminar {
    private String title; // Semianar title
    private String date; // Seminar date
    private int length; // Seminar length
    private String[] keywords; // Seminar keywords
    private short x; // Seminar x coord
    private short y; // Seminar y coord
    private String desc; // Seminar description
    private int cost; // Seminar cost
    private int id; // Seminar ID
    private BinTree binTree;

    // ----------------------------------------------------------
    /**
     * Dummy seminar constructor
     */
    public Seminar() {
        // Nothing here
    }


    /**
     * Create a new Seminar object from the field data
     *
     * @param tin
     *            input title
     * @param datein
     *            input date
     * @param lin
     *            input length
     * @param kin
     *            input keywords
     * @param xin
     *            input x coord
     * @param yin
     *            input y coord
     * @param descin
     *            input description
     * @param cin
     *            input cost
     * @param idin
     *            input ID
     */
    public Seminar(
        int idin,
        String tin,
        String datein,
        int lin,
        short xin,
        short yin,
        int cin,
        String[] kin,
        String descin) {
        id = idin;
        title = tin;
        date = datein;
        length = lin;
        x = xin;
        y = yin;
        cost = cin;
        keywords = kin;
        desc = descin;
        // this.binTree = new BinTree(id);
    }


    public String title() {
        return title;
    }


    public void setBinTree(BinTree tree) {
        this.binTree = tree;
    }


    // ----------------------------------------------------------
    /**
     * Returns the seminar ID field
     * 
     * @return the ID field for the seminar
     */
    public int id() {
        return id;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar date
     * 
     * @return the date field for the seminar
     */
    public String date() {
        return date;
    }


    public int length() {
        return length;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar date
     * 
     * @return the date field for the seminar
     */
    public int cost() {
        return cost;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar keywords
     * 
     * @return the keywords field for the seminar
     */
    public String[] keywords() {
        return keywords;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar x coordinate
     * 
     * @return the x coordinate field for the seminar
     */
    public int x() {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar y coordinate
     * 
     * @return the y coordinate field for the seminar
     */
    public int y() {
        return y;
    }


    public String description() {
        return desc;
    }


    public short getX() {
        return x;
    }


    public short getY() {
        return y;
    }


    public BinTree getBinTree() {
        return binTree;
    }


    /**
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(", ");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Date: ").append(date).append(", ");
        sb.append("Length: ").append(length).append(", ");
        sb.append("X: ").append(x).append(", ");
        sb.append("Y: ").append(y).append(", ");
        sb.append("Cost: ").append(cost).append("\n");
        sb.append("Description: ").append(description()).append("\n");
        sb.append("Keywords: ");
        if (keywords != null) {
            sb.append(String.join(", ", keywords));
        }
        else {
            sb.append("None");
        }
        return sb.toString();
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setX(double x) {
        this.x = (short)x;
    }


    public void setY(double y) {
        this.y = (short)y;
    }


    public int getId() {
        return this.id;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public void setLength(int length) {
        this.length = length;
    }


    public void setKeywords(String[] keywords) {
        this.keywords = (keywords != null) ? keywords : new String[0];
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    // Update the existing setX and setY methods to use short instead of double
    public void setX(short x) {
        this.x = x;
    }


    public void setY(short y) {
        this.y = y;
    }


    public void setDescription(String description) {
        this.desc = description;
    }


    public void add(Seminar seminar) {
        if (seminar == null) {
            System.out.println("Cannot add null seminar");
            return;
        }

    }


    public String size() {
        // TODO Auto-generated method stub
        return null;
    }


    

}
