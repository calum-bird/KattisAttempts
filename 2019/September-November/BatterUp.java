import java.io.*;

public class BatterUp
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		String[] parts = br.readLine().split(" ");
		int[] scores = new int[parts.length];
		for(int i = 0; i < scores.length; i++)
		{
			scores[i] = Integer.parseInt(parts[i]);
		}
		
		float finalDenom = x;
		float finalNum = 0.0f;
		
		for(int i: scores)
		{
			if(i == -1)
			{
				finalDenom--;
			}
			else
			{
				finalNum += i;
			}
		}
		
		bw.write(Float.toString(finalNum/finalDenom));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}