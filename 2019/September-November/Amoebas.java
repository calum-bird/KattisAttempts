import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Amoebas
{
	static int[][] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] first = br.readLine().split(" ");
		int x = Integer.parseInt(first[0]);
		int n = Integer.parseInt(first[1]);
		
		int numNodes = x*n;
		LinkedList<Integer>[] adjListArray = new LinkedList[numNodes];
		
		for(int i = 0; i < numNodes ; i++)
		{ 
            adjListArray[i] = new LinkedList<Integer>(); 
        }
		
		char[][] matrix = new char[x][n];
		
		for(int i = 0; i < x; i++)
		{
			char[] parts = br.readLine().toCharArray();
			for(int j = 0; j < n; j++)
			{
				if(parts[j] == '#')
				{
					if(j == 0)
					{
						 if(parts[j + 1] == '#')
						 {
							 
						 }
					}
					else if(j == n)
					{
						
					}
					else
					{
						
					}
				}
				else
				{
					
				}
			}
		}
		
		
		int counter = 0;
		boolean[] visited = new boolean[numNodes];
		
		for(int i = 0; i < visited.length; i++)
		{
			if(!visited[i])
			{
				dfs(i, visited);
				counter++;
			}
		}
		
		bw.write(Integer.toString(counter));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	private static void dfs(int v, boolean[] visited)
	{
		if(visited[v])
			return;
		
		visited[v] = true;
		int[] neighbours = adj[v];
		for(int n: neighbours)
			dfs(n, visited);
	}
}