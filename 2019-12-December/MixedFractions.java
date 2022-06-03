import java.io.*;
import java.util.*;

public class MixedFractions
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		while(!line.equals("0 0"))
		{
			String[] parts = line.split(" ");
			int first = Integer.parseInt(parts[0]);
			int second = Integer.parseInt(parts[1]);
			
			int rounded = Math.floorDiv(first, second);
			int mod = first % second;
			
			bw.write(rounded + " " + mod + " / " + second + "\n");
			
			line = br.readLine();
		}
		
		bw.close();
		br.close();
	}
}
