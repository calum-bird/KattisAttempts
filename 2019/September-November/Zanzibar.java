import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Zanzibar
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		while(x-- > 0)
		{
			int counter = 0;
			String[] parts = br.readLine().split(" ");
			int[] vals = new int[parts.length];
			
			for(int i = 0; i < parts.length; i++)
			{
				vals[i] = Integer.parseInt(parts[i]);
			}
			
			for(int i = 1; i < vals.length; i++)
			{
				if(vals[i] > vals[i-1]*2)
				{
					counter += (vals[i] - (vals[i-1]*2));
				}
			}
			
			bw.write(Integer.toString(counter) + "\n");
			
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}