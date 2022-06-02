import java.io.*;
import java.util.*;

public class DifferentDistances
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(!line.equals("0"))
		{
			String[] parts = line.split(" ");
			double x1 = Double.parseDouble(parts[0]);
			double y1 = Double.parseDouble(parts[1]);
			double x2 = Double.parseDouble(parts[2]);
			double y2 = Double.parseDouble(parts[3]);
			double p = Double.parseDouble(parts[4]);
			
			double res = Math.pow(Math.pow(Math.abs(x1-x2), p) + Math.pow(Math.abs(y1-y2), p), (1/p));
			bw.write(res + "\n");
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
}
