import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBCExample 
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

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
