import java.util.*;
class Compare
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>b){
			System.out.println("a is bigger");
		}	
		else if(a<b){
			System.out.println("a is smaller");
		}
		else
		{
			System.out.println("equal");
		}
	}
}