import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Printer3D
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < n; i++)
		{
			int faces = Integer.parseInt(br.readLine());
			for(int j = 0; j < faces; j++)
			{
				String[] parts = br.readLine().split(" ");
				int[][] vertices = new int[2][(parts.length - 1)/3];
				
				for(int h = 0; h < (parts.length - 1)/3; h++)
				{
					vertices[h][h] = Integer.parseInt(parts[(h + 1)*3]);
				}
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}