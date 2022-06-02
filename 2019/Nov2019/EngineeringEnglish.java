import java.io.*;
import java.util.*;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class EngineeringEnglish
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> uniqueWords = new ArrayList<String>();
		
		String line = br.readLine();
		while(line != null)
		//while(!line.equals(""))
		{
			for(String w: line.split(" "))
			{
				if(!uniqueWords.contains(w.toLowerCase()))
				{
					uniqueWords.add(w.toLowerCase());
					sb.append(w + " ");
				}
				else
				{
					sb.append(". ");
				}
			}
			sb.append("\n");
			line = br.readLine();
		}
		
		System.out.print(sb);
		
		br.close();
		bw.close(); //Cleanup the writer
	}
}
