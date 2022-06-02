import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ConvexHull
{
	static ArrayList<Point> h = new ArrayList<Point>();
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String testCases = br.readLine(); //Read first line
		while(!testCases.equals("0"))
		{
			int x = Integer.parseInt(testCases);
			Point2D[] points = new Point2D[x];
			for(int i = 0; i < x; i++)
			{
				String[] line = br.readLine().split(" ");
				points[i] = new Point2D.Double(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
				//points[i] = new Point2D(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}
			
			//jarvis(points);
			StringBuilder sb = new StringBuilder();
			Point2D[] con = convexHull(points);
			
			sb.append(con.length + "\n");
			
			for(Point2D p: con)
			{
				sb.append((int)p.getX() + " " + (int)p.getY() + "\n");
			}
			
			System.out.println(sb);
			
			testCases = br.readLine();
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static void jarvis(Point[] points)
	{
		int n = points.length;
		
		StringBuilder sb = new StringBuilder();
		
		if(n == 2)
		{
			if(points[0].x ==  points[1].x && points[0].y == points[1].y)
			{
				sb.append("1\n");
				sb.append(points[0].x + " " + points[0].y + "\n");
			}
			else
			{
				sb.append("2\n");
				sb.append(points[0].x + " " + points[0].y + "\n");
				sb.append(points[1].x + " " + points[1].y + "\n");
			}
			System.out.print(sb);
			return;
		}
		else if(n == 1)
		{
			sb.append("1\n");
			sb.append(points[0].x + " " + points[0].y + "\n");
			System.out.print(sb);
			return;
		}
		else if(n == 0)
		{
			sb.append("0\n");
			System.out.print(sb);
			return;
		}
		
		int leftMost = 1;
		for(int i = 0; i < n; i++)
		{
			if (points[i].x < points[leftMost].x) 
                leftMost = i;
		}
		
		int p = leftMost;
		int q;
		
		do
		{
			h.add(points[p]);
			
			q = (p + 1) % n;
			
			for (int i = 0; i < n; i++) 
            {
				if (getOrientation(points[p], points[i], points[q]) == -1) 
					q = i;
            }
			
			p = q;
		} while(p != leftMost);
		
		sb.append(h.size() + "\n");
		
		for(Point temp: h)
		{
			sb.append(temp.x + " " + temp.y + "\n");
		}
		
		System.out.print(sb);
	}
	static int getOrientation(Point p, Point q, Point r)
	{
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y); 
     
		if (val == 0) return 0;
		
		return (val > 0) ? 1 : -1;
	}
	
	static Point2D[] convexHull(Point2D[] pts)
	{
		int n = pts.length, k = 0, count = 0;
		Point2D [] arr = new Point2D [ 2 * n ];
		 
		Arrays.sort (pts, new PointComparator());
		 
		for(int i = 0; i < n; ++i)
		{
			while(k >= 2 && cross(arr[k-2], arr[k-1], pts[i]) <= 0)
			{
				k--;
			}
		 	arr [k++] = pts[i];
		}
		for(int i = n-2, t = k+1; i >= 0; i--)
		{
			while(k >= t && cross(arr[k-2], arr[k-1], pts[i]) <= 0)
			{
				k--;
			}
			arr[k++] = pts[i];
		}
		HashSet<Point2D> pt_set = new HashSet<>();
		Point2D[] hull = new Point2D[n];
		
		for(int i = 0 ;i < k ;i++)
		{
			if(!pt_set.contains (arr[i]))
			{
				hull[count++] = arr[i];
				pt_set.add(arr[i]);
			}
		}
		
		return Arrays.copyOfRange(hull, 0, count);
	}
		
	static class PointComparator implements Comparator<Point2D>
	{
		 static final double EPS = 0.000001;
		 
		 public int compare(Point2D p1, Point2D p2)
		 {
			 if(Math.abs(p1.getX() - p2.getX()) < EPS )
			 {
				 if(Math.abs(p1.getY() - p2.getY()) < EPS)
				 {
					 return 0;
				 }
				 else if(p1.getY() > p2.getY())
				 {
					 return 1;
				 }
			 }
			 else if(p1.getX() > p2.getX())
			 {
				 return 1;
			 }
			 
			 return -1;
		 }
	}
	
	static double cross(Point2D a, Point2D b, Point2D c)
	{
		return ((b.getX()-a.getX()) * (c.getY() - a.getY())-(b.getY()-a.getY()) * (c.getX()-a.getX()));
	}
}

class Point
{
	int x;
	int y;
	
    Point(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
}

/*
Test case:
5
732 590
415 360
276 276
229 544
299 95
5
441 932
277 526
82 860
635 382
165 142
0
*/