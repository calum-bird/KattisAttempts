import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class FractalArea
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			int r = Integer.parseInt(parts[0]);
			int n = Integer.parseInt(parts[1]);
			
			int currentExtremaCount = 1;
			double totalArea = 0.0d;
			
			
			for(int j = 0; j < n; j++)
			{
				double newRadius = (j > 0) ? r / (2*j): r;
				
				if(j == 0)
				{
					totalArea += Math.PI*newRadius*newRadius;
					currentExtremaCount = 1;
				}
				else if(j == 1)
				{
					totalArea += 4*Math.PI*newRadius*newRadius;
					currentExtremaCount = 4;
				}
				else
				{
					currentExtremaCount *= 3;
					totalArea += currentExtremaCount*Math.PI*newRadius*newRadius;
				}
				
			}
			
			bw.write(Double.toString(totalArea) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}