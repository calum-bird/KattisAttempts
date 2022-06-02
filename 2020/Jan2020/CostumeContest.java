import java.io.*;
import java.util.*;

public class CostumeContest
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> mappedStrings = new HashMap<String, Integer>();
		
		while(n-- > 0)
		{
			String line = br.readLine();
			if(mappedStrings.containsKey(line))
			{
				mappedStrings.put(line, mappedStrings.get(line) + 1);
			}
			else
			{
				mappedStrings.put(line, 1);
			}
		}
		
		int lowest = Integer.MAX_VALUE;
		ArrayList<String> finalists = new ArrayList<String>();
		for(Map.Entry<String, Integer> e: mappedStrings.entrySet())
		{
			if(e.getValue() < lowest)
			{
				lowest = e.getValue();
				finalists.clear();
				finalists.add(e.getKey());
			}
			else if(e.getValue() == lowest)
			{
				finalists.add(e.getKey());
			}
		}
		
		Collections.sort(finalists);
		
		for(String s: finalists)
		{
			System.out.println(s);
		}
		
		br.close();
	}
}
