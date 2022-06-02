import java.io.*;
import java.util.*;

public class DogGopher
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] paramLine = br.readLine().split(" ");
		double gopherX = Double.parseDouble(paramLine[0]);
		double gopherY = Double.parseDouble(paramLine[1]);
		double dogX = Double.parseDouble(paramLine[2]);
		double dogY = Double.parseDouble(paramLine[3]);
		
		double escapeX = 0, escapeY = 0;
		
		boolean canEscape = false;
		
		String line = br.readLine();
		while(line != null && line.length() != 0)
		{
			String[] parts = line.split(" ");
			double x = Double.parseDouble(parts[0]);
			double y = Double.parseDouble(parts[1]);
			
			double gopherDist = euclideanDist(gopherX, gopherY, x, y);
			double dogDist = euclideanDist(dogX, dogY, x, y)/2;
			
			if(dogDist >= gopherDist)
			{
				canEscape = true;
				escapeX = x;
				escapeY = y;
				break;
			}
			
			
			line = br.readLine();
		}
		
		if(canEscape)
			System.out.println("The gopher can escape through the hole at (" + escapeX + "," + escapeY + ").");
		else
			System.out.println("The gopher cannot escape.");
		br.close();
	}
	
	static double euclideanDist(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
	}
}
