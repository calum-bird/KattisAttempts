import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Backspace
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		char[] line = br.readLine().toCharArray(); //Read first line
		
		ArrayDeque<Character> q = new ArrayDeque<Character>();
		
		int counter = 0;
		for(char c: line)
		{
			if(c == '<')
			{
				q.pop();
				counter--;
			}
			else
			{
				q.push(c);
				counter++;
			}
		}
		
		StringBuilder sb = new StringBuilder(counter);
		
		for(char c: q)
			sb.append(c);
		
		sb.reverse();
			
		bw.write(sb.toString());

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}