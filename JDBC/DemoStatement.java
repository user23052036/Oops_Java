import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

class DemoStatement
{
    private static final String jdbcURL="jdbc:oracle:thin:@localhost:1521:XE";
    private static final String user="HR";
    private static final String password="hr";

    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("oracle JDBC driver loaded and regsitered");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try
        {
            Connection con = DriverManager.getConnection(jdbcURL,user,password);
            System.out.println("Established connections with the database");

            Statement st = con.createStatement();

            String dob = "11-09-2010";
            String query = String.format("INSERT INTO Aadhar(id,name,dob) VALUES(%d,'%s',TO_DATE('%s','dd-mm-yyyy'))",191,"Sonu",dob);
            
            int effRow = st.executeUpdate(query);
            if(effRow>0)System.out.println("updated successfully");
            else System.out.println("updation failed");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    } 
}