import java.io.*;

public class SpeedLimit
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		while(true)
		{
			int count = Integer.parseInt(br.readLine()); //Read first line
			if(count == -1)
			{
				break;
			}
			
			int miles = 0;
			int lastHours = 0;
			
			for(int i = 0; i < count; i++)
			{
				String[] parts = br.readLine().split(" ");
				int speed = Integer.parseInt(parts[0]);
				int hours = Integer.parseInt(parts[1]);
				
				miles += speed*(hours - lastHours);
				lastHours = hours;
			}
			
			bw.write(Integer.toString(miles) + " miles \n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}