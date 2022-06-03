import java.io.*;
import java.util.*;

public class downtime
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0]);
		int k = Integer.parseInt(params[1]);
		
		int[] requests = new int[n];
		
		int[] groupRequestCounts = new int[n];
		
		int currGroup = 1000;
		int groupCounter = 1;
		
		for(int i = 0; i < n; i++)
		{
			int request = Integer.parseInt(br.readLine());
			
			if(request < currGroup)
			{
				groupRequestCounts[groupCounter-1]++;
			}
			else
			{
				currGroup += 1000;
				groupCounter++;
				groupRequestCounts[groupCounter-1]++;
			}
		}
		
		int max = 0;
		for(int i = 0; i < groupCounter; i++)
		{
			double res = (double)groupRequestCounts[i]/k;
			if(res >= 1 && res > max)
			{
				max = (int)Math.ceil(res);
			}
		}
		
		System.out.println(max + "");
		
		br.close();
	}
}
