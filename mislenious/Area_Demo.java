import java.util.Scanner;

interface Area
{
    double findArea();
}

class Triangle implements Area
{
    private double base, height;
    Triangle(double base, double height)
    {
        this.base = base;
        this.height = height;
    }

    public double findArea()
    {
        return 0.5*base*height;
    }
}

class Rectangle implements Area
{
    private double length, width;

    Rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    public double findArea()
    {
        return length * width;
    }
}

public class Area_Demo
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base of triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = scanner.nextDouble();

        System.out.print("Enter length of rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width of rectangle: ");
        double width = scanner.nextDouble();

        Area triangle = new Triangle(base, height);
        Area rectangle = new Rectangle(length, width);

        System.out.println("Area of Triangle: " + triangle.findArea());
        System.out.println("Area of Rectangle: " + rectangle.findArea());

        scanner.close();
    }
}


