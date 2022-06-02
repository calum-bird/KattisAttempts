import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SimonSays
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String line = br.readLine();
			if(line.length() > 10)
			{
				if(line.substring(0, 10).equals("simon says"))
				{
					bw.write(line.substring(11) + "\n");
				}
				else
				{
					bw.write("\n");
				}
			}
			else
			{
				bw.write("\n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}