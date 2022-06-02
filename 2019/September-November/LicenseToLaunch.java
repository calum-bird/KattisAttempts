import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class LicenseToLaunch
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		int min = x;
		
		long minVal = Long.MAX_VALUE;
		
		String[] parts = br.readLine().split(" ");
		
		for(int i = 0; i < x; i++)
		{
			long val = Long.parseLong(parts[i]);
			if(val < minVal)
			{
				minVal = val;
				min = i;
			}
		}
		
		bw.write(Integer.toString(min));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}