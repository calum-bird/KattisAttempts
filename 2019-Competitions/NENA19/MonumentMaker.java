import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class MonumentMaker
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0]);
		int newWidth = Integer.parseInt(params[2]);
		
		String phrase = "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			if(i%2 != 0) //If we have an odd numbered line, we must reverse the string
			{
				sb.append(br.readLine().trim());
				sb.reverse();
				phrase += sb.toString();
				sb.delete(0, sb.length());
			}
			else
			{
				phrase += br.readLine().trim();
			}
		}
		
		
		String[] words = phrase.split("\\.");
		int currLineLength = newWidth;
		int lineCount = 0;
		for(int i = 0; i < words.length; i++)
		{
			int len = words[i].length();
			
			if(currLineLength + len > newWidth)
			{
				currLineLength = 0;
				lineCount++;
			}
			
			currLineLength += len;
		}
		
		bw.write(lineCount + "\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}
/*
TEST CASES:
1:
3 24 24
IN.HONOR.OF.THE.INTERNAT
TEPMOC.GNIMMARGORP.LANOI
ITION
2:
3 24 20
IN.HONOR.OF.THE.INTERNAT
TEPMOC.GNIMMARGORP.LANOI
ITION
3:
2 23 15
THIS.IS.ANOTHER.SAMPLE.
                   TXET
*/