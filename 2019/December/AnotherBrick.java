import java.io.*;
import java.util.*;

public class AnotherBrick
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int h = Integer.parseInt(params[0]);
		int w = Integer.parseInt(params[1]);
		int n = Integer.parseInt(params[2]);
		
		String[] brickStrings = br.readLine().split(" ");
		int width = 0;
		int height = 1;
		Boolean failed = false;
		for(int i = 0; i < n; i++)
		{
			int brick = Integer.parseInt(brickStrings[i]);
			if(width + brick > w)
			{
				failed = true;
				bw.write("NO");
				break;
			}
			else
			{
				width += brick;
				if(width == w)
				{
					if(height == h)
					{
						break;
					}
					else
					{
						height++;
						width = 0;
					}
				}
			}
		}
		
		if(!failed)
			bw.write("YES");
		
		br.close();
		bw.close();
	}
}
