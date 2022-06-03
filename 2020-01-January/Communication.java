import java.io.*;
import java.util.*;

public class Communication
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] lines = br.readLine().split(" ");
		
		int[] lookup = new int[256];
		
		for(int i = 0; i < 256; i++)
		{
			byte result = (byte)(i^(i << 1));
			lookup[(int)(result & 0xFF)] = i;
		}
		
		for(String s: lines)
		{
			int val = lookup[Integer.parseInt(s)];
			System.out.print(Integer.toString(val) + " ");
		}
		
		br.close();
	}	
}
