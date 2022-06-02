import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
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

public class ConvexHull2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		
		while(x-- > 0)
		{
			String[] parts = br.readLine().split(" ");
			double x1 = java.lang.Double.parseDouble(parts[0]);
			double y1 = java.lang.Double.parseDouble(parts[1]);
			points.add(new Point2D.Double(x1, y1));
		}
		
		Point2D[] a = new Point2D[points.size()];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = points.get(i);
		}
		
		Point2D[] hull = convexHull(a);
		
		StringBuilder sb = new StringBuilder();
		sb.append(hull.length + "\n");
		for(Point2D p: hull)
		{
			sb.append((int)p.getX() + " " + (int)p.getY() + "\n");
		}
		
		System.out.print(sb);

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
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
			 
			 return - 1;
		 }
	}
	
	static double cross(Point2D a, Point2D b, Point2D c)
	{
		return ((b.getX()-a.getX()) * (c.getY() - a.getY())-(b.getY()-a.getY()) * (c.getX()-a.getX()));
	}
}