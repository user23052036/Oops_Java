import java.util.Scanner;
class plate
{
    int length;
    int width;
    public plate(int l,int w)
    {
        this.length = l;
        this.width = w;
    }

}
class box extends plate
{
    int height;
    public box(int h,int l,int w)
    {
        super(l,w);
        this.height = h;
    }
}
class Woodbox extends box
{
    int thick;
    public Woodbox(int t,int h,int l,int w)
    {
        super(h,l,w);
        this.thick = t;

    }
    public void show()
    {
        System.out.println("length :"+length);
        System.out.println("width :"+width);
        System.out.println("height :"+height);
        System.out.println("thick :"+thick);
    }
}
public class tempCodeRunnerFile 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Woodbox w = new Woodbox(34,87,90,45);
        w.show();
        System.out.flush();
        sc.close();
    }
}