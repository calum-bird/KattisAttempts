import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DiceCup
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int dice1 = Integer.parseInt(parts[0]); //Read first number
		int dice2 = Integer.parseInt(parts[1]); //Read second number
		
		int mid = (dice1 + dice2)/2;
		
		int delta = Math.abs((dice2 - dice1)/2);
		
		int startPos = ++mid - delta;
		int stopPos = ++mid + delta;
		
		if((dice1 + dice2) % 2 != 0)
		{
			stopPos++;
		}
		
		for(int i = startPos; i < stopPos; i++)
		{
			bw.write(Integer.toString(i) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}