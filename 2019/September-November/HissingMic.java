import java.io.*;

public class HissingMic
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] line = br.readLine().toCharArray(); //Read first line
		
		int sCount = 0;
		
		for(int i = 0; i < line.length; i++)
		{
			if(line[i] == 's')
			{
				if(i+1 < line.length && line[i + 1] == 's')
				{
					bw.write("hiss");
					sCount = 1;
					break;
				}
			}
		}
		
		if(sCount == 0)
		{
			bw.write("no hiss");
		}
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}