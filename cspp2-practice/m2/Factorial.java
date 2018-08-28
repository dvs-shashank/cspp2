import java.util.*;
class Factorial
{
	static int fact(int num)
	{
		if(num == 1){
			return 1;
		}
		return num*(fact(num-1));
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int res = fact(n);
		System.out.println(res);
	}
}