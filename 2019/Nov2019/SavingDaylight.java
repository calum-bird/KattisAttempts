import java.io.*;
import java.util.*;

public class SavingDaylight
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(line != null)
		//while(!line.equals(""))
		{
			String[] parts = line.split(" ");
			
			String stamp1 = parts[3];
			String stamp2 = parts[4];
			
			String[] timeParts1 = stamp1.split(":");
			String[] timeParts2 = stamp2.split(":");
			
			int firstHour = Integer.parseInt(timeParts1[0]);
			int secondHour = Integer.parseInt(timeParts2[0]);
			
			int hour = secondHour-firstHour;
			
			int firstMinute = Integer.parseInt(timeParts1[1]);
			int secondMinute = Integer.parseInt(timeParts2[1]);
			
			int minute = 0;
			if(firstMinute > secondMinute)
			{
				hour--;
				minute = 60 - (firstMinute-secondMinute);
			}
			else
			{
				minute = secondMinute-firstMinute;
			}
			
			bw.write(parts[0] + " " + parts[1] + " " + parts[2] + " " + hour + " hours " + minute + " minutes\n");
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
}
