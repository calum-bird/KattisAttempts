import java.io.*;
import java.util.*;

public class DivideBy100
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] first = br.readLine().toCharArray();
		int second = br.readLine().length();
		
		StringBuilder sb = new StringBuilder();
		if(second > first.length)
		{
			int zeroesToAdd = second - first.length - 1;
			sb.insert(0, "0.");
			char[] buff = new char[zeroesToAdd];
			Arrays.fill(buff, '0');
			sb.append(buff);
			sb.append(first);
		}
		else
		{
			sb.append(first);
			int offset = first.length - second + 1;
		    	sb.insert(offset, '.');
		    	if(sb.charAt(0) == '.')
		    	{
		        	sb.insert(0, '0');
			}
			
			for(int i = sb.length() - 1; i >= sb.lastIndexOf("."); i--)
			{
				if(sb.charAt(i) == '0')
					sb.deleteCharAt(i);
				else
					break;
			}
		}
		
		if(sb.charAt(sb.length()-1) == '.')
		{
			sb.setLength(sb.length() - 1);
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
