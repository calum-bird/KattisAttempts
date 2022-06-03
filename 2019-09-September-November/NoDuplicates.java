import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class NoDuplicates
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] line = br.readLine().split(" ");
		HashMap<String, Integer> hand = new HashMap<String, Integer>();
		
		for(int i = 0; i < line.length; i++)
		{
			String s = line[i];
			if(hand.containsKey(s))
			{
				hand.put(s, hand.get(s) + 1);
			}
			else
			{
				hand.put(s, 1);
			}
		}
		
		int max = 0;
		for(Entry<String, Integer> entry: hand.entrySet())
		{
			if(entry.getValue() > max)
				max = entry.getValue();
		}
		
		if(max > 1)
			bw.write("no");
		else
			bw.write("yes");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}