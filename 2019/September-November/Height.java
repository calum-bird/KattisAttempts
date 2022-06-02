import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Height
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		while(x-- > 0)
		{
			String[] line = br.readLine().split(" ");
			int[] vals = new int[line.length - 1];
			for(int i = 1; i < line.length; i++)
			{
				vals[i-1] = Integer.parseInt(line[i]);
			}
			
			
			
			
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static int stepsToSort(int[] arr)
	{
		
	}
}