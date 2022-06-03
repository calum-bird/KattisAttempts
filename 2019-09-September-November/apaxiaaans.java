import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class apaxiaaans
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String line = br.readLine(); //Read first line
		String newLine = "";
		
		char prevC = 0;
		for(char c: line.toCharArray())
		{
			if(c != prevC)
			{
				newLine = newLine + Character.toString(c);
			}
			
			prevC = c;
		}
		
		bw.write(newLine);

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}