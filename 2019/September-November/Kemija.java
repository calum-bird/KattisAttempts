import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Kemija
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] line = br.readLine().toCharArray();
		
		char[] res = new char[line.length];
		int counter =  0;
		for(int i = 0; i < line.length; i++)
		{
			res[counter] = line[i];
			counter++;
			if(isVowel(line[i]))
			{
				i += 2;
			}
		}
		
		for(int i = 0; i < counter; i++)
		{
			bw.write(res[i]);
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static boolean isVowel(char c)
	{
		switch(c)
		{
			case 'a':
				return true;
			case 'e':
				return true;
			case 'i':
				return true;
			case 'o':
				return true;
			case 'u':
				return true;
		}
		
		return false;
	}
}