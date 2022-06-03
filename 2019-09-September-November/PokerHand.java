import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PokerHand
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] cards = br.readLine().split(" ");
		
		HashMap<Character, Integer> hand = new HashMap<Character, Integer>();
		
		for(int i = 0; i < cards.length; i++)
		{
			char c = cards[i].charAt(0);
			if(hand.containsKey(c))
			{
				hand.put(c, hand.get(c) + 1);
			}
			else
			{
				hand.put(c, 1);
			}
		}
		
		int max = 0;
		for(Entry<Character, Integer> entry: hand.entrySet())
		{
			if(entry.getValue() > max)
				max = entry.getValue();
		}
		
		bw.write(Integer.toString(max));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}