/**
 * Seminar class with getter methods for key fields. There is probably no good
 * reason why you would want to modify this class for your project.
 *
 * @author CS3114/CS5040 staff
 * @version July 2023, last updated September 2023
 */

public class Seminar
{
    private String title; // Semianar title
    private String date; // Seminar date
    private int length; // Seminar length
    private String[] keywords; // Seminar keywords
    private short x; // Seminar x coord
    private short y; // Seminar y coord
    private String desc; // Seminar description
    private int cost; // Seminar cost
    private int id; // Seminar ID
// private BinTree binTree;

    // ----------------------------------------------------------
    /**
     * Dummy seminar constructor
     */
    public Seminar()
    {
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
        String descin)
    {
        id = idin;
        title = tin;
        date = datein;
        length = lin;
        x = xin;
        y = yin;
        cost = cin;
        keywords = kin;
        desc = descin;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar title
     * 
     * @return the title field for the seminar
     */
    public String title()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Returns the seminar ID field
     * 
     * @return the ID field for the seminar
     */
    public int id()
    {
        return id;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar date
     * 
     * @return the date field for the seminar
     */
    public String date()
    {
        return date;
    }


    // ----------------------------------------------------------
    /**
     * Returns the length
     * 
     * @return length
     */
    public int length()
    {
        return length;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar date
     * 
     * @return the date field for the seminar
     */
    public int cost()
    {
        return cost;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar keywords
     * 
     * @return the keywords field for the seminar
     */
    public String[] keywords()
    {
        return keywords;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar x coordinate
     * 
     * @return the x coordinate field for the seminar
     */
    public int x()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar y coordinate
     * 
     * @return the y coordinate field for the seminar
     */
    public int y()
    {
        return y;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar description
     * 
     * @return the description field for the seminar
     */
    public String desc()
    {
        return desc;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar x
     * 
     * @return the x field for the seminar
     */
    public short getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Return the seminar y
     * 
     * @return the title field for the seminar
     */
    public short getY()
    {
        return y;
    }

// public BinTree getBinTree() {
// return binTree;
// }


    /**
     * Creates a string representation of the seminar
     * 
     * @return a string representation of the object.
     */
    public String toString()
    {
        int i;
        String mykeys = "";
        for (i = 0; i < keywords.length; i++)
        {
            mykeys += keywords[i];
            if (i != keywords.length - 1)
                mykeys += ", ";
        }

        return "ID: " + id + ", Title: " + title + "\nDate: " + date
            + ", Length: " + length + ", X: " + x + ", Y: " + y + ", Cost: "
            + cost + "\nDescription: " + desc + "\nKeywords: " + mykeys;
    }


    // ----------------------------------------------------------
    /**
     * Change id to the given id
     * 
     * @param id
     *            id to change to
     */
    public void setId(int id)
    {
        this.id = id;
    }


    // ----------------------------------------------------------
    /**
     * Change x to the given x
     * 
     * @param x
     *            x to change to
     */
    public void setX(double x)
    {
        this.x = (short)x;
    }


    // ----------------------------------------------------------
    /**
     * Change y to the given y
     * 
     * @param y
     *            y to change to
     */
    public void setY(double y)
    {
        this.y = (short)y;
    }


    // ----------------------------------------------------------
    /**
     * Get id of the seminar
     * 
     * @return the id
     */
    public int getId()
    {
        return this.id;
    }


    // ----------------------------------------------------------
    /**
     * Get x of the seminar
     * 
     * @return the x
     */
    public double getX1()
    {
        return this.x;
    }


    // ----------------------------------------------------------
    /**
     * Get y of the seminar
     * 
     * @return the y
     */
    public double getY1()
    {
        return this.y;
    }
}
