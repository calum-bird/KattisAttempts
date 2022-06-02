import java.io.BufferedReader;
import java.io.InputStreamReader;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ClimbingStairs
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0]); //Required number of steps
		int r = Integer.parseInt(params[1]); //Distance from ground to registration office
		int k = Integer.parseInt(params[2]); //Distance from your office to ground
		
		//int modVal = Math.floorDiv(n, k);
		
		if(r % k == 0)
		{
			System.out.println(n + r + "");
		}
		else
		{
			int sum = 0;
			int num = Math.floorDiv(n, r);
			
			sum += (num * r) + k;
			System.out.println(sum + "");
		}
		
		br.close();
	}
}