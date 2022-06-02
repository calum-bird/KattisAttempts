import java.io.*;
import java.util.*;

public class SoftPasswords
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String stored = br.readLine();
		String password = br.readLine();
		
		boolean found = false;
		
		if(stored.equals(password))
		{
			found = true;
		}
		
		if(!found)
		{
			for(int i = 0; i < 10; i++)
			{
				if((Integer.toString(i) + password).equals(stored))
				{
					found = true;
					break;
				}
				else if((password + Integer.toString(i)).equals(stored))
				{
					found = true;
					break;
				}
			}
			
			if(!found)
			{
				StringBuilder sb = new StringBuilder();
				for(char c: password.toCharArray())
				{
					if(c >= 65 && c <= 90)
					{
						sb.append((char)(c+32));
					}
					else if(c >= 97 && c <= 122)
					{
						sb.append((char)(c-32));
					}
					else
					{
						sb.append(c);
					}
				}
				
				if(!found && sb.toString().equals(stored))
				{
					found = true;
				}
			}
		}
		
		if(found)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
		br.close();
	}
}
