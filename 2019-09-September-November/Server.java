import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Server
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int maxMinutes = Integer.parseInt(parts[1]);
		
		String[] nextParts = br.readLine().split(" ");
		
		int taskCount = 0;
		for(int i = 0; i < nextParts.length; i++)
		{
			int t = Integer.parseInt(nextParts[i]);
			if(maxMinutes - t >= 0)
			{
				maxMinutes -= t;
				taskCount++;
			}
			else if(maxMinutes - t < 0)
				break;
		}
		
		bw.write(Integer.toString(taskCount));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}