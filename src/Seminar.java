import java.util.Scanner;
/**
 * Seminar class with getter methods for key fields. There is probably no
 * good reason why you would want to modify this class for your project.
 *
 * @author CS3114/CS5040 staff
 * @version July 2023, last updated September 2023
 */

public class Seminar {
    private String title; // Seminar title
    private String date; // Seminar date
    private int length; // Seminar length
    private short x; // Seminar x coord
    private short y; // Seminar y coord
    private String desc; // Seminar description
    private int cost; // Seminar cost
    private int id; // Seminar ID
    private BinTree binTree;
    private String[] keywords;
    private ArrayList<String> keywordList;

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
        Scanner scanner,
        String descin) {
        
        id = idin;
        title = tin;
        date = datein;
        length = lin;
        x = xin;
        y = yin;
        cost = cin;
        desc = descin;
        this.binTree = new BinTree();
        this.keywordList = new ArrayList<>();

        // Read keywords from scanner
        while (scanner.hasNext()) {
            String keyword = scanner.next();
            if (keyword.equals("ENDKEYWORDS")) {
                break;
            }
            keywordList.add(keyword);
        }

        // Convert ArrayList to array
        this.keywords = new String[keywordList.size()];
        Object[] tempArray = keywordList.toArray();
        for (int i = 0; i < tempArray.length; i++) {
            this.keywords[i] = (String) tempArray[i];
        }
    }


    public String title() {
        return title;
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


    /**
     * Return the seminar keywords
     * 
     * @return the keywords field for the seminar
     */
    public void setKeywords(List<String> keywords) {
        this.keywordList = new ArrayList<String>();
        updateKeywordsArray();
    }

public String[] Keywords() {
        return this.keywords;
    }

    public void addKeyword(String keyword) {
        if (this.keywordList == null) {
            this.keywordList = new ArrayList<>();
        }
        this.keywordList.add(keyword);
        updateKeywordsArray();
    }

    public boolean hasKeyword(String keyword) {
        return keywordList != null && keywordList.contains(keyword);
    }

    private void updateKeywordsArray() {
        this.keywords = new String[keywordList.size()];
        Object[] tempArray = keywordList.toArray();
        for (int i = 0; i < tempArray.length; i++) {
            this.keywords[i] = (String) tempArray[i];
        }
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


    public String desc() {
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
        StringBuilder mykeys = new StringBuilder();
        for (int i = 0; i < keywords.length; i++) {
            mykeys.append(keywords[i]);
            if (i < keywords.length - 1) {
                mykeys.append(", ");
            }
        }
        
        return String.format("ID: %d, Title: %s\nDate: %s, Length: %d, X: %d, Y: %d, Cost: %d\n" +
                             "Description: %s\nKeywords: %s",
                             id, title, date, length, x, y, cost, desc, mykeys.toString());
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setX(int x) {
        this.x = (short)x;
    }


    public void setY(int y) {
        this.y = (short)y;
    }


    public int getId() {
        return this.id;
    }


    public double getX1() {
        return this.x;
    }


    public double getY1() {
        return this.y;
    }

}
