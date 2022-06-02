import java.io.*;

public class Carrots
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine().split(" ")[1]); //Read first line
		
		bw.write(Integer.toString(x));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}