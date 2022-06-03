import java.util.ArrayList;
import java.util.Scanner;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PolygonArea
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		String curr = sc.nextLine();
		while(!curr.equals("0"))
		{
			int n = Integer.parseInt(curr);
			
			ArrayList<Point> points = new ArrayList<Point>();
			double area = 0d;
			for(int i = 0; i < n; i++)
			{
				String[] point = sc.nextLine().split(" ");
				int x = Integer.parseInt(point[0]);
				int y = Integer.parseInt(point[1]);
				Point p = new Point(x,y);
				if(!points.contains(p))
					points.add(p);
			}
			
			for(int i = 0; i < n; i++)
			{
				area += ((double)points.get((i+1) % n).x - (double)points.get(i).x) * ((double)points.get((i+1) % n).y + (double)points.get(i).y);
			}
			
			area /= 2;
			
			if(area > 0)
				System.out.println("CW " + Math.round(Math.abs(area) * 10) / 10.0d);
			else
				System.out.println("CCW " + Math.round(Math.abs(area) * 10) / 10.0d);
			
			curr = sc.nextLine();
		}
		
		sc.close(); //Cleanup the reader
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