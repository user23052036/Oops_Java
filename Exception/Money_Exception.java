/* class NegativeMoneyException extends Exception
 {
	NegativeMoneyException()
 	{super();}
 	NegativeMoneyException(String message)
 	{super(message);}

 	public String toString()
 	{
 		return "CURRENCY CAN NOT BE NEGATIVE";
 	}
 }

 class Money
 {
 	int rupee,paisa;

 	Money()
 	{
 		rupee=0;
 		paisa=0;
 	}
 	Money(int rupee, int paisa) throws NegativeMoneyException
 	{
 		if(rupee<0 || paisa<0.0) throw new NegativeMoneyException();
 		this.rupee=rupee;
 		this.paisa=paisa;
 	}

 	Money Add(Money m2) throws NegativeMoneyException
 	{
 		Money m3;
 		m3.paisa=paisa+m2.paisa;
 		if(m3.paisa>=100)
 		{
 			m3.rupee = m3.paisa/100;
 			m3.paisa = m3.paisa%100;
 		}
 		m3.rupee = m3.rupee + rupee +m2.rupee;

 		if(m3.rupee<0 || m3.paisa<0) throw new NegativeMoneyException();
 		return m3;
 	}

 	public void Show()
 	{
 		System.out.println("Rs."+m3.rupee+"."+m3.paisa+"paisa");
 	}
 }

 class Money_Exception
 {
 	public static void main(String args[])
 	{
 		try
 		{
 			Money m1 = new Money(10,2);
 			Money m2 = new Money(12,-2);

 			Money m3 = new Money();
 			m3 = m1.Add(m2);
 			m3.Show();
 		}
 		catch(NegativeMoneyException e)
 		{
 			System.out.println(e);
		}
 	}
 } */

class NegativeMoneyException extends Exception
{
    NegativeMoneyException() {super();}
    NegativeMoneyException(String message) {super(message);}
    @Override
    public String toString()
	{
        return "CURRENCY CAN NOT BE NEGATIVE";
    }
}

class Money 
{
    int rupee, paisa;

    Money() 
	{
        rupee = 0;
        paisa = 0;
    }

    Money(int rupee, int paisa) throws NegativeMoneyException 
	{
        if (rupee < 0 || paisa < 0) 
            throw new NegativeMoneyException();
        
        this.rupee = rupee;
        this.paisa = paisa;
    }

    Money Add(Money m2) throws NegativeMoneyException 
	{
        Money m3 = new Money();
        m3.paisa = this.paisa + m2.paisa;
        m3.rupee = this.rupee + m2.rupee;

        if (m3.paisa >= 100) 
		{
            m3.rupee += m3.paisa / 100;
            m3.paisa = m3.paisa % 100;
        }

        return m3;
    }

    public void Show() 
	{
        System.out.println("Rs." + this.rupee + "." + this.paisa + " paisa");
    }
}

class Money_Exception 
{
    public static void main(String args[])
	{
        try 
		{
            Money m1 = new Money(10, 2);
            Money m2 = new Money(12, 5); // Fixed negative paisa issue
            Money m3 = m1.Add(m2);
            m3.Show();
        } catch (NegativeMoneyException e) {
            System.out.println(e);
        }
    }
}
