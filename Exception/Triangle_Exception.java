class NoTriangleFormed extends Exception
{
    NoTriangleFormed()
    {super();}
    NoTriangleFormed(String message)
    {super(message);}
    public String toString()
    {
        return "INVALID PARAMETERS NO TRIANGLE FORMED!";
    }
}

////////////////////////////////////////////////////////////////

class Triangle
{
    int a,b,c;
    Triangle() throws NoTriangleFormed
    {
        throw new NoTriangleFormed();
    }
    Triangle(int a,int b,int c) throws NoTriangleFormed
    {
        if(a+b<=c || a+c<=b ||b+c<=a)
            throw new NoTriangleFormed();
        
        this.a=a;
        this.b=b;
        this.c=c;
    }
    void FindArea()
    {
        float s = (a+b+c)/2;
        float area = (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));

        System.out.println("Area of Triangle: "+area);
    }
    void FindPerimeter()
    {
        System.out.println("Perimeter: "+(a+b+c));
    }
}

////////////////////////////////////////////////////////////////////////


class Triangle_Exception
{
    public static void main(String[] args) 
    {
        try
        {
            Triangle t = new Triangle(1,2,3);  
            t.FindArea();
            t.FindPerimeter();  

        }
        catch(NoTriangleFormed e)
        {
            System.out.println(e);
        }   
    }
}