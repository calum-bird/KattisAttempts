import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class GrandpaBernie
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		HashMap<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();
		
		while(x-- > 0)
		{
			String[] parts = br.readLine().split(" ");
			String country = parts[0];
			int year = Integer.parseInt(parts[1]);
			if(data.containsKey(country))
			{
				data.get(country).add(year);
			}
			else
			{
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(year);
				data.put(country, t);
			}
		}
		
		for(Entry<String, ArrayList<Integer>> e: data.entrySet())
		{
			Collections.sort(e.getValue());
		}
		
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0)
		{
			String[] parts = br.readLine().split(" ");
			String country = parts[0];
			int v = Integer.parseInt(parts[1]);
			bw.write(Integer.toString(data.get(country).get(v-1)) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}