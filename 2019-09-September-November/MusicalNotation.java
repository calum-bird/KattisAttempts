import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class MusicalNotation
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		ArrayList<int[]> out = new ArrayList<int[]>();
		
		int[][] output = new int[14][x];
		
		String[] parts = br.readLine().split(" ");
		
		for(int i = 0; i < parts.length; i++)
		{
			String s = parts[i];
			for(int j = 0; j < s.length(); j++)
			{
				char c = s.charAt(0);
				if(c > 96)
				{
					for(int k = 0; k < Integer.parseInt(s.substring(i)); k++)
					{
						output[6 + c - 97][j+k] = 1;
					}
				}
				else
				{
					for(int k = 0; k < Integer.parseInt(s.substring(i)); k++)
					{
						output[6 + c - 65][j+k] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i < parts.length; i++)
		{
			for(int j = 0; j < output[i].length; j++)
			{
				bw.write(Integer.toString(j) + " ");
			}
			
			bw.write("\n");
		}
		
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}