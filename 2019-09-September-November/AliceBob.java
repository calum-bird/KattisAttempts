import java.io.*;

public class AliceBob
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int stoneCount = Integer.parseInt(br.readLine()); //Get number of stones on the ground
		
		if(stoneCount % 2 == 0)
		{
			bw.write("Bob"); //Alice wins
		}
		else
		{
			bw.write("Alice"); //Bob wins
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}