import java.io.*;
import java.util.*;

public class MoscowDream
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1]);
		int c = Integer.parseInt(params[2]);
		int n = Integer.parseInt(params[3]);
		
		if(a + b + c < n)
		{
			bw.write("NO");
		}
		else
		{
			if(a == 0 || b == 0 || c == 0)
				bw.write("NO");
			else if(n < 3)
				bw.write("NO");
			else
				bw.write("YES");
		}
		
		br.close();
		bw.close();
	}
}
