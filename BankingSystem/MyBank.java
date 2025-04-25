import java.util.Scanner;
public class MyBank 
{
    private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String username = "HR";
    private static final String password = "hr";

    public static void main(String args[])
    {
        while(true)
        {
            System.out.println("\n\n*** WELCOME TO OUR BANK ***");
            System.out.println("choose any of the below options");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                {}
                case 2:
                {}
                case 3:
                {
                    System.out.println("THANK YOU FOR USING BANKING SYSTEM!!!");
                    System.out.println("Exiting System!");
                    return;
                }
            }
        }
    }
}
