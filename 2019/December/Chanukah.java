import java.io.*;
import java.util.*;

public class Chanukah
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			String[] params = br.readLine().split(" ");
			int v = Integer.parseInt(params[1]);
			
			int res = 0;
			for(int i = 0; i <= v; i++)
				res += i;
			
			res += v;
			
			bw.write(params[0] + " " + res + "\n");
		}
		
		
		br.close();
		bw.close();
	}
}
