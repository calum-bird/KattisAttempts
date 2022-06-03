import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class AlphabetSpam
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] line = br.readLine().toCharArray(); //Read first line
		
		int whiteSpaceCount = 0;
		int lowerCaseCount = 0;
		int symbolCount = 0;
		int upperCaseCount = 0;
		
		for(int i  = 0; i < line.length; i++)
		{
			if(line[i] == '_')
				whiteSpaceCount++;
			else if(Character.isLowerCase(line[i]))
				lowerCaseCount++;
			else  if(Character.isUpperCase(line[i]))
				upperCaseCount++;
			else
				symbolCount++;
		}
		
		bw.write(Double.toString((double)whiteSpaceCount/line.length) + "\n");
		bw.write(Double.toString((double)lowerCaseCount/line.length) + "\n");
		bw.write(Double.toString((double)upperCaseCount/line.length) + "\n");
		bw.write(Double.toString((double)symbolCount/line.length) + "\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}