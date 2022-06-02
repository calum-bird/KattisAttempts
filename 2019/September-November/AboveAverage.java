import java.io.*;

public class AboveAverage
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int count = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < count; i++)
		{
			String[] parts = br.readLine().split(" ");
			int num = Integer.parseInt(parts[0]);
			int[] values = new int[parts.length - 1];
			
			float average = 0.0f;
			
			for(int j = 0; j < values.length; j++)
			{
				values[j] = Integer.parseInt(parts[j + 1]);
				average += values[j];
			}
			
			average = average/num;
			
			int aboveAverageCount = 0;
			
			for(int j = 0; j < values.length; j++)
			{
				if(values[j] > average)
					aboveAverageCount++;
			}
			
			bw.write(String.format("%.3f",(double)Math.round((float)aboveAverageCount/num*100 * 1000d) / 1000d) + "%\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}