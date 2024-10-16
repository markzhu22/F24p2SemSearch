import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Command processing for the SemSearch Project
 * 
 * @author markz + tarinid
 * @version Oct 7, 2024
 */
public class CommandProcessor
{
    private Scanner scanner;
    private Controller control;

    /**
     * CommandProcessor object
     * 
     * @param file
     *            Input file controller
     * @param controller
     *            The controller object to call the commands
     */
    public CommandProcessor(String file, Controller controller)
    {
        try
        {
            // File Processing
            scanner = new Scanner(new File(file));
            control = controller;

            while (scanner.hasNext())
            {
                String cmd = scanner.nextLine().trim();
                // Check insert
                if (cmd.matches("insert(.*)"))
                {
                    int id = Integer.parseInt(cmd.split("\\s+")[1]);
                    String title = scanner.nextLine().trim();
                    String[] numbers = scanner.nextLine().trim().split("\\s+");
                    String date = numbers[0];
                    int length = Integer.parseInt(numbers[1]);
                    short x = Short.parseShort(numbers[2]);
                    short y = Short.parseShort(numbers[3]);
                    int cost = Integer.parseInt(numbers[4]);
                    cmd = scanner.nextLine().trim();
                    String[] keywords = cmd.split("\\s+");
                    cmd = scanner.nextLine().trim();
                    String description = cmd;
                    Seminar newSem = new Seminar(
                        id,
                        title,
                        date,
                        length,
                        x,
                        y,
                        cost,
                        keywords,
                        description);
                    control.insert(newSem);
                }

                // Check remove
                else if (cmd.startsWith("delete"))
                {
                    int id = Integer.parseInt(cmd.split("\\s+")[1]);
                    control.delete(id);
                }

                // Check print
                else if (cmd.matches("print(.*)"))
                {
                    String kywd = cmd.split("\\s+")[1];
                    control.print(kywd);
                }

                else if (cmd.matches("search(.*)"))
                {
                    String kywd = cmd.split("\\s+")[1];

                    switch (kywd)
                    {
                        case "ID":
                            control.searchById(
                                Integer.parseInt(cmd.split("\\s+")[2]));
                            break;
                        case "date":
                            control.searchByDateRange(
                                cmd.split("\\s+")[2],
                                cmd.split("\\s+")[3]);
                            break;
                        case "cost":
                            control.searchByCostRange(
                                Integer.parseInt(cmd.split("\\s+")[2]),
                                Integer.parseInt(cmd.split("\\s+")[3]));
                            break;
                        case "keyword":
                            control.searchByKeyword(cmd.split("\\s+")[2]);
                            break;
                        case "location":
                            int x = Integer.parseInt(cmd.split("\\s+")[2]);
                            int y = Integer.parseInt(cmd.split("\\s+")[3]);
                            control.searchByLocation(x, y);
                            break;
                        default:
                            System.out.println("Invalid keyword");
                    }
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
