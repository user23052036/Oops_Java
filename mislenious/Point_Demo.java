import java.util.Scanner;

class Point
{
    int x,y;

    Point(){}
    Point(int m)
    {x=m;y=m;}
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    Point(Point p1)
    {
        x = p1.x;
        y = p1.y;
    }

    float find_Distance() //from origin
    {
        float dist = (float)Math.sqrt(x*x + y*y);
        return dist;
    }
    float find_Distance(int p, int q) //coordinate
    {
        float dist = (float)Math.sqrt((x-p)*(x-p) + (y-q)*(y-q)); 
        return dist;
    }
    float find_Distance(Point p1) //from origin
    {
        float dist = (float)Math.sqrt((x-p1.x)*(x-p1.x) + (y-p1.y)*(y-p1.y)); 
        return dist;
    }

    boolean is_Equal(Point p1)
    {
        if(x==p1.x && y==p1.y) return true;
        return false;
    }

    void show()
    {
        System.out.println("value of x = "+x+" and y = "+y);
    }
}

class Point_Demo
{
    public static void main(String args[])
    {

        //explicit pass
        Point pnt1 = new Point(); 
        pnt1.show();
        Point pnt2 = new Point(12); 
        pnt2.show();
        Point pnt3 = new Point(7,8); 
        pnt3.show();
        Point pnt4 = new Point(pnt2);
        pnt4.show();

        pnt3.find_Distance();
        pnt4.find_Distance();

        //through command line argument
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        Point pnt5 = new Point(a,b);
        pnt5.show();


        //through scanner class
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        Point pnt6 = new Point(m);
        pnt6.show();
        pnt6.find_Distance();
    }
}