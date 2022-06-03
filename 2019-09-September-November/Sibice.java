import java.io.*;

public class Sibice
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		
		String[] lineParts = br.readLine().split(" ");
		
		int matches = Integer.parseInt(lineParts[0]); //Get matches on the floor
		
		int width = Integer.parseInt(lineParts[1]); //Get box width
		int height = Integer.parseInt(lineParts[2]); //Get box height
		
		for(int i = 0; i < matches; i++)
		{
			if(CheckMatchFits(Integer.parseInt(br.readLine()), width, height))
			{
				bw.write("DA \n");
			}
			else
			{
				bw.write("NE \n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static boolean CheckMatchFits(int matchLength, int boxWidth, int boxHeight)
	{
		double diag = Math.sqrt((boxWidth * boxWidth) + (boxHeight * boxHeight));
		
		if(matchLength <= diag || matchLength <= boxWidth || matchLength <= boxHeight)
		{
			return true;
		}
		
		return false;
	}
}