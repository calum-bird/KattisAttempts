import java.io.*;
import java.util.*;

public class FreeFood
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> freeDays = new ArrayList<Integer>();
		while(n-- > 0)
		{
			String[] parts = br.readLine().split(" ");
			int p1 = Integer.parseInt(parts[0]);
			int p2 = Integer.parseInt(parts[1]);
			for(int i = p1; i <= p2; i++)
			{
				if(!freeDays.contains(i))
					freeDays.add(i);
			}
		}
		
		bw.write(freeDays.size() + "");
		
		br.close();
		bw.close();
	}
}
