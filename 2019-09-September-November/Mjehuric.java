import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Mjehuric
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		int[] digits = new int[parts.length];
		
		for(int i = 0; i < parts.length; i++)
		{
			digits[i] = Integer.parseInt(parts[i]);
		}
		
		while(true)
		{
			if(digits[0] > digits[1])
			{
				int dig0 = digits[0];
				int dig1 = digits[1];
				digits[1] = dig0;
				digits[0] = dig1;
				String line = Integer.toString(digits[0]) + " " + Integer.toString(digits[1]) + " " + Integer.toString(digits[2]) + " " + Integer.toString(digits[3]) + " " + Integer.toString(digits[4]) + "\n";
				
				bw.write(line);
				
				if(line.contains("1 2 3 4 5"))
					break;
			}
			if(digits[1] > digits[2])
			{
				int dig0 = digits[1];
				int dig1 = digits[2];
				digits[2] = dig0;
				digits[1] = dig1;
				String line = Integer.toString(digits[0]) + " " + Integer.toString(digits[1]) + " " + Integer.toString(digits[2]) + " " + Integer.toString(digits[3]) + " " + Integer.toString(digits[4]) + "\n";
				
				bw.write(line);
				
				if(line.contains("1 2 3 4 5"))
					break;
			}
			if(digits[2] > digits[3])
			{
				int dig0 = digits[2];
				int dig1 = digits[3];
				digits[3] = dig0;
				digits[2] = dig1;
				String line = Integer.toString(digits[0]) + " " + Integer.toString(digits[1]) + " " + Integer.toString(digits[2]) + " " + Integer.toString(digits[3]) + " " + Integer.toString(digits[4]) + "\n";
				
				bw.write(line);
				
				if(line.contains("1 2 3 4 5"))
					break;
			}
			if(digits[3] > digits[4])
			{
				int dig0 = digits[3];
				int dig1 = digits[4];
				digits[4] = dig0;
				digits[3] = dig1;
				String line = Integer.toString(digits[0]) + " " + Integer.toString(digits[1]) + " " + Integer.toString(digits[2]) + " " + Integer.toString(digits[3]) + " " + Integer.toString(digits[4]) + "\n";
				
				bw.write(line);
				
				if(line.contains("1 2 3 4 5"))
					break;
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}