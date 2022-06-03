import java.io.*;
import java.util.*;

public class HailStone
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long sum = 1;
		while(n != 1L)
		{
			sum += n;
			if(n%2 == 0)
				n = n >> 1;
			else
				n = (n*3)+1;
		}
		
		System.out.println(Long.toString(sum));
		
		br.close();
	}
}
