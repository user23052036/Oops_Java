import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

class WriteFile
{
    public static void main(String args[])
    {
        int i=0;
        FileInputStream fin;
        FileOutputStream fout;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name:-");
        String name=sc.nextLine();
        System.out.print("Enter roll no:-");
        int roll=sc.nextInt();
        System.out.print("Marks:-");
        int marks=sc.nextInt();

        try
        {
            fin = new FileInputStream("Data.txt");
            fout = new FileOutputStream("Data.txt");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FileNot found");
            return;
        }

        try
        {
            do
            {
                fout.write(name.charAt(i));
                i++;
            }while(i<name.length()); 
            fout.write('\n');

            i = 0;
            String rollStr = Integer.toString(roll);
            do {
                fout.write(rollStr.charAt(i));
                i++;
            } while (i < rollStr.length());
            fout.write('\n');

            String marksStr = Integer.toString(marks);
            i = 0;
            do {
                fout.write(marksStr.charAt(i));
                i++;
            } while (i < marksStr.length());
            fout.write('\n');
        }
        catch(IOException e)
        {System.out.println("Error occured during writting into file\n");}


        //reading the file
        System.out.println("Content inside the Data.txt is");
        try
        {
            do
            {
                ;
                System.out.print((char)i);
            }while((i=fin.read()) != -1);
        }
        catch(IOException e)
        {System.out.println("Error occured during reading into file\n");}

        finally
        {
            try
            {
                if(fin!=null) fin.close();
                if(fout!=null) fout.close();
            }
            catch(IOException e)
            {System.out.println("Error occured during closing of file");}
        }
    }
}