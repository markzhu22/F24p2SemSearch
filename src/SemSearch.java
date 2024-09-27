
/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author {Your Name Here}
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

public class SemSearch {
    /**
     * @param args
     *            Command line parameters
     */
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.out.println(
                "Usage: java SemSearch <worldSize> <commandFile>");
            return;
        }

        try {
            int worldSize = Integer.parseInt(args[0]);
            Controller controller = new Controller(worldSize);

            @SuppressWarnings("unused")
            CommandProcessor commandProcessor = new CommandProcessor(args[1],
                controller);

        }
        catch (NumberFormatException e) {
            System.out.println(
                "Invalid number format for worldSize. Please provide an integer.");
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
