import java.io.*;
import java.util.*;

public class Putovanje
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int N = Integer.parseInt(params[0]);
		int C = Integer.parseInt(params[1]);
		
		String[] vals = br.readLine().split(" ");
		
		int max = 0;
		int maxIndex = 0;
		for(int i = 0; i < N; i++)
		{
			int current = 0;
			int fruitCount = 0;
			
			//Try starting at all positions
			for(int j = i; j < N; j++)
			{
				int weight = Integer.parseInt(vals[j]);
				if(current + weight <= C)
				{
					current += weight;
					fruitCount++;
				}
				
				if(current <= C)
				{
					if(fruitCount > max)
					{
						max = fruitCount;
						maxIndex = i;
					}
				}
			}
		}
		
		bw.write(max + "\n");
		
		
		br.close();
		bw.close();
	}
}
