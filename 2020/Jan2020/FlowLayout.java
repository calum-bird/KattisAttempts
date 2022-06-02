import java.io.*;
import java.util.*;

public class FlowLayout
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		while(!line.equals("0"))
		{
			int maxWidth = Integer.parseInt(line);
			
			int currWidth = 0, currHeight = 0;
			int recordWidth = 0;
			
			int lastRowHeight = 0;
			int rowHeight = 0;
			
			String nextLine = br.readLine();
			while(!nextLine.equals("-1 -1"))
			{
				String[] parts = nextLine.split(" ");
				int w = Integer.parseInt(parts[0]);
				int h = Integer.parseInt(parts[1]);
				
				if(currWidth + w > maxWidth)
				{
					//We have reached the max width
					currWidth = w;
					//Add last row's max height to our counter
					currHeight += rowHeight;
					
					//Reset last row's height
					lastRowHeight = rowHeight;
					rowHeight = 0;
				}
				else
				{
					currWidth += w;
				}
				
				if(currWidth > recordWidth)
					recordWidth = currWidth;
				
				if(h > rowHeight)
				{
					rowHeight = h;
				}
				
				nextLine = br.readLine();
			}
			
			currHeight += rowHeight;
			
			System.out.println(recordWidth + " x " + currHeight);
			
			line = br.readLine();
		}
		
		br.close();
	}	
}
