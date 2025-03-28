import java.util.Scanner;

class Coordinate
{
	int x,y;
	Coordinate(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	Coordinate(){}

	void findDistance()
	{
		double dist = Math.sqrt(x*x + y*y);
		System.out.println("Distace from origin = "+dist);
	}
}

class cord2D extends Coordinate
{
	int x,y;
	cord2D(int x, int y)
	{
		super(x,y);
	}
	void findDistance()
	{
		double dist = Math.sqrt(x*x + y*y);
		System.out.println("Distace from origin for 2d point = "+dist);
	}
}
class cord3D extends Coordinate
{
	int x,y,z;
	cord3D(int x, int y, int z)
	{
		super(x,y);
		this.z=z;
	}
	void findDistance()
	{
		double dist = Math.sqrt(x*x+y*y+z*z);
		System.out.println("Distace from origin for 3d point = "+dist);
	}
}

class Coordinate_Demo
{
	public static void main(String args[])
	{
		cord2D point2D = new cord2D(3,4);
		cord3D point3D = new cord3D(5,6,7);
		point2D.findDistance();
		point3D.findDistance();
	}
}