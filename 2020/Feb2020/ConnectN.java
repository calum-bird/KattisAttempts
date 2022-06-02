import java.io.*;
import java.util.*;

public class ConnectN
{

	static char[][] input;
	static int x;
	static int y;
	static int nextY;
	static int nextX;
	static char next;
	static char c;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] params = br.readLine().split(" ");
		y = Integer.parseInt(params[0]);
		x = Integer.parseInt(params[1]);
		int n = Integer.parseInt(params[2]);
		
		input = new char[y][x];
		String line = br.readLine();
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x*2; j+=2)
				input[i][j] = line.charAt(j);
			line = br.readLine();
		}
		br.close();
		
		char curr;
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				for(int k = -1; k <= 1; k++)
				{
					for(int l = -1; l <= 1; l++)
					{
						if(checkLine(k, l, j, i, n))
						{
							curr = input[i][j];
							if(curr == 'R')
							{
								System.out.println("RED WINS");
								return;
							}
							else if(curr == 'B')
							{
								System.out.println("BLUE WINS");
								return;
							}
						}
					}
				} 
			}
		}
		
		System.out.println("NONE");
	}
	
	static boolean checkLine(int dirX, int dirY, int j, int i, int n)
	{
		if(dirX == 0 && dirY == 0)
			return false;
		c = input[i][j];
		if(c == 'O')
			return false;
		
		for(int k = 0; k < n; k++)
		{
			nextY = i + (k * dirY);
			nextX = j + (k * dirX);
			
			if(nextY >= input.length || nextY < 0)
				return false;
			else if(nextX >= input[i].length || nextX < 0)
				return false;
			
			next = input[nextY][nextX];
			
			if(next != c)
			{
				return false;
			}
		}
		
		return true;
	}
}
