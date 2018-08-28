import java.util.*;
class Area_of_circle {
	static double area(double r) 
	{
		double pie=pi();
		double area=pie*r*r;
		return area;
	}
	static double pi() 
	{
		double pie = 3.14;
		return pie;
	}
	public static void main(String[] args) 
	{
		//Scanner sc = new Scanner(System.in);
		//radius = sc.nextDouble();
		double radius = 5.2;
		double area = area(radius);
		System.out.println("area is "+area);
	}
}