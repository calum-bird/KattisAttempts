import java.io.*;

public class Planina
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		
		bw.write(Integer.toString((int)((Math.sqrt(Math.pow(4, x)) + 1)*(Math.sqrt(Math.pow(4, x)) + 1))));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}