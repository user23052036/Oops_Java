class Outer
{
    static class StaticInner
    {
        void f1()
        {
            System.out.println("Inside static inner class");
        }
    }
    class NonStaticInner
    {
        void f1()
        {
            System.out.println("Inside non static inner class");
        }
    }
}

public class OuterDemo
{
    public static void main(String[] args) 
    {
        Outer.StaticInner si = new Outer.StaticInner();
        si.f1();

        Outer out = new Outer();
        Outer.NonStaticInner nsi = out.new NonStaticInner();
        nsi.f1();
    }
}