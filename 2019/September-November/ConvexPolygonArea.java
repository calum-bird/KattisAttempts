import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class ConvexPolygonArea
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0)
		{
			String[] line = br.readLine().split(" ");
			ArrayList<Point> points = new ArrayList<Point>();
			
			int pointCount = Integer.parseInt(line[0]);
			for(int i = 0; i < pointCount; i++)
			{
				int x = Integer.parseInt(line[1 + (2*i)]);
				int y = Integer.parseInt(line[2 + (2*i)]);
				Point p = new Point(x,y);
				if(!points.contains(p))
					points.add(p);
			}
			
			double area = 0d;
			
			for(int i = 0; i < pointCount; i++)
			{
				area += ((double)points.get((i+1) % pointCount).x - (double)points.get(i).x) * ((double)points.get((i+1) % pointCount).y + (double)points.get(i).y);
			}
				
			area /= 2d;
			
			area = Math.abs(area);
			System.out.println(area + "");
		}
		
		br.close();
	}
}

class Point
{
	int x, y;
	Point(int _x, int _y){x = _x; y = _y;}
}