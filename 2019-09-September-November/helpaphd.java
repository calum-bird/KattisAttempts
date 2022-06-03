import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class helpaphd
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String line = br.readLine();
			if(line.contains("P=NP"))
			{
				bw.write("skipped\n");
			}
			else
			{
				String[] parts = line.split("\\+");
				bw.write(Integer.toString(Integer.parseInt(parts[0]) + Integer.parseInt(parts[1])) + "\n");
				
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}