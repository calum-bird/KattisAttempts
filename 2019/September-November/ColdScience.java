import java.io.*;

public class ColdScience
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int count = Integer.parseInt(br.readLine()); //Read first line
		
		String[] lineParts = br.readLine().split(" ");
		
		int daysBelowZero = 0;
		
		for(int i = 0; i < count; i++)
		{
			if(Integer.parseInt(lineParts[i]) < 0)
			{
				daysBelowZero++;
			}
		}
		
		bw.write(Integer.toString(daysBelowZero));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}