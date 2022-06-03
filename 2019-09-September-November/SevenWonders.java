import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SevenWonders
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		HashMap<Character, Integer> cardCount = new HashMap<Character, Integer>();
		
		char[] line = br.readLine().toCharArray();
		
		for(char c: line)
		{
			if(cardCount.get(c) != null)
			{
				cardCount.put(c, cardCount.get(c) + 1);
			}
			else
			{
				cardCount.put(c, 1);
			}
		}
		
		int score = 0;
		
		for(Entry<Character, Integer> entry: cardCount.entrySet())
		{
			int count = entry.getValue();
			score += count*count;
		}
		
		if(cardCount.size() == 3)
		{
			int extraCount = 50;
			for(Entry<Character, Integer> entry: cardCount.entrySet())
			{
				if(entry.getValue() < extraCount)
					extraCount = entry.getValue();
			}
			
			score+= 7*extraCount;
		}
		
		bw.write(Integer.toString(score));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}