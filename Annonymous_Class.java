package code;

@FunctionalInterface
interface A
{
    public void sayHello();   // function interface should have one abstruct method (method without body) RAHU

    public static void sayOk(){}  // can have any number of default or static methods
    default void sayBye(){}

    @Override
    public String toString();    // already defined in the Object class (parent class)
    @Override
    public int hashCode();       // already defined in the Object class (parent class)
    @Override
    boolean equals(Object obj);  // already defined in the Object class (parent class)
}

public class Annonymous_Class
{
    public static void main(String[] args) 
    {
        // A a = new A()                                // using annonymous class
        // {
        //     public void sayHello()
        //     {
        //         System.out.println("Namaste !");
        //     }
        // };
        // a.sayHello();

        A a = () -> System.out.println("namastee! ");   //using lambda expression
        a.sayHello();
    }
}