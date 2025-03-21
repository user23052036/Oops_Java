import java.util.Scanner;

class Circle
{
	float radius;
	void SetRadius(float r)
	{
		radius = r;
	}

	void FindArea()
	{
		double area = 3.14*radius*radius;
		System.out.println("area = "+area);
	}

	void FindPerimeter()
	{
		double peri = 2*3.14*radius;
		System.out.println("perimeter = "+peri);
	}
}

class CircleDemo
{
	public static void main(String args[])
	{
		System.out.println("Enter the radius of circle = ");
		Scanner sc = new Scanner(System.in);

		Circle c1 = new Circle();
		c1.SetRadius(sc.nextFloat());
		c1.FindArea();
		c1.FindPerimeter();
	}
}