import java.util.Scanner;

class Shape
{
	float Find_Area(float r)
	{
		float area = 3.14f*r*r;
		return area;
	}

	float Find_Area(float length)
	{
		float area = length*length;
		return area;
	}

	float Find_Area(float a, float b, float c)
	{
		float s = (a+b+c)/2;
		float area = (float)Math.sqrt((s-a)*(s-b)*(s-c));

		return area;
	}
}

class Shape_Demo
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Shape c = new Shape();

		System.out.print("Enter radius:-");
		float radi = sc.nextFloat();

		System.out.print("Enter length breadth:-");
		float length = sc.nextFloat();
		float breadth = sc.nextFloat();

		System.out.print("Enter a,b,c:-");
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();

		System.out.println("area of the circle is "+c.Find_Area(rad
		System.out.println("area of the rectangle is "+c.Find_Area(length,breadth));
		System.out.println("area of the triangle is "+c.Find_Area(a,b,c));

	}
}