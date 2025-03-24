import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;

public class DemoPreparedStatementAddBatch 
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

            String query = "INSERT INTO Aadhar(id,name,dob) VALUES(?,?,TO_DATE(?,'dd/mm/yyyy'))";
            PreparedStatement pst = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            while(true)
            {
                System.out.println("Enter aadhar no:-");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name:-");
                String name = sc.nextLine();
                System.out.println("Enter dob(dd/mm/yyyy):-");
                String dob = sc.next();

                pst.setInt(1, id);
                pst.setString(2, name);
                pst.setString(3, dob);

                pst.addBatch();

                System.out.println("Want to enter more data type Y/y:-");
                String choice = sc.next();
                if(choice.toUpperCase().equals("N")) break;
            }
            sc.close();

            int[] arr = pst.executeBatch();
            for(int i=0; i<arr.length; i++)
                if(arr[i]==0) System.out.println("Query "+i+" is error!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
