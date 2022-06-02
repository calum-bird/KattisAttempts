import java.io.*;

public class HeartRate
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			float b = Float.parseFloat(parts[0]);
			float p = Float.parseFloat(parts[1]);
			
			float bpm = 60*b/p;
			
			float ABPM = 60/p;
			
			bw.write((bpm - ABPM) + " " + bpm + " " + (bpm + ABPM) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}