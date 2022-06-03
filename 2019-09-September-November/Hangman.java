import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Hangman
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer

		String word = br.readLine();
		char[] input = br.readLine().toCharArray();
		
		int wrongAttempts = 0;
		
		ArrayList<Character> uniqueChars = getUniqueChars(word);
		
		int[] occuranceCount = new int[26];
		
		boolean lost = false;
		
		for(int i = 0; i < input.length; i++)
		{
			char c = input[i];
			if(!uniqueChars.contains((Object)c))
			{
				wrongAttempts++;
			}
			else
			{
				occuranceCount[c-'A'] = getOccuranceOfChar(word, c);
			}
			
			boolean found = checkWordFound(word, occuranceCount) ? true: false;
			if(found)
				break;
		}
		
		if(wrongAttempts >= 10)
		{
			lost = true;
		}
		
		if(lost)
			bw.write("LOSE");
		else
			bw.write("WIN");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static boolean checkWordFound(String w, int[] occurances)
	{
		int count = 0;
		
		for(int i = 0; i < w.length(); i++)
		{
			char c = w.charAt(i);
			if(occurances[c-'A'] > 0)
				count++;
		}
		
		return ((count == w.length()) ? true: false);
	}
	
	private static int getOccuranceOfChar(String word, char c)
	{
		int count = 0;
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == c)
				count++;
		}
		
		return count;
	}
	
	private static ArrayList<Character> getUniqueChars(String word)
	{
		ArrayList<Character> result = new ArrayList<Character>();
		char[] w = word.toCharArray();
		for(int i = 0; i < w.length; i++)
		{
			if(!result.contains((Object)w[i]))
				result.add(w[i]);
		}
		
		return result;
	}
}