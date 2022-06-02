import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class OddGnome
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			int prev = Integer.parseInt(parts[1]);
			
			for(int j = 2; j < parts.length; j++)
			{
				if(Integer.parseInt(parts[j]) != prev + 1)
				{
					bw.write(Integer.toString(j) + "\n");
					break;
				}
				else
					prev = Integer.parseInt(parts[j]);
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}