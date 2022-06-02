import java.io.*;

public class IsItHalloween
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String line = br.readLine(); //Read first line
		
		if(line.contains("OCT 31") || line.contains("DEC 25"))
		{
			bw.write("yup");
		}
		else
		{
			bw.write("nope");
		}
		
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}