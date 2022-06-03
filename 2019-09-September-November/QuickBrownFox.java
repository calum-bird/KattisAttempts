import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class QuickBrownFox
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		while(n-- > 0)
		{
			char[] line = br.readLine().toLowerCase().toCharArray();
			String res = isPangram(line);
			if(res == "")
				bw.write("pangram\n");
			else
				bw.write("missing " + res + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static String isPangram(char[] phrase)
	{
		boolean[] validity = new boolean[26];
		Arrays.fill(validity, false);
		for(char c: phrase)
		{
			if(c != ' ' && c > 96 && c < 123)
			{
				validity[c-97] = true;
			}
		}
		
		String res = "";
		for(int i = 0; i < 26; i++)
		{
			if(!validity[i])
				res += (char)(i+97);
		}
		
		return res;
	}
}