import java.io.*;
import java.util.*;

public class Parking
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1])*2;
		int c = Integer.parseInt(params[2])*3;
		
		int[] truckCount = new int[100];
		Arrays.fill(truckCount, 0);
		
		for(int i = 0; i < 3; i++)
		{
			String[] line = br.readLine().split(" ");
			int enter = Integer.parseInt(line[0])-1;
			int exit = Integer.parseInt(line[1])-1;
			
			for(int j = enter + 1; j <= exit; j++)
			{
				
				truckCount[j]++;
			}
		}
		
		int cost = 0;
		for(int t: truckCount)
		{
			if(t == 1)
				cost += a;
			else if(t == 2)
				cost += b;
			else if(t == 3)
				cost += c;
		}
		
		bw.write(cost + "");
		
		br.close();
		bw.close();
	}
}
