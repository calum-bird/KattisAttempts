import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DetailedDifferences
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			char[] line = br.readLine().toCharArray();
			char[] secondLine = br.readLine().toCharArray();
			char[] output = new char[line.length];
			for(int j = 0; j < line.length; j++)
			{
				if(line[j] == secondLine[j])
				{
					output[j] = '.';
				}
				else
				{
					output[j] = '*';
				}
			}
			bw.write(new String(line) + "\n");
			bw.write(new String(secondLine) + "\n");
			bw.write(new String(output) + "\n\n"); 
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}