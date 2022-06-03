import java.io.*;
import java.util.*;

public class AbstractPainting
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long modVal = 1000000007;
		
		while(n-- > 0)
		{
			String[] parts = br.readLine().split(" ");
			
			int rows = Integer.parseInt(parts[0]);
			int cols = Integer.parseInt(parts[1]);
			
			
			int[][] possibilityMatrix = new int[rows][cols];
			
			possibilityMatrix[0][0] = 18;
			for(int i = 1; i < rows; i++)
			{
				possibilityMatrix[i][0] = 6;
			}
			for(int i = 1; i < cols; i++)
			{
				possibilityMatrix[0][i] = 6;
			}
			
			for(int i = 1; i < rows; i++)
			{	
				for(int j = 1; j < cols; j++)
				{
					possibilityMatrix[i][j] = 2;
				}
			}
			
			long total = 1;
			
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					long current = possibilityMatrix[i][j];
					
					if(i == 0)
					{
						if(j > 0)
						{
							current *= possibilityMatrix[i][j-1];
						}
					}
					else
					{
						if(j > 0)
						{
							current *= possibilityMatrix[i][j-1] * possibilityMatrix[i-1][j];
						}
						else
						{
							current *= possibilityMatrix[i-1][j];
						}
					}
					
					
					total *= current;
				}
			}
			
			System.out.println((total%modVal) + "");
		}
		
		br.close();
	}
}
