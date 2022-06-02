import java.io.*;
import java.awt.geom.*;
import java.awt.Polygon;
import java.util.*;

public class AbstractArt
{
    public static void main(String[] args) throws Exception, IllegalStateException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Point> points = new ArrayList<Point>();
        
        int numPolygons = Integer.parseInt(br.readLine());
        double areaSum = 0d;
        while(numPolygons-- > 0)
        {
            String[] parts = br.readLine().split(" ");
            int m = Integer.parseInt(parts[0]);
            int[] xVals = new int[m];
            int[] yVals = new int[m];
            for(int i = 1; i < m*2; i+=2)
            {
                int x = Integer.parseInt(parts[i]);
                int y = Integer.parseInt(parts[i+1]);
                xVals[i/2] = x;
                yVals[i/2] = y;
                points.add(new Point(x, y));
            }

            double polyArea = 0d;
            int j = m-1;
            for(int i = 0; i < m; i++)
            {
                polyArea += ((xVals[j] + xVals[i]) * (yVals[j] - yVals[i]));
                j = i;
            }
            polyArea = Math.abs(polyArea)/2d;
            areaSum += polyArea;
        }

        double area = getCombinedArea(points);

        System.out.println(areaSum + " " + area);

        br.close();
    }

    static double getCombinedArea(List<Point> points) throws IllegalStateException
    {
        Polygon combined = new Polygon();
        for(Point p: points)
        {
            combined.addPoint(p.x, p.y);
        }

        PathIterator pi = combined.getPathIterator();
        double[] prev = null;
        int type = pi.currentSegment(prev);
        pi.next();
        double area = 0d;

        while (!pi.isDone()) {
            double[] coords = new double[2];
            type = pi.currentSegment(coords);

            area += ((prev[0] + coords[0]) * (prev[1] - coords[1]));
            
            prev = coords;
            pi.next();
        }

        return Math.abs(area)/2;
    }

    static int getLeftPoint(List<Point> points)
    {
        int xMin = points.get(0).x;
        int min = 0;
        for(int i = 1; i < points.size(); i++)
        {
            int x = points.get(i).x;
            if(x < xMin)
            {
                xMin = x;
                min = i;
            }
        }

        return min;
    }

    static int orientation(Point p, Point q, Point r) 
    { 
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
       
        if(val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    } 
}

class Point
{
    int x, y;

    public Point(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
}