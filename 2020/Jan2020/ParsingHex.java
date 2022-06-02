import java.io.*;
import java.util.*;

public class ParsingHex
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		//while(!line.equals(""))
		while(line != null && line.length() != 0)
		{
			ArrayList<String> hexStrings = new ArrayList<String>();
		
			char[] chars = line.toCharArray();
			Boolean inHexString = false;
			int currLength = 0;
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < chars.length; i++)
			{
				char curr = chars[i];
				if(inHexString)
				{
					if((curr >= '0' && curr <= '9') || (curr >= 'a' && curr <= 'f') || (curr >= 'A' && curr <= 'F'))
					{
						if(currLength + 1 > 8)
						{
							hexStrings.add(sb.toString());
							currLength = 0;
							inHexString = false;
							sb.setLength(0);
						}
						
						if(inHexString)
						{
							currLength++;
							sb.append(curr);
						}
					}
					else
					{
						hexStrings.add(sb.toString());
						currLength = 0;
						inHexString = false;
						sb.setLength(0);
						
					}
				}
				else if(curr == '0' && i < chars.length - 1)
				{
					char next = chars[i+1];
					if(next == 'x' || next == 'X')
					{
						//We hit a string, record this index
						if(i+1 < chars.length-1)
						{
							inHexString = true;
							currLength = 0;
							sb.append("0");
							sb.append(next);
							i++;
						}
					}
				}
			}
			
			if(inHexString)
			{
				hexStrings.add(sb.toString());
			}
			
			for(String hex: hexStrings)
			{
				if(hex.length() > 2)
				{
					int dec = Integer.parseInt(hex.substring(2, hex.length()), 16);
					System.out.println(hex + " " + dec);
				}
			}
			
			line = br.readLine();
		}
		
		br.close();
	}
}

//Test case
/*
uyzrr0x5206aBCtrrwm0Xa8aD4poqwqr
pqovx0x6d3e6-+ 230xB6fcgmmm0x875

*/
