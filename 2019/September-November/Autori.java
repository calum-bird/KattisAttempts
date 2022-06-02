import java.io.*;

public class Autori
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String line = br.readLine(); //Read first line
		
		String result = "";
		
		String[] parts = line.split(("-"));
		for(String s: parts)
		{
			result += s.charAt(0);
		}
		
		bw.write(result);
		
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}
