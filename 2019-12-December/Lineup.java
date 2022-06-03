import java.io.*;
import java.util.*;

public class Lineup
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] names = new String[n];
		for(int i = 0; i < n; i++)
		{
			names[i] = br.readLine();
		}
		
		List<String> lon = new ArrayList<String>();
		for(String s: names)
			lon.add(s);
		
		
		if(isSortedAscending(lon))
		{
			bw.write("INCREASING");
		}
		else if(isSortedDescending(lon))
		{
			bw.write("DECREASING");
		}
		else
		{
			bw.write("NEITHER");
		}
		
		br.close();
		bw.close();
	}
	
	
	static boolean isSortedAscending(List<String> listOfStrings)
	{
		if(listOfStrings.isEmpty() || listOfStrings.size() == 1)
	        {
			return true;
	        }
	 
		Iterator<String> iter = listOfStrings.iterator();
	    	String current, previous = iter.next();
	    	while(iter.hasNext())
	    	{
			current = iter.next();
			if (previous.compareTo(current) > 0)
			{
		    		return false;
			}
			previous = current;
	    	}
	    	
	    	return true;
	}
	
	static boolean isSortedDescending(List<String> listOfStrings)
	{
		if(listOfStrings.isEmpty() || listOfStrings.size() == 1)
	        {
			return true;
	        }
	 
		Iterator<String> iter = listOfStrings.iterator();
	    	String current, previous = iter.next();
	    	while(iter.hasNext())
	    	{
			current = iter.next();
			if(previous.compareTo(current) < 0)
			{
		    		return false;
			}
			previous = current;
	    	}
	    	
	    	return true;
	}
}
