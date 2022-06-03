import java.io.*;
import java.util.*;

public class RobotProtection
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(!line.equals("0"))
		{
			int n = Integer.parseInt(line);
			ArrayList<Point> tempPoints = new ArrayList<Point>();
			
			for(int i = 0; i < n; i++)
			{
				String[] pointStr = br.readLine().split(" ");
				Point p = new Point(Integer.parseInt(pointStr[0]), Integer.parseInt(pointStr[1]));
				tempPoints.add(p);
			}
			
			List<Point> hull = grahamScan(tempPoints);
			
			n = hull.size();
			
			double area = 0.0d;
			for(int i = 0; i < n; i++)
			{
				area += (hull.get((i+1)%n).x * hull.get(i).y) + (hull.get((i+1)%n).y * hull.get(i).x);
				bw.write(hull.get(i).x + " " + hull.get(i).y + " @ " + i + "\n");
			}
			
			area = Math.abs(area/2.0d);
			
			bw.write(area + "\n");
		
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
	
	static List<Point> grahamScan(List<Point> points)
	{
		Point p0 = getMin(tempPoints);
		
	}
	
	static Point getMin(List<Point> points)
	{
		List<point> candidates = new ArrayList<Point>();
		
		int minIndex = 0;
		for(int i = 0; i < points.size(); i++)
		{
			if(points.get(i).y <= points.get(minIndex).y)
				candidates.add(points.get(minIndex);
		}
		
		minIndex = 0;
		int ind = 0;
		for(Point p: candidates)
		{
			if(p.x < candidates.get(minIndex).x)
				minIndex = ind;
			ind++;
		}
		
		return candidates.get(minIndex);
	}
}

class Point
{
	int x, y;
	Point(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
}
