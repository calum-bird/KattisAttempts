import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ANewAlphabet
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		
		HashMap<Character, String> replacement  = new HashMap<Character, String>();
		replacement.put('a', "@");
		replacement.put('b', "8");
		replacement.put('c', "(");
		replacement.put('d', "|)");
		replacement.put('e', "3");
		replacement.put('f', "#");
		replacement.put('g', "6");
		replacement.put('h', "[-]");
		replacement.put('i', "|");
		replacement.put('j', "_|");
		replacement.put('k', "|<");
		replacement.put('l', "1");
		replacement.put('m', "[]\\/[]");
		replacement.put('n', "[]\\[]");
		replacement.put('o', "0");
		replacement.put('p', "|D");
		replacement.put('q', "(,)");
		replacement.put('r', "|Z");
		replacement.put('s', "$");
		replacement.put('t', "']['");
		replacement.put('u', "|_|");
		replacement.put('v', "\\/");
		replacement.put('w', "\\/\\/");
		replacement.put('x', "}{");
		replacement.put('y', "`/");
		replacement.put('z', "2");
		
		String line = br.readLine().toLowerCase();
		
		StringBuilder sb = new StringBuilder();
		for(char c: line.toCharArray())
		{
			String rep = replacement.get(c);
			if(rep == null)
				sb.append(c);
			else
				sb.append(rep);
		}
		
		System.out.print(sb);
		
		br.close(); //Cleanup the reader
	}
}