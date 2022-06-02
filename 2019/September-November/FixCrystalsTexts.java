import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class FixCrystalsTexts
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		HashMap<Character, Character> translation = new HashMap<Character, Character>();
		
		char[] greek = "αβψδεφγηιξκλμνοπ;ρστθωςχυζ".toCharArray();
		for(int i = 0; i < 26; i++)
		{
			translation.put(greek[i], (char)(i+97));
		}
			
		
		char[] line = br.readLine().toLowerCase().toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c: line)
		{
			if(translation.containsKey(c))
				sb.append(translation.get(c));
			else
				sb.append(c);
		}
		
		System.out.println(sb);
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}