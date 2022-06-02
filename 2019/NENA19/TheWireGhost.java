import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class TheWireGhost
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		Boolean success = true;
		
		String[] params = br.readLine().split(" ");
		int length = Integer.parseInt(params[0]);
		int n = Integer.parseInt(params[1]);
		
		double subLengths = (double)length/(double)n;
		
		Point[] current = new Point[n+1];
		current[0] = new Point(0,0,0);
		for(int i = 1; i < n+1; i++)
		{
			String[] line = br.readLine().split(" ");
			int point = Integer.parseInt(line[0]);
			boolean clockwise = line[1].equals("W");
			
			Point last = current[point-2]; //Move from start = 1 to start = 0 and decrement by one
			
			int newDir = last.dir;
			if(clockwise)
			{
				newDir++;
			}
			else
			{
				newDir--;
			}
			

			double x = last.x;
			double y = last.y;
			
			switch (newDir)
			{
				case 0:
					y -= subLengths*(i-1);
					break;
					
				case 1:
					x -= subLengths*(i-1);
					break;
				case 2:
					y += subLengths*(i-1);
					break;
					
				case 3:
					x += subLengths*(i-1);
					break;
			}
			
			Point p = new Point(x,y,newDir);
			if(!intersects(current, p, subLengths))
				current[i] = new Point(x,y,newDir);
			else
			{
				success = false;
				break;
			}
		}
		
		if(!success)
		{
			bw.write("GHOST");
		}
		else
		{
			bw.write("SAFE");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static boolean intersects(Point[] points, Point toCheck, double sideLength)
	{
		for(Point p: points)
		{
			if(p != null)
			{
				switch (toCheck.dir)
				{
					case 0:
						if(p.y <= toCheck.y && p.y >= toCheck.y - sideLength)
						{
							if(p.x == toCheck.x)
								return true;
						}
						break;
					case 1:
						if(p.x <= toCheck.x && p.x >= toCheck.x - sideLength)
						{
							if(p.y == toCheck.y)
								return true;
						}
						break;
					case 2:
						if(p.x >= toCheck.x && p.x <= toCheck.x + sideLength)
						{
							if(p.y == toCheck.y)
								return true;
						}
						break;
					case 3:
						if(p.y >= toCheck.y && p.y <= toCheck.y + sideLength)
						{
							if(p.x == toCheck.x)
								return true;
						}
						break;
				}
			}
		}
		
		return false;
	}
}

class Point
{
	double x;
	double y;
	int dir; //0-down, 1-right, 2-up, 3-left
	
	Point(double _x, double _y, int _dir)
	{
		x = _x;
		y = _y;
		dir = _dir;
	}
}