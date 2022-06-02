import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DelimiterSoup
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		br.readLine(); //Read first line
		
		char[] line = br.readLine().toCharArray();
		
		ArrayDeque<Character> q = new ArrayDeque<Character>();
		
		boolean success = true;
		int count = 0;
		for(char c: line)
		{
			if(c != ' ' && !closingChar(c))
			{
				q.push(c);
			}
			else if(c != ' ')
			{
				if(q.size() > 0 && q.peek() == getOppositeOpening(c))
				{
					q.poll();
					count+= 2;
				}
				else
				{
					bw.write(c + " " + (q.size() + count));
					success = false;
					break;
				}
			}
			else if(c == ' ')
			{
				count++;
			}
		}
		
		if(success)
			bw.write("ok so far");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static boolean closingChar(char c)
	{
		if(c == '[' || c == '{' || c == '(')
		{
			return false;
		}
		
		return true;
	}
	
	static char getOppositeClosing(char c)
	{
		switch (c)
		{
			case '[':
				return ']';
			case '{':
				return '}';
			case '(':
				return ')';
		}
		
		return ' ';
	}
	
	static char getOppositeOpening(char c)
	{
		switch(c)
		{
			case ']':
				return '[';
			case '}':
				return '{';
			case ')':
				return '(';
		}
		
		return ' ';
	}
}