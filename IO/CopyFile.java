import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyFile 
{
    public static void main(String[] args) 
    {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // Check if two arguments (source and destination file paths) are provided
        if (args.length != 2) 
        {
            System.out.println("Usage: java ShowFile <source file> <destination file>");
            return;
        }

        try 
        {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do 
            {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) 
        {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) 
        {
            System.out.println("Error reading or writing file: " + e.getMessage());
        } finally 
        {
            try 
            {
                if (fin != null) fin.close();
                if (fout != null) fout.close();
            } catch (IOException e)
            {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
