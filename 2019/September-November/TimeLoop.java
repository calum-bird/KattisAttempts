import java.io.*;

public class TimeLoop
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int count = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < count; i++)
		{
			bw.write((i + 1) + " Abracadabra \n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}