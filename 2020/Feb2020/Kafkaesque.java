import java.io.*;

public class Kafkaesque
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int prev = 0;
		int counter = 1;
		int v;
		while(n-- > 0)
		{
			v = Integer.parseInt(br.readLine());
			if(v < prev)
			{
				counter++;
			}
			
			prev = v;
		}
		
		System.out.println(counter + "");
			
		br.close();
	}
}
