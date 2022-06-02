import java.io.*;
import java.util.*;

public class Kitten
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		int root = -1;
		
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		
		String line = br.readLine();
		while(!line.equals("-1"))
		{
			String[] params = line.split(" ");
			
			if(params.length == 2)
			{
				root = Integer.parseInt(params[0]);
			}
			
			ArrayList<Integer> row = new ArrayList<Integer>();
			for(int i = 0; i < params.length; i++)
			{
				row.add(Integer.parseInt(params[i]));
			}
			
			adjList.add(row);
			
			line = br.readLine();
		}
		
		int n = adjList.size();
		int lastValue = K;
		
		bw.write(lastValue + "");
		
		while(lastValue != root)
		{
			for(int i = 0; i < n; i++)
			{
				if(adjList.get(i).contains(lastValue) && adjList.get(i).get(0) != lastValue)
				{
					lastValue = adjList.get(i).get(0);
					bw.write(" " + lastValue);
					break;
				}
			}
		}
		
		br.close();
		bw.close();
	}
}
