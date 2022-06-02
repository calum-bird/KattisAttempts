import java.io.BufferedReader;
import java.io.InputStreamReader;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class DoublePlusGood
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			String line = br.readLine();
			line.replaceAll("+", "");
			
			
		}
		
		br.close();
	}
}