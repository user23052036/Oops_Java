class SharedData
{
    private int counter=-1;
    private int[] data;

    SharedData(int[] data)
    {
        this.data = data;
    }

    public synchronized void produce(int x)
    {
        while(counter == data.length-1)
        {
            try{wait();}
            catch(InterruptedException e){System.out.println(e.getMessage());}
        }

        data[++counter] = x;
        System.out.println("Produced: "+data[counter]);
        notify();
    }
    public synchronized void consume()
    {
        if(counter == -1)
        {
            try{wait();}
            catch(InterruptedException e){System.out.println(e.getMessage());}
        }

        int consumed_value = data[counter--];
        System.out.println("Consumed data: "+consumed_value);
        notify();
    }
}

class Producer extends Thread
{
    SharedData sd;
    Producer(SharedData sd)
    {
        this.sd=sd;
    }
    public void run() //override the abstruct run method
    {
        for(int i=0;i<10;i++)
            sd.produce(i);
    }
}

class Consumer extends Thread
{
    SharedData sd;
    Consumer(SharedData sd)
    {
        this.sd=sd;
    }
    public void run() //override the abstruct run method
    {
        for(int i=0;i<10;i++)
            sd.consume();
    }
}

public class ProducerConsumer
{
    public static void main(String[] args) 
    {
        int data[] = new int[10];
        SharedData sd = new SharedData(data);
        Producer p = new Producer(sd);
        Consumer s = new Consumer(sd);

        p.start();
        s.start();
    }
}