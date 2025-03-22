import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoTransaction 
{
    private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String username = "HR";
    private static final String password = "hr";


    static boolean validate_sender(Connection con, int acc_no, String name, int amount) 
    {
        String query = "SELECT balance FROM Account WHERE acc_no = ? AND UPPER(name) = UPPER(?)";
        try 
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, acc_no);
            pst.setString(2, name);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) 
            {
                int balance = rs.getInt("balance");
                System.out.println("Balance found for acc_no " + acc_no + ": " + balance);
                return balance > 0 && amount > 0 && balance >= amount;
            } 
            else System.out.println("No account found with acc_no: " + acc_no + " and name: " + name);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return false;
    }

    static boolean validate_receiver(Connection con, int acc_no, String name) 
    {
        String query = "SELECT acc_no FROM Account WHERE acc_no = ? AND UPPER(name) = UPPER(?)";
        try 
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, acc_no);
            pst.setString(2, name);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) 
            {
                System.out.println("Receiver details validated successfully.");
                return true;
            } else System.out.println("No account found with acc_no: " + acc_no + " and name: " + name);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return false;
    }

    //----------------------------------main method-----------------------------------------
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

            con.setAutoCommit(false); // seeting auto commit to be false if transaction fails

            String query1 = "update Account set balance = balance - ? where acc_no = ?";
            String query2 = "update Account set balance = balance + ? where acc_no = ?";
            PreparedStatement s_pst = con.prepareStatement(query1);
            PreparedStatement r_pst = con.prepareStatement(query2);

            Scanner sc = new Scanner(System.in);
            while(true)
            {
                System.out.println("--------------:Enter account details of the sender:-------------");
                System.out.print("Enter acc number:-");
                int s_acc_no = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name:-");
                String s_name = sc.nextLine();
                System.out.print("Enter send amount:-");
                int s_amount = sc.nextInt();
                sc.nextLine();

                System.out.println("--------------:Enter account details of the Receiver:-------------");
                System.out.print("Enter acc number:-");
                int r_acc_no = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name:-");
                String r_name = sc.nextLine();

                s_pst.setInt(1, s_amount);
                s_pst.setInt(2, s_acc_no);
                r_pst.setInt(1, s_amount);
                r_pst.setInt(2, r_acc_no);

                if(validate_sender(con,s_acc_no,s_name,s_amount) && validate_receiver(con,r_acc_no,r_name))
                {
                    s_pst.executeUpdate();
                    r_pst.executeUpdate();
                    con.commit();
                    System.out.println("Transaction Successull");
                    System.out.println("money send "+s_amount+" from "+s_name+" to "+r_name);
                }
                else 
                {
                    con.rollback();
                    System.out.println("Transaction has failed!");
                }

                System.out.print("Want to perform any more transaction(y/Y)?:-");
                String choice = sc.next();
                if(choice.toUpperCase().equals("N")) break;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
