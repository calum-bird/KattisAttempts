import java.io.*;
import java.util.*;

public class UnlockPattern
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] nums = new int[9];
		String[] first = br.readLine().split(" ");
		String[] second = br.readLine().split(" ");
		String[] third = br.readLine().split(" ");
		
		
		nums[0] = Integer.parseInt(first[0]);
		nums[1] = Integer.parseInt(first[1]);
		nums[2] = Integer.parseInt(first[2]);
		nums[3] = Integer.parseInt(second[0]);
		nums[4] = Integer.parseInt(second[1]);
		nums[5] = Integer.parseInt(second[2]);
		nums[6] = Integer.parseInt(third[0]);
		nums[7] = Integer.parseInt(third[1]);
		nums[8] = Integer.parseInt(third[2]);
		
		Point[] points = new Point[9];
		for(int i = 0; i < 9; i++)
		{
			Point p = new Point();
			p.y = 1+(i/3);
			p.x = 1+(i%3);
			
			points[nums[i]-1] = p;
		}
		
		double distance = 0.0d;
		Point last = null;
		for(Point p: points)
		{
			if(last != null)
				distance += dist(p, last);
				
			last = p;
		}
		
		bw.write(distance + "\n");
		
		br.close();
		bw.close();
	}
	
	static double dist(Point p1, Point p2)
	{
		return Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
	}
}

class Point
{
	public int x;
	public int y;
}
