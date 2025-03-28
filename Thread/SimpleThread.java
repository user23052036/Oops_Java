//implementing runnable interface and Tread class
import java.lang.Thread;

class A implements Runnable
{
    public void run()
    {
        for(int i=0; i<5; i++)
            System.out.println("A: "+i);
    }
}

class B extends Thread
{
    public void run()
    {
        for(int i=0; i<5; i++)
            System.out.println("B: "+i);
    }
}

public class SimpleThread
{
    public static void main(String args[])
    {
        Thread t1 = new Thread(new A());

        //A a = new A(); and a.start(); does not seem to work why ???
        //Thread t2 = new Thread(new B()); seems to work too
        //t2.start();

        B b = new B();
        t1.start();
        b.start();
    }
}