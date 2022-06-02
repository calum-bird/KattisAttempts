import java.io.*;
import java.util.*;

public class ExpeditiousCubing
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] prevTimes = br.readLine().split(" ");
		int required = (int)(Double.parseDouble(br.readLine())*100);
		int[] times = new int[4];
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < 4; i++)
		{
			int val = (int)(Double.parseDouble(prevTimes[i])*100);
			times[i] = val;
			
			if(val > max)
				max = val;
			if(val < min)
				min = val;
		}
		
		int sum = 0;
		boolean shouldContinue = true;
		
		sum = 0;
		for(int i = 0; i < 4 && shouldContinue; i++)
		{
			if(times[i] != min)
			{
				sum += times[i];
			}
		}
		double avg = sum/3d;
		
		if(shouldContinue && avg <= required)
		{
			System.out.println("infinite");
			shouldContinue = false;
		}
		
		sum = 0;
		if(shouldContinue)
		{
			//Calculate what time Claire needs to win
			//required = (times-min-max)/3
			int requiredSum = required*3;
			for(int i = 0; i < 4; i++)
			{
				if(times[i] != min && times[i] != max)
				{
					sum += times[i];
				}
			}
			
			int result = requiredSum-sum;
			if(result < min)
			{
				System.out.println("impossible");
			}
			else
			{
				System.out.println(Double.toString(result/100d));
			}
		}
		
		
		br.close();
	}
}
