class NegativeAmountException extends Exception
{
    NegativeAmountException()
    {
        super();
    }
    NegativeAmountException(String message) { super(message); }

    @Override
    public String toString() { return "BALANCE CAN NOT BE NEGATIVE!"; }
}
class MinimumBalanceException extends Exception
{
    MinimumBalanceException() {super();}
    MinimumBalanceException(String message) {super(message);}

    @Override
    public String toString() { return "BALANCE BELOW MINIMUM AMOUNT!"; }
}

///////////////////////////////////////////////////////////////////////////////////////////////

class Account 
{
    private final String name;
    private final int accno;
    private float balance;

    Account()
    {
        name=null;
        accno=0;
        balance=0.0f;
    }
    Account(String name, int accno, float balance) throws NegativeAmountException, MinimumBalanceException 
    {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Account name cannot be empty!");
        if (balance < 0) throw new NegativeAmountException();
        if (balance < 1000) throw new MinimumBalanceException();

        this.name = name;
        this.accno = accno;
        this.balance = balance;
    }

    void withdraw(float cash) throws NegativeAmountException, MinimumBalanceException
    {
        if (cash < 0) throw new NegativeAmountException();
        if (balance - cash < 1000) throw new MinimumBalanceException();
        balance -= cash;
    }

    void deposite(float amount) throws NegativeAmountException 
    {
        if (amount < 0) throw new NegativeAmountException();
        balance += amount;
    }

    void show() 
    {
        System.out.println("Account Holder name:- "+name);
        System.out.println("Account Number:- "+accno);
        System.out.println("Accont balance:- "+balance);
    }
}

//////////////////////////////////////////////////////////////////////////////

class Account_Exception
{
    public static void main(String[] args)
    {
        try
        {
            Account a = new Account("Ram",121,1050);
            a.show();
            a.deposite(200);
            a.withdraw(1600);
            a.show();
        }
        catch(MinimumBalanceException e)
        {
            System.out.println(e.toString());
        }
        catch(NegativeAmountException e)
        {
            System.out.println(e.toString());
        }
    }
}