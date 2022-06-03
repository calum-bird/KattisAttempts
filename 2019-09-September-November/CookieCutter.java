import java.io.BufferedReader;
import java.io.InputStreamReader;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class CookieCutter
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		double[] xVals = new double[n];
		double[] yVals = new double[n];
		
		for(int i = 0; i < n; i++)
		{
			String[] parts = br.readLine().split(" ");
			double x1 = Double.parseDouble(parts[0]);
			double y1 = Double.parseDouble(parts[1]);
			xVals[i] = x1;
			yVals[i] = y1;
		}
		
		double newArea = Double.parseDouble(br.readLine());
		double area = 0;

		double xMin = 0, yMin = 0;
		for(int i = 0; i < n; i++)
		{
			area += (xVals[i] * yVals[(i+1) % n]) - (yVals[i] * xVals[(i+1) % n]);
			if(xVals[i] < xMin)
				xMin = xVals[i];
			if(yVals[i] < yMin)
				yMin = yVals[i];
		}
		
		area /= 2.0d;
		
		double scaleVal = Math.sqrt(newArea/area);
		
		for(int i = 0; i < n; i++)
		{
			System.out.println(((xVals[i] - xMin)*(scaleVal)) + " " + ((yVals[i] - yMin)*(scaleVal)));
		}

		br.close(); //Cleanup the reader
	}
}