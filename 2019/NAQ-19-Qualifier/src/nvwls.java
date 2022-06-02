import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class nvwls
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		
		HashMap<String, String> dictionary = new HashMap<String, String>();
		
		for(int i = 0; i < x; i++)
		{
			String word = br.readLine();
			
			dictionary.put(word, withoutVowels(word));
		}
		
		String sequence = br.readLine();
		
		for(String s: dictionary.values())
			if(sequence.contains(s))
				sequence.
		
		br.close();
		bw.close();
	}
	
	static String withoutVowels(String s)
	{
		char[] word = s.toCharArray();
		char[] newWord = new char[word.length];
		
		int counter = 0;
		for(char c: word)
		{
			if(c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U')
			{
				newWord[counter] = c;
				counter++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(newWord);
		sb.delete(counter, word.length);
		
		return new String(sb);
				
	}
	
	static boolean inDictionary(String word, String[] dictionary)
	{
		for(String s: dictionary)
			if(word.equals(s))
				return true;
		
		return false;
	}
	
	static int indexOfContains(String search, String str)
	{
		
	}
}
