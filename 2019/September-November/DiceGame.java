import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DiceGame
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts1 = br.readLine().split(" "); //Read first line
		String[] parts2 = br.readLine().split(" "); //Read second line
		
		int gunnarCount = 0;
		int emmaCount = 0;
		
		for(String p: parts1)
		{
			gunnarCount += Integer.parseInt(p);
		}
		for(String p: parts2)
		{
			emmaCount += Integer.parseInt(p);
		}
		
		if(emmaCount > gunnarCount)
		{
			bw.write("Emma \n");
		}
		else if(gunnarCount > emmaCount)
		{
			bw.write("Gunnar \n");
		}
		else
		{
			bw.write("Tie \n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}