import java.io.*;

public class RealChallenge
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		double area = Double.parseDouble(br.readLine()); //Read first line
		
		double fenceLength = Math.sqrt(area) * 4;
		
		bw.write(Double.toString(fenceLength));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}