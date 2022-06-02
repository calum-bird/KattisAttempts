import java.io.*;
import java.util.*;

public class GasStationNumbers
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(!line.equals("."))
		{		
			String newLine = line.replace(".", "");
			char[] lineArr = newLine.toCharArray();
			boolean found = false;
			for(int i = lineArr.length - 1; i >= 0; i--)
			{
				char curr = lineArr[i];
				char currFlipped = getFlipped(curr);
				
				//Can the current character be flipped to a higher value?
				if(currFlipped > curr)
				{
					//If yes, flip it in the array
					lineArr[i] = currFlipped;
					
					//Now, iterate through all previous chars and flip them to a lower value if possible
					for(int j = i+1; j < lineArr.length; j++)
					{
						char prev = lineArr[j];
						char prevFlipped = getFlipped(prev);
						if(prevFlipped < prev)
						{
							lineArr[j] = prevFlipped;
						}
					}
					
					found = true;
					break;
				}
				else
				{
					//If no, check to swap with the next character
					if(i != 0)
					{
						char next = lineArr[i-1];
						char nextFlipped = getFlipped(next);
						
						//If current is greater than next, swap the two
						if(curr > next)
						{
							lineArr[i-1] = curr;
							lineArr[i] = next;
							//Flip the swapped one if possible
							if(currFlipped > next)
							{
								lineArr[i-1] = currFlipped;
							}
							
							//Now, try to flip all previous to a lower value
							for(int j = i; j < lineArr.length; j++)
							{
								char prev = lineArr[j];
								char prevFlipped = getFlipped(prev);
								if(prevFlipped < prev)
								{
									lineArr[j] = prevFlipped;
								}
							}
							
							found = true;
							break;
						}
					}
				}
			}
			
			
			//Reconstruct our new line
			StringBuilder sb = new StringBuilder();
			sb.append(lineArr);
			sb.insert(lineArr.length - 1, '.');
			
			if(!found)
			{
				bw.write("The price cannot be raised\n");
			}
			else
			{
				bw.write(sb.toString() + "\n");
			}
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
	
	static char getFlipped(char c)
	{
		switch(c)
		{
			case '2':
				return '5';
			case '5':
				return '2';
			case '6':
				return '9';
			case '9':
				return '6';
		}
		
		return c;
	}
}
