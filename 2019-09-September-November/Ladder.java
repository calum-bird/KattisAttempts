import java.io.*;

public class Ladder
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		
		double x = Double.parseDouble(parts[0]); //Read first line
		double y = Double.parseDouble(parts[1]); //Read second line
		
		bw.write(Integer.toString((int) Math.ceil(x / Math.sin(Math.toRadians(y)))));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}