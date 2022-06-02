import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class BusySchedule
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		while(x != 0)
		{
			int[] times = new int[x];
			for(int i = 0; i < x; i++)
			{
				String line = br.readLine();
				int minutesValue = 0;
				if(line.contains("p.m."))
				{
					String[] parts = line.substring(0, line.length() - 5).split(":");
					int hours = 0;
					if(Integer.parseInt(parts[0]) != 12)
					{
						hours = Integer.parseInt(parts[0]);
					}
					minutesValue += 720 + (60*hours) + Integer.parseInt(parts[1]);
				}
				else
				{
					//Morning gets priority
					String[] parts = line.substring(0, line.length() - 5).split(":");
					int hours = 0;
					if(Integer.parseInt(parts[0]) != 12)
					{
						hours = Integer.parseInt(parts[0]);
					}
					minutesValue += (60*hours) + Integer.parseInt(parts[1]);
					
				}
				times[i] = minutesValue;
			}
			
			Arrays.sort(times);
			
			for(int i: times)
			{
				if(i >= 720)
				{
					//PM
					i -= 720;
					int hours = Math.floorDiv(i, 60);
					int mins = i - (60*hours);
					if(hours == 0)
					{
						hours = 12;
					}
					if(mins == 0)
						bw.write(String.format("%d", hours) + ":" + String.format("%02d", mins) + " p.m.\n");
					else
						bw.write(String.format("%d", hours) + ":" + String.format("%02d", mins) + " p.m.\n");
				}
				else
				{
					int hours = Math.floorDiv(i, 60);
					
					int mins = i - (60*hours);
					if(hours == 0)
					{
						hours = 12;
					}
					if(mins == 0)
						bw.write(String.format("%d", hours) + ":" + String.format("%02d", mins) + " a.m.\n");
					else
						bw.write(String.format("%d", hours) + ":" + String.format("%02d", mins) + " a.m.\n");
				}
			}
			
			bw.write("\n");
			
			x = Integer.parseInt(br.readLine());
		}
			

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}


/*
4
1:00 a.m.
12:00 a.m.
12:01 a.m.
1:01 a.m.
0
*/