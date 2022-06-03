import java.io.*;

public class MountainBiking
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] params = br.readLine().split(" ");
		int segmentCount = Integer.parseInt(params[0]);
		double g = Double.parseDouble(params[1]);
		
		int[] distances = new int[segmentCount];
		int[] angles = new int[segmentCount];
		double[] segmentVelocityDeltas = new double[segmentCount];
		
		double totalDistance = 0d;
		for(int i = 0; i < segmentCount; i++)
		{
			String[] line = br.readLine().split(" ");
			distances[i] = Integer.parseInt(line[0]);
			angles[i] = Integer.parseInt(line[1]);
		}
		
		for(int i = 0; i < segmentCount; i++)
		{
			if(i > 0)
			{
				segmentVelocityDeltas[i] = segmentVelocity(distances[i], angles[i], g, segmentVelocityDeltas[i-1], distances[i-1]);
				System.out.println(Double.toString(segmentVelocityDeltas[i]));
			}
			else
			{
				segmentVelocityDeltas[i] = segmentVelocity(distances[i], angles[i], g, 0, 0);
				System.out.println(Double.toString(segmentVelocityDeltas[i]));
			}
		}
		
		br.close();
	}
	
	static double segmentVelocity(int distance, int angle, double coef, double prevVelocity, int prevDistance)
	{
		double a = getAcceleration(coef, angle);
		double t;
		if(prevDistance != 0)
		{
			double t1 = -1*prevVelocity + (Math.sqrt(Math.pow(prevVelocity, 2)-(2*a*prevDistance))/(2*prevDistance));
			double t2 = -1*prevVelocity - (Math.sqrt(Math.pow(prevVelocity, 2)-(2*a*prevDistance))/(2*prevDistance));
			
			t = Math.max(t1, t2);
		}
		else
		{
			t = Math.sqrt((2*distance)/a);
		}
		
		double velocity = Math.sqrt(Math.pow(prevVelocity, 2) + (2*a*t));
		
		return velocity;
	}
	
	static double degToRad(int angle)
	{
		return (double)angle*(Math.PI/180);
	}
	
	static double getAcceleration(double coefficient, int angle)
	{
		return coefficient*Math.cos(degToRad(angle));
	}
}
