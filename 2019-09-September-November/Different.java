import java.util.Scanner;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Different
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(Math.abs(a-b));
        }
        
        sc.close();
	}
}