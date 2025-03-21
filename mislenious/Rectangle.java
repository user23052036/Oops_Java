import java.util.Scanner;

class Rectangle
{
    float l,b;

    Rectangle(float length, float breadth) //read
    {
        l = length;
        b = breadth;
    }

    double calculateArea() //calculate
    {
        return l*b;
    }
    double calculatePerimeter()  //calculate
    {
        return 2*(l*b);
    }
    public void display() //write
    {
        System.out.println("Area of the Rectangle: " + calculateArea());
        System.out.println("Perimeter of the Rectangle: " + calculatePerimeter());
    }

    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length and breadth of the rectangle: ");
        float length = sc.nextFloat();
        float breadth = sc.nextFloat();

        Rectangle rect = new Rectangle(length, breadth);
        rect.display();
    }
}