import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Cups
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		HashMap<String, Integer> values = new HashMap<String, Integer>();
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			
			try
			{
				int test = Integer.parseInt(parts[0]);
				String colour = parts[1];
				
				int realSize = test/2;
				values.put(colour, realSize);
			}
			catch (Exception e)
			{
				int size = Integer.parseInt(parts[1]);
				
				String colour = parts[0];
				values.put(colour, size);
			}
		}
		
		int[] vals = new int[values.size()];
		for(int i = 0; i < values.size(); i++)
		{
			vals[i] = (int) values.values().toArray()[i];
		}
		
		Arrays.sort(vals);
		
		for(int i = 0; i < vals.length; i++)
		{
			bw.write(searchForKeyByValue(values, vals[i]) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static String searchForKeyByValue(HashMap<String, Integer> values, int searchVal)
	{
		for(Entry<String, Integer> entry: values.entrySet())
		{
			if(entry.getValue() == searchVal)
				return entry.getKey();
		}
		
		return null;
	}
}