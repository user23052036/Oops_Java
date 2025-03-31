//synchorixation block passed by obejct inside a method

// class Table
// {
//     public void display(int n)
//     {
//            synchronization(this)
//            {
//              System.out.println("Table of "+n);
//              for(int i=1; i<=10; i++)
//                  System.out.println(n+"*"+i+" = "+(n*i));
//            }
//     }
// }


// synchronization in method (non static)
class Table
{
    public synchronized void display(int n)
    {
        System.out.println("Table of "+n);
        for(int i=1; i<=10; i++)
            System.out.println(n+"*"+i+" = "+(n*i));
    }
}
class Thread1 extends Thread
{
    int n;
    Table t;
    public Thread1(Table t,int n)
    {
        this.t=t;
        this.n=n;
    }
    public void run()
    {
        t.display(n);
    }
}

public class DemoSynchronization
{
    public static void main(String x[])
    {
        Table tb = new Table();

        Thread1 th1 = new Thread1(tb,5);
        Thread1 th2 = new Thread1(tb,6);
        th1.start();
        th2.start();
    }
}