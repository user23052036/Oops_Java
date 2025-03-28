class MyThread extends Thread
{
    public void run()
    {
        Thread th = Thread.currentThread();
        String name = th.getName(); //geeting the name of thread (Thread-0)
        
        for(int i=0; i<5; i++)
        {
            System.out.println(i+" "+name);
            try{Thread.sleep(200);}
            catch(InterruptedException e) {System.out.println(e.getMessage());}
        }
    }
}

class MultiThread
{
    public static void main(String args[]) throws InterruptedException
    {
        Thread th = Thread.currentThread();
        String name = th.getName(); //geeting the name of thread (main)

        MyThread t1 = new MyThread();
        t1.start();
        t1.join();

        for(int i=0; i<5; i++)
        {
            System.out.println(i+" "+name);
            try{Thread.sleep(200);}
            catch(InterruptedException e){System.out.println(e.getMessage());}
        }
    }
}