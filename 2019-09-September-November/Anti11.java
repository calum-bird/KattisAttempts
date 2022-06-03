import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class Anti11
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			int val = Integer.parseInt(br.readLine());
			System.out.println(fib(val-1) + "");
		}
		
		br.close();
	}
	
	
	static long fib(int n)
	{
		BigInteger[] pre = new BigInteger[n+2];
		pre[0] = new BigInteger("2");
		pre[1] = new BigInteger("3");
		
		for (int i = 2; i <= n; i++) 
	    { 
	       /* Add the previous 2 numbers in the series 
	         and store it */
			pre[i] = pre[i-1].add(pre[i-2]); 
	    } 
	    return pre[n].mod(new BigInteger("1000000007")).longValue();
	}
}