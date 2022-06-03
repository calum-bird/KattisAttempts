import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SymmetricOrder
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String startLine = br.readLine();
		int lineCount = Integer.parseInt(startLine);
		
		int setCount = 1;
		
		while(lineCount != 0)
		{
			
			if(setCount != 1)
			{
				String newLine = br.readLine();
				lineCount = Integer.parseInt(newLine);
			}
			
			ArrayList<String> firstHalf = new ArrayList<String>();
			ArrayList<String> secondHalf = new ArrayList<String>();
			
			for(int i = 0; i < lineCount; i++)
			{
				if(i == 0)
					bw.write("SET " + setCount + "\n");
				String line = br.readLine();
				if(i % 2 == 0)
				{
					firstHalf.add(line);
				}
				else
				{
					secondHalf.add(line);
				}
			}
			
			Collections.reverse(secondHalf);
			
			for(String s: firstHalf)
				bw.write(s + "\n");
			
			for(String s: secondHalf)
				bw.write(s + "\n");
			

			setCount++;
			
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}