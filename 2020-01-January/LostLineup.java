import java.io.*;
import java.util.*;

public class LostLineup
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] vals = new int[n-1];
		String[] lineParts = br.readLine().split(" ");
		
		for(int i = 0; i < n-1; i++)
		{
			int val = Integer.parseInt(lineParts[i]);
			vals[val] = i+2;
		}
		
		System.out.print("1 ");
		
		for(int v: vals)
			System.out.print(Integer.toString(v) + " ");
		
		
		br.close();
	}
}
