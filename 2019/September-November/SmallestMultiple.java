import java.math.BigInteger;
import java.util.Scanner;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SmallestMultiple
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in); //Initialize the input reader
		
		
		while(sc.hasNext())
		{
			String[] parts = sc.nextLine().split(" ");
			long[] vals = new long[parts.length];
			
			BigInteger prod = new BigInteger("1");
			
			for(int i = 0; i < parts.length; i++)
			{
				vals[i] = Long.parseLong(parts[i]);
				if(vals[i] != 1)
					prod = prod.multiply(new BigInteger(parts[i]));
			}
			
			long common = vals[0];
			for(int i = 1; i < vals.length; i++)
			{
				common = gcd(common, vals[i]);
			}
			
			System.out.println("GCD: " + common);
			
			BigInteger res = prod.divide(BigInteger.valueOf(common));
			
			System.out.println(res.toString());
		}

		sc.close();
	}
	
	static long gcd(long a, long b)
	{
		return b == 0 ? (a < 0 ? -a: a) : gcd(b, a % b);
	}
}