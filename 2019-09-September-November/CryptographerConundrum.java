import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class CryptographerConundrum
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] line = br.readLine().toCharArray(); //Read first line
		
		int days = 0;
		
		for (int i = 0; i < line.length; i++)
		{
	        if (i%3 == 0 && line[i] != 'P')
	        {
	        	days++;
	        }
	        if (i%3 == 1 && line[i] != 'E')
	        {
	        	days++;
	        }
	        if (i%3 == 2 && line[i] != 'R')
	        {
	        	days++;
	        }
	    }
		
		bw.write(Integer.toString(days));
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}