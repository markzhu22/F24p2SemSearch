/**
 * This class initiates the SemSearch project, reading commands from the command
 * file and processing operations related to the Seminar records. It supports
 * searching by various criteria including ID, keyword, location, and cost. The
 * location search uses a BinTree structure to handle 2D coordinates
 * efficiently.
 *
 * @author {Your Name}
 * @version {Put Something Here}
 */

// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class SemSearch
{

    /**
     * The main method to start the SemSearch program.
     * 
     * @param args
     *            Command line parameters where args[0] is the world size
     *            (integer) and args[1] is the command file path.
     */
    public static void main(String[] args)
    {
        if (args == null || args.length < 2)
        {
            System.out
                .println("Usage: java SemSearch <worldSize> <commandFile>");
            return;
        }

        try
        {
            // Parse world size
            int worldSize = Integer.parseInt(args[0]);
            if (worldSize <= 0 || (worldSize & (worldSize - 1)) != 0)
            {
                System.out
                    .println("World size must be a positive power of two.");
                return;
            }

            // Initialize controller
            Controller controller = new Controller(worldSize);

            // Initialize CommandProcessor and handle command processing within
            // its methods
            @SuppressWarnings("unused")
            CommandProcessor commandProcessor =
                new CommandProcessor(args[1], controller);

            // At this point, the commandProcessor will handle the file
            // processing
            // either inside its constructor or in a specific method

        }
        catch (NumberFormatException e)
        {
            System.out.println(
                "Invalid number format for worldSize. Please provide an "
                    + "integer.");
        }
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
