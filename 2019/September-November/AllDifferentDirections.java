import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class AllDifferentDirections
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		while(n != 0)
		{
			for(int i = 0; i < n; i++)
			{
				String[] parts = br.readLine().split(" ");
				double x = Double.parseDouble(parts[0]);
				double y = Double.parseDouble(parts[1]);
				
				double startDir = Double.parseDouble(parts[3]);
				
				double finalX = x;
				double finalY = y;
				
				double lastDir = startDir;
				for(int j = 4; j < parts.length - 4; j++)
				{
					if(j % 4 == 0)
					{
						lastDir = Double.parseDouble(parts[j]);
					}
					else if(j % 2 == 0)
					{
						double nextDist = Double.parseDouble(parts[j]);
						finalY += Math.sin(lastDir)*nextDist;
						finalX += Math.cos(lastDir)*nextDist;
					}
				}
				
				bw.write("Initial: " + Double.toString(x) + ":" + Double.toString(y) + " | Final: " + Double.toString(finalY) + ":" + Double.toString(finalX));
			}
			
			n = Integer.parseInt(br.readLine()); //Read input
		}
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}