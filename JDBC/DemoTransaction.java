import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Exception Classes
//----------------------------------------------------------------------------------------------------

class MinimumBalanceException extends Exception
{
    MinimumBalanceException(){super();}

    public String toString()
    {
        return "MINIMUMBALANCE EXCEPTION!";
    }
}
class AccountNotFoundException extends Exception
{
    AccountNotFoundException(String message)
    {super(message);}

    public String toString()
    {
        return "INVALID CREDENTIALS"+getMessage();
    }
}
//--------------------------------------------------------------------------------------------------


public class DemoTransaction 
{
    private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String username = "HR";
    private static final String password = "hr";


    //------------------------------------------------------------------------------------------------

    static void validate_sender(Connection con, int acc_no) throws AccountNotFoundException
    {
        String query = "SELECT balance FROM Account WHERE acc_no = ?";
        try 
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, acc_no);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {} 
            else 
            {
                String excep_mess = String.format("%d not found in the DATABASE!",acc_no);
                throw new AccountNotFoundException(excep_mess);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    static void validate_sender(Connection con, int acc_no,String name) throws AccountNotFoundException
    {
        String query = "SELECT balance FROM Account WHERE acc_no = ? and UPPER(name) = UPPER(?)";
        try 
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, acc_no);
            pst.setString(2, name);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {} 
            else 
            {
                String excep_mess = String.format("%d does not match with '%s'",acc_no,name);
                throw new AccountNotFoundException(excep_mess);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    static void validate_sender(Connection con, int acc_no, String name, int amount) throws AccountNotFoundException,MinimumBalanceException
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
                System.out.println("Sender details validated successfully.");
                int balance = rs.getInt("balance");

                if(balance<amount) throw new MinimumBalanceException();

                System.out.println("Balance found on " + name + "'s account = " + balance);
                System.out.println(amount+" is send current balance is "+(balance-amount));
            } 
            else 
            {
                String excep_mess = String.format("%d does not match with '%s'",acc_no,name);
                throw new AccountNotFoundException(excep_mess);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    //-------------------------------------------------------------------------------------------------------


    static void validate_receiver(Connection con, int acc_no) throws AccountNotFoundException
    {
        String query = "SELECT acc_no FROM Account WHERE acc_no = ? AND UPPER(name) = UPPER(?)";
        try 
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, acc_no);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {} 
            else
            {
                String excep_mess = String.format("%d Not Found In DATABASE!",acc_no);
                throw new AccountNotFoundException(excep_mess);
            } 

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    static void validate_receiver(Connection con, int acc_no, String name) throws AccountNotFoundException
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
            } 
            else
            {
                String excep_mess = String.format("%d does not match with '%s'",acc_no,name);
                throw new AccountNotFoundException(excep_mess);
            } 

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
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

            con.setAutoCommit(false); 

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
                validate_sender(con, s_acc_no);

                System.out.print("Enter Name:-");
                String s_name = sc.nextLine();
                validate_sender(con, s_acc_no, s_name);

                System.out.print("Enter send amount:-");
                int s_amount = sc.nextInt();
                sc.nextLine();
                validate_sender(con,s_acc_no,s_name,s_amount);

                System.out.println("--------------:Enter account details of the Receiver:-------------");
                System.out.print("Enter acc number:-");
                int r_acc_no = sc.nextInt();
                sc.nextLine();
                validate_receiver(con, r_acc_no);

                System.out.print("Enter Name:-");
                String r_name = sc.nextLine();
                validate_receiver(con, r_acc_no,r_name);

                
                s_pst.setInt(1, s_amount);
                s_pst.setInt(2, s_acc_no);
                r_pst.setInt(1, s_amount);
                r_pst.setInt(2, r_acc_no);


                s_pst.executeUpdate();
                r_pst.executeUpdate();
                con.commit();
                System.out.println(".....[[[[Transaction Successull]]]].....");
                System.out.println("money send "+s_amount+" from "+s_name+" to "+r_name);

                con.rollback();
                System.out.println("Transaction has failed!");

                System.out.print("Want to perform any more transaction(y/Y)?:-");
                String choice = sc.next();
                if(choice.toUpperCase().equals("N")) break;
            }
            sc.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
