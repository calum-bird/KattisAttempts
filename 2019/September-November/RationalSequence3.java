import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class RationalSequence3
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			String[] parts = br.readLine().split(" ");
			int val = Integer.parseInt(parts[1]);
			int p = 1, q = 1;
			
			int depth = (int) Math.log10(val);
			
			StringBuilder sb = new StringBuilder();
			
			for(int j = 1; j <= depth; j++)
			{
				if(val % 2 == 0)
				{
					sb.append("L");
				}
				else
				{
					sb.append("R");
				}
				
				val /= 2;
			}
			
			for(char c: sb.reverse().toString().toCharArray())
			{
				if(c == 'L')
				{
					q++;
				}
				else
				{
					p++;
				}
			}
			
			bw.write(Integer.toString(p) + "/" + Integer.toString(q) + "\n");
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}