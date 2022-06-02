import java.io.*;
import java.util.*;

public class EstimatingAreaOfACircle
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(!line.equals("0 0 0"))
		{
			String[] parts = line.split(" ");
			
			double radius = Double.parseDouble(parts[0]);
			
			double marked = Double.parseDouble(parts[1]);
			
			double inCircle = Double.parseDouble(parts[2]);
			
			double actualArea = Math.PI*radius*radius;
			double artificialArea = inCircle/marked;
			artificialArea *= 4*(radius*radius);
			
			bw.write(actualArea + " " + artificialArea + "\n");
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
}
