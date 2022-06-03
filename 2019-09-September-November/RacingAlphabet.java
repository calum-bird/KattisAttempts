import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class RacingAlphabet
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		double letterTime = (Math.PI * (double)60)/(double)28;
		letterTime /= 15d;
		
		while(n-- > 0)
		{
			char[] input = br.readLine().toCharArray();
			int last = (input[0] == 32) ? 26: (input[0] == 39) ? 27 : input[0] - 65;
			double time = 0d;
			for(int i = 0; i < input.length; i++)
			{
				char c = input[i];
				//If the character is a space, set its value to 27, or single quote = 26
				int val = c - 65;
				if(c == 32)
				{
					//It's a space!
					val = 26;
				}
				else if(c == 39)
				{
					//It's a single quote
					val = 27;
				}
				
				//Check distance from last
				int firstVal = Math.abs(last - val);
				int secondVal = Math.abs(val + (27 - last));
				
				if(i != 0)
				{
					time += Math.min(firstVal, secondVal) * letterTime;
				}
				
				time++;
				last = val;
			}
			
			bw.write(Double.toString(time) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}