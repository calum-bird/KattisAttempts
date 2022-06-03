import java.io.*;
import java.util.*;

public class JustAMinute
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		double sumS = 0.0d;
		double sumM = 0.0d;
		for(int i = 0; i < n; i++)
		{
			String[] params = br.readLine().split(" ");
			int m = Integer.parseInt(params[0]);
			int s = Integer.parseInt(params[1]);
			
			sumS += s;
			sumM += m;
		}
		
		double ratio = (sumS/60.0d)/sumM;
		
		if(ratio <= 1.0d)
			bw.write("measurement error");
		else
			bw.write(ratio + "");
		
		br.close();
		bw.close();
	}
}
