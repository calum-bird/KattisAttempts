import java.io.*;
import java.util.*;

public class Volim
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int t = 0;
		while(n-- > 0)
		{
			String[] params = br.readLine().split(" ");
			int time = Integer.parseInt(params[0]);
			t += time;
			
			if(t >= 210)
			{
				bw.write(index + "");
				break;
			}
			else
			{
				String ans = params[1];
				switch(ans)
				{
					case "T":
						index++;
						break;
					default:
						break;
				}
				
				
				if(index == 9)
				{
					index = 1;
				}
			}
		}
		
		br.close();
		bw.close();
	}
}
