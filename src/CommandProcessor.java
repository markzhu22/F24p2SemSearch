import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandProcessor
{
    private Scanner scanner;
    private Controller control;

    public CommandProcessor(String file, Controller controller) {
        try {
         // File Processing
            scanner = new Scanner(new File(file));
            control = controller;
            
            while (scanner.hasNext())
            {
                String cmd = scanner.nextLine().trim();
                // Check insert
                if (cmd.matches("insert(.*)"))
                {
                    int id = Integer.parseInt(cmd.split(" ")[1]);
                    
                    //control.insert();
                    System.out.print(id);
                }
                
                // Check remove
                else if (cmd.matches("remove(.*)"))
                {
                    //control.remove();
                }

                // Check print
                else if (cmd.matches("print(.*)"))
                {
                    //control.print();
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
