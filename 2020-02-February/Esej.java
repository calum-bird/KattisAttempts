import java.io.*;
import java.util.*;

public class Esej
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] params = br.readLine().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1]);
		
		StringBuilder essay = new StringBuilder();
		Random rand = new Random();
		
		int num = (a + (b-a)/2);
		
		while(num-- > 0)
		{
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append((char)(rand.nextInt(26)+'a'));
			essay.append(" ");
		}
		
		System.out.println(essay);
		
		br.close();
	}
}
