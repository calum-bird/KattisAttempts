import java.io.BufferedReader;
import java.io.InputStreamReader;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class GuessTheDataStructure
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		while(!line.equals(""))
		{
			int n = Integer.parseInt(line);
			int[] vals = new int[n/2];
			while(n-- > 0)
			{
				String[] parts = br.readLine().split(" ");
				int cType = Integer.parseInt(parts[0]);
				int val = Integer.parseInt(parts[1]);
				//vals[(n+1)/2] = val;
				System.out.println(n + n%2 + "");
			}
			
			line = br.readLine();
		}
		
		br.close();
	}
}