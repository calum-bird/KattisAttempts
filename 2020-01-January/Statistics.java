import java.io.*;

public class Statistics
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String line = br.readLine();
		int counter = 1;
		while(line != null && !line.equals(""))
		{
			String[] parts = line.split(" ");
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i = 1; i < parts.length; i++)
			{
				String s = parts[i];
				int v = Integer.parseInt(s);
				if(v < min)
					min = v;
				if(v > max)
					max = v;
			}
			
			System.out.println("Case " + counter + ": " +  min + " " + max + " " + (max-min));
			counter++;
			line = br.readLine();
		}
		
		br.close();
	}
}
