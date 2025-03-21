import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.String;
import java.sql.SQLException;


public class DemoStatementAddBatch 
{
    private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String username = "HR";
    private static final String password = "hr";
    public static void main(String[] args) 
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Unable to load driver class!");
            System.out.println(e.getMessage());;
        }

        try
        {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to Oracle Database!");

            Scanner sc = new Scanner(System.in);
            Statement st = con.createStatement();
            while(true)
            {
                System.out.print("Enter the Aadharno:-");
                int id = sc.nextInt();
                sc.nextLine();   //consumes new line
                System.out.print("Enter Name:-");
                String name = sc.nextLine();
                System.out.print("Enter dob in dd/mm/yyyy format:-");
                String dob = sc.next();

                String query = String.format("INSERT INTO Aadhar(id,name,dob) VALUES(%d,'%s',TO_DATE('%s','dd/mm/yyyy'))",id,name,dob);

                st.addBatch(query);

                System.out.println("Want to enter more data type Y/y:-");
                String choice = sc.next();
                if(choice.toUpperCase().equals("N")) break;
            }
            int[] arr = st.executeBatch();
            for(int i=0; i<arr.length; i++)
                if(arr[i]==0) System.out.println("Query "+i+" not Executed!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
