
// class Table2
// {
//     public static void display(int n)
//     {
//            synchronization(Table2.class)
//            {
//              System.out.println("Table of "+n);
//              for(int i=1; i<=10; i++)
//                  System.out.println(n+"*"+i+" = "+(n*i));
//            }
//     }
// }


// synchronization in method (static)
class Table2
{
    public synchronized static void display(int n)
    {
        System.out.println("Table of "+n);
        for(int i=1; i<=10; i++)
            System.out.println(n+"*"+i+" = "+(n*i));
    }
}
class Thread1 extends Thread
{
    int n;
    Thread1(int n)
    {
        this.n=n;
    }
    public void run()
    {
        Table2.display(n);
    }
}

public class DemoStaticSynchronization
{
    public static void main(String x[])
    {
        Thread1 th1 = new Thread1(5);
        Thread1 th2 = new Thread1(6);
        th1.start();
        th2.start();
    }
}