import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class GameOfThrowns
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		int students = Integer.parseInt(parts[0]);
		
		String[] nextParts = br.readLine().split(" ");
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.push(0);
		
		for(int i = 0; i < nextParts.length; i++)
		{
			String s = nextParts[i];
			if(s.contains("undo"))
			{
				int next = Integer.parseInt(nextParts[i+1]);
				i++;
				while(next-- > 0)
				{
					q.pop();
				}
			}
			else
			{
				int v = Integer.parseInt(s);
				q.push((q.peek() + v) % students);
			}
		}
		
		int res = q.peek();
		if(res < 0)
		{
			res += students;
		}
		
		bw.write(Integer.toString(res) + "\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}