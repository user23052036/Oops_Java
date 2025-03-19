import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ReadFile
{
    public static void main(String x[])
    {
        int i;
        FileInputStream fin;

        try{fin = new FileInputStream("Data.txt");}
        catch(FileNotFoundException e)
        {
            System.out.println("File not found exception");
            return;
        }

        try
        {
            do
            {
                i=fin.read();
                System.out.print((char)i);
            }
            while(i != -1);
        }
        catch(IOException e)
        {System.out.println("Reading file error");}

        try
        {fin.close();}
        catch(IOException e)
        {System.out.println("File closing error");}
    }
}