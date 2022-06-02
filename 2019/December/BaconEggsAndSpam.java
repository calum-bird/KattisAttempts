import java.io.*;
import java.util.*;

public class BaconEggsAndSpam
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(!line.equals("0"))
		{
			HashMap<String, ArrayList<String>> menuItems = new HashMap<String, ArrayList<String>>();
			int n = Integer.parseInt(line);
			while(n-- > 0)
			{
				String[] parts = br.readLine().split(" ");
				for(int i = 1; i < parts.length; i++)
				{
					String item = parts[i];
					if(menuItems.get(item) == null)
					{
						ArrayList<String> buyers = new ArrayList<String>();
						buyers.add(parts[0]);
						
						menuItems.put(item, buyers);
					}
					else
					{
						ArrayList<String> curr = menuItems.get(item);
						if(!curr.contains(parts[0]))
							curr.add(parts[0]);
						menuItems.put(item, curr);
					}
				}
			}
			
			Map<String, ArrayList<String>> treeMap = new TreeMap<String, ArrayList<String>>(menuItems);
			
			for(Map.Entry<String, ArrayList<String>> e: treeMap.entrySet())
			{
				bw.write(e.getKey());
				ArrayList<String> names = e.getValue();
				Collections.sort(names);
				for(String s: names)
				{
					bw.write(" " + s);
				}
				bw.write("\n");
			}
			
			
			line = br.readLine();
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
