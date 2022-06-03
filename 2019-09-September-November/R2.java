import java.io.*;

public class R2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] lineParts = br.readLine().split(" ");
		
		int R = Integer.parseInt(lineParts[0]); //Read R
		int S = Integer.parseInt(lineParts[1]); //Read S
		
		bw.write(Integer.toString(2 * S - R));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}