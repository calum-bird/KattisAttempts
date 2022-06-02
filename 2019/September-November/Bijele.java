import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Bijele
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		for(int i = 0; i < parts.length; i++)
		{
			int num = Integer.parseInt(parts[i]);
			switch (i)
			{
				case 0:
					if(num != 1)
					{
						bw.write(-(num - 1) + " ");
					}
					else
					{
						bw.write("0 ");
					}
					break;
				case 1:
					if(num != 1)
					{
						bw.write(-(num - 1) + " ");
					}
					else
					{
						bw.write("0 ");
					}
					break;
				case 2:
					if(num != 2)
					{
						bw.write(-(num - 2) + " ");
					}
					else
					{
						bw.write("0 ");
					}
					break;
				case 3:
					if(num != 2)
					{
						bw.write(-(num - 2) + " ");
					}
					else
					{
						bw.write("0 ");
					}
					break;
				case 4:
					if(num != 2)
					{
						bw.write(-(num - 2) + " ");
					}
					else
					{
						bw.write("0 ");
					}
					break;
				case 5:
					if(num != 8)
					{
						bw.write(-(num - 8) + " ");
					}
					else
					{
						bw.write("0 ");
					}
					break;
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}