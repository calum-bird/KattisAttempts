import java.io.*;
import java.util.*;

public class JanitorTroubles
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1]);
		int c = Integer.parseInt(params[2]);
		int d = Integer.parseInt(params[3]);
		
		double perim = (a+b+c+d)/2.0d;
		
		bw.write(Math.sqrt((perim - a) * (perim - b) * (perim - c) * (perim - d)) + "");
		
		br.close();
		bw.close();
	}
}
