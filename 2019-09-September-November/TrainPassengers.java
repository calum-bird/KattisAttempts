import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class TrainPassengers
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] first = br.readLine().split(" ");
		int capacity = Integer.parseInt(first[0]);
		int stops = Integer.parseInt(first[1]);
		
		int trainCurrent = 0;
		
		boolean successful = true; 
		
		while(stops-- > 0)
		{
			String[] line = br.readLine().split(" ");
			int left = Integer.parseInt(line[0]);
			int entered = Integer.parseInt(line[1]);
			int atStation = Integer.parseInt(line[2]);
			
			if(left > trainCurrent)
			{
				successful = false;
				bw.write("impossible");
				break;
			}
			
			else if(trainCurrent + entered - left > capacity)
			{
				successful = false;
				bw.write("impossible");
				break;
			}

			trainCurrent -= left;
			trainCurrent += entered;
			
			if(capacity > trainCurrent && atStation > 0)
			{
				successful = false;
				bw.write("impossible");
				break;
			}
			
			if(stops == 0)
			{
				if(atStation > 0)
				{
					successful = false;
					bw.write("impossible");
					break;
				}
			}
		}
		
		if(successful && trainCurrent > 0)
		{
			successful = false;
			bw.write("impossible");
		}
		
		if(successful)
			bw.write("possible");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}