import java.io.*;

public class FractalArea
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int radius = 0;
		int iterations = 0;
		
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			String[] params = br.readLine().split(" ");
			
			radius = Integer.parseInt(params[0]);
			iterations = Integer.parseInt(params[1]);
			
			double area = Math.PI*Math.pow(radius, 2);
			if(iterations > 2)
			{
				area += 4*Math.PI*Math.pow(radius/2, 2);
				int outerCount = 12;
				double nextRadius = (double)radius/4;
				
				for(int i = 3; i <= iterations; i++)
				{
					area += outerCount*Math.PI*Math.pow((nextRadius), 2);
					
					nextRadius = radius/(2*i);
					
					outerCount *= 3;
				}
			}
			else
			{
				area += 4*Math.PI*Math.pow(radius/2, 2);
			}
			
			System.out.println(Double.toString(area));
		}
		
		br.close();
	}
}
