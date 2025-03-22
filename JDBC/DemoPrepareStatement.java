import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DemoPrepareStatement
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

            String query="INSERT INTO Aadhar(id,name,dob) VALUES(?,?,TO_DATE(?,'dd-mm-yyyy'))";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,192);
            pst.setString(2, "Sagnik Mandal");
            pst.setString(3,"22-11-2003");
            
            int effRow = pst.executeUpdate();
            if(effRow>0)System.out.println("updated successfully");
            else System.out.println("updation failed");

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
