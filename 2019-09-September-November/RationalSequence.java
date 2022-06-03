import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class RationalSequence
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		while(x-- > 0)
		{	
			String[] parts = br.readLine().split(" ");
			
			bw.write(parts[0] + " ");
			
			int numerator = Integer.parseInt(parts[1].split("/")[0]);
			int denominator = Integer.parseInt(parts[1].split("/")[1]);
			
			int depth = (int) Math.log10(getIndex(numerator, denominator));
			
			int currBreadthIndex = getBreadthIndex(numerator, denominator);
			if(currBreadthIndex == depth)
			{
				bw.write(Integer.toString(denominator) + "/" + Integer.toString(numerator) + "\n");
			}
			else
			{
				if(denominator == 1)
				{
					bw.write("1/" + Integer.toString(numerator+1) + "\n");
				}
				else if(numerator == 1)
				{
					bw.write(Integer.toString(denominator) + "/" + Integer.toString(numerator+1) + "\n");
				}
				else if(numerator > denominator)
				{
					bw.write(Integer.toString(denominator) + "/" + Integer.toString(numerator) + "\n");
				}
				else
				{
					bw.write(Integer.toString(numerator) + "/" + Integer.toString(denominator) + "\n");
				}
			}
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static int getBreadthIndex(int p, int q)
	{
		int tempP = p, tempQ = q;
		int index = 0;
		while(tempP != 1)
		{
			if(tempP > tempQ)
			{
				tempP -= tempQ;
			}
			else
			{
				tempQ -= tempP;
			}
			
			index++;
		}
		
		return index;
	}
	
	static int getIndex(int p, int q)
	{
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
		
		return currIndex;
	}
}