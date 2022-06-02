import java.io.*;
import java.util.*;

public class Beekeeper
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Character, Integer> mapChars = new HashMap<Character, Integer>();
		mapChars.put('a', 0);
		mapChars.put('e', 1);
		mapChars.put('i', 2);
		mapChars.put('o', 3);
		mapChars.put('u', 4);
		mapChars.put('y', 5);
		
		String line = br.readLine();
		while(!line.equals("0"))
		{
			int n = Integer.parseInt(line);
			int[][] repeats = new int[n][6];
			String[] words = new String[n];
			for(int i = 0; i < n; i++)
			{
				String w = br.readLine();
				words[i] = w;
				
				char[] word = w.toCharArray();
				char last = ' ';
				Boolean checked = false;
				for(char c: word)
				{
					if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||  c == 'y')
					{
						if(c == last && !checked)
						{
							repeats[i][mapChars.get(c)]++;
							checked = true;
						}
						else
						{
							checked = false;
						}
						
					}
					else
					{
						checked = false;
					}
					
					last = c;
				}
			}
			
			int maxCounter = 0;
			int maxIndex = 0;
			for(int i = 0; i < n; i++)
			{
				int counter = 0;
				for(int val: repeats[i])
				{
					counter += val;
				}
				
				if(counter > maxCounter)
				{
					maxCounter = counter;
					maxIndex = i;
				}
			}
			
			bw.write(words[maxIndex] + "\n");
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
	}
}
