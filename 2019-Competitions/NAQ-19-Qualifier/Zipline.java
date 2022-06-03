import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Zipline
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < x; i++)
		{
			String[] ziplineParts = br.readLine().split(" ");
			int width = Integer.parseInt(ziplineParts[0]);
			int pole1 = Integer.parseInt(ziplineParts[1]);
			int pole2 = Integer.parseInt(ziplineParts[2]);
			int rider = Integer.parseInt(ziplineParts[3]);
			
			double cableBaseLength = euclideanDistance(0, pole1, width, pole2);
			
			for(double j = 0; j < pole1; j+= 0.01)
			{
				double cable1X = j;
				double cable2X = width-j;
				
				double hypotnuse1 = euclidianDistance(0, pole1, cable1X, rider);
				
				if(hypotnuse1 + hypotnuse2)
				
			}
		}
		
		br.close();
		bw.close();
	}
	
	static double euclideanDistance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
	}
}
