import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SecretChamber
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Get first line
		int m = Integer.parseInt(parts[0]);
		int n = Integer.parseInt(parts[1]);
		
		char[][] translations = new char[m][2];
		
		for(int i = 0; i < m; i++)
		{
			String[] newParts = br.readLine().split(" ");
			translations[i][0] = newParts[0].charAt(0);
			translations[i][1] = newParts[1].charAt(0);
		}
		
		for(int i = 0; i < n; i++)
		{
			String[] words = br.readLine().split(" ");
			String w1 = words[0];
			String w2 = words[1];
			
			if(w1.length() == w2.length())
			{
				boolean success = true;
				for(int j = 0; j < w1.length(); j++)
				{
					boolean[] letterChecks = new boolean[26];
					
					char c1 = w1.charAt(j);
					char c2 = w2.charAt(j);
					
					char translation = compareCharacter(c1, c2, translations, letterChecks);
					bw.write("Initial translation: " + translation + "\n");
					if(translation != c2)
					{
						success = false;
					}
				}
				
				if(success)
					bw.write("yes\n");
				else
					bw.write("no\n");
			}
			else
			{
				bw.write("no\n");
			}
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	public static char compareCharacter(char c, char objective, char[][] translations, boolean[] checks)
	{
		char result = c;
		if(checks[c - 'a'])
			return c;
		
		checks[c - 'a'] = true;
		
		if(c == objective)
			return result;
		
		for(int i = 0; i < translations.length; i++)
		{
			if(translations[i][0] == c)
			{
				result = translations[i][1];
				if(result == objective)
				{
					return result;
				}
			}
		}
		
		if(c != result)
		{	
			result = compareCharacter(result, objective, translations, checks);
		}
		
		return result;
	}
}

/*
2 1
a b
b c
a c
*/