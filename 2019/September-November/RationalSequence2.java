import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class RationalSequence2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 1; i < x + 1; i++)
		{
			String[] parts = br.readLine().split(" ");
			String[] fraction = parts[1].split("/");
			
			int p = Integer.parseInt(fraction[0]);
			int q = Integer.parseInt(fraction[1]);
			
			StringBuilder sb = new StringBuilder();
			
			while(p > 1 || q > 1)
			{
				if(p > q)
				{
					p -= q;
					sb.append("R");
				}
				else
				{
					q -= p;
					sb.append("L");
				}
			}
			
			int currIndex = 1;
			String s = sb.reverse().toString();
			for(char c: s.toCharArray())
			{
				currIndex *= 2;
				if(c == 'R')
					currIndex++;
			}
			
			bw.write(Integer.toString(i) + " " + Integer.toString(currIndex) + "\n");
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}