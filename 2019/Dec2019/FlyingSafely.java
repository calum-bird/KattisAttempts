import java.io.*;
import java.util.*;

public class FlyingSafely
{
	public static void main(String[] args) throws Exception
	{
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		while(num-- > 0)
		{
			String[] params = br.readLine().split(" ");
			int n = Integer.parseInt(params[0]);
			int m = Integer.parseInt(params[1]);
			
			while(m-- > 0)
			{
				br.readLine();
			}
			
			bw.write(n-1 + "\n");
		}
		
		bw.close();
		br.close();
		*/
		int iter = System.in.read();
		
		while(iter-- > 0)
		{
			int n = System.in.read();
			System.in.read();
			int m = System.in.read();
			
			while(m-- > 0)
				System.in.read();
			
			System.out.println(n-1);
		}
	}
}
