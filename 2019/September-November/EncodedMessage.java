import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class EncodedMessage
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		for(int cases = 0; cases < x; cases++)
		{
			char[] line = br.readLine().toCharArray();
			int dimensions = (int) Math.sqrt(line.length);
			
			for(int j = dimensions - 1; j >= 0; j--)
			{
				for(int i = 0; i < dimensions; i++)
				{
					bw.write(line[j+(i*dimensions)]);
				}
			}
			
			bw.write("\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}