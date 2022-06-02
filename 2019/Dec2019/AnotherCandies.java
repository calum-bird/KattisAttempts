import java.io.*;
import java.math.*;
import java.util.*;

public class AnotherCandies
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		while(n-- > 0)
		{
			br.readLine();
			long numChildren = Long.parseLong(br.readLine());
			BigInteger counter = BigInteger.ZERO;
			for(long i = 0; i < numChildren; i++)
			{
				counter = counter.add(new BigInteger(br.readLine()));
			}
			
			if(counter.mod(BigInteger.valueOf(numChildren)).equals(BigInteger.ZERO))
			{
				bw.write("YES\n");
			}
			else
			{
				bw.write("NO\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
