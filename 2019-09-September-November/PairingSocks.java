import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PairingSocks
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		br.readLine(); //Read first line
		
		int moves = 0;
		
		String line = br.readLine();
		ArrayDeque<Integer> aux = new ArrayDeque<Integer>();
		String[] parts = line.split(" ");
		
		for(String s: parts)
		{
			int val = Integer.parseInt(s);
			if(aux.size() > 0)
			{
				if(aux.peek() == val)
				{
					aux.pop();
					moves++;
				}
				else
				{
					aux.push(val);
					moves++;
				}
			}
			else
			{
				aux.push(val);
				moves++;
			}
		}
		
		if(aux.size() == 0)
		{
			bw.write(moves + "\n");
		}
		else
		{
			bw.write("impossible\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}