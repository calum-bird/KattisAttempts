import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class GrandpasCheckBoard
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		int[][] grid = new int[n][n];
		for(int[] r: grid)
			Arrays.fill(r, 0);
		
		Boolean passed = true;
		
		for(int i = 0; i < n; i++)
		{
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < line.length; j++)
			{
				char c = line[j];
				if(c == 'B')
				{
					grid[i][j] = 1;
				}
			}
		}
		
		for(int[])
		
		if(passed)
		{
			bw.write("1");
		}
		else
		{
			bw.write("0");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}