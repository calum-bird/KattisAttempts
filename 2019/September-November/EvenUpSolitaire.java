import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class EvenUpSolitaire
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		Deque<Integer> cards = new ArrayDeque<Integer>();
		
		String[] numbers = br.readLine().split(" ");
		
		for(int i = 0; i < x; i++)
		{
			String ch = numbers[i];
			int c = Integer.parseInt(ch);
			if(cards.size() > 0)
			{
				if((c + cards.peek()) % 2 != 0)
				{
					cards.push(c);
				}
				else
				{
					cards.poll();
				}
			}
			else
			{
				cards.push(c);
			}
		}
		
		bw.write(cards.size() + "\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}

/*
16
1 3 3 4 2 4 1 3 7 1 1 1 2 1 3 3
*/