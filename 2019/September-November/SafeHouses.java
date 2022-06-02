import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SafeHouses
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		char[][] input = new char[x][x];
		
		for(int i = 0; i < x; i++)
		{
			char[] line  = br.readLine().toCharArray();
			for(int j = 0; j < x; j++)
			{
				input[i][j] = line[j];
			}
		}
		
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < x; j++)
			{
				bw.write(input[i][j]);
			}
			bw.write("\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}