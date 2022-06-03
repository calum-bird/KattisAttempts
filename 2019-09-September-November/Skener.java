import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Skener
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int R = Integer.parseInt(parts[0]);
		int C = Integer.parseInt(parts[1]);
		int yMultiplier = Integer.parseInt(parts[2]);
		int xMultiplier = Integer.parseInt(parts[3]);
		
		for(int i = 0; i < R; i++)
		{
			char[] line = br.readLine().toCharArray();
			char[] newLine = new char[line.length * xMultiplier];
			for(int j = 0; j < C*xMultiplier; j+= xMultiplier)
			{
				char curr = line[j/xMultiplier];
				for(int h = 0; h < xMultiplier; h++)
					newLine[j+h] = curr;
			}
			
			for(int j = 0; j < yMultiplier; j++)
			{
				bw.write(newLine);
				bw.write("\n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}