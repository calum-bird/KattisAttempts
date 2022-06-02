import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class EasyAsCab
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Take in initial parameters
		String[] params = br.readLine().split(" ");
		int n = params[0].charAt(0) - 96;
		int lineCount = Integer.parseInt(params[1]);
		
		
		//Initialize adjacency list and inDegree array
		LinkedList<Integer>[] adj = new LinkedList[n];
		for(int i = 0; i < n; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
		int[] inDegree = new int[n];
		

		Boolean failed = false;
		
		int conflictCount = 0;
		char[][] lines = new char[lineCount][];
		for(int i = 0; i < lineCount; i++)
		{
			char[] line = br.readLine().toCharArray();
			
			if(i > 0)
			{
				char[] prev = lines[i-1];
				
				for(int j = 0; j < Math.min(line.length, prev.length); j++)
				{
					char cur = line[j];
					char pre = prev[j];
					
					if(cur != pre)
					{
						//Create an edge
						int x = pre-97;
						int y = cur-97;
						if(!adj[x].contains(y))
						{
							inDegree[y]++; //Incoming node to 'next'? Increment the inDegree @ 'next'
						}
						
						adj[x].add(y); //Add the edge from 'curr'-1 to 'next' to the adjacency list
						conflictCount++;
						break;
					}
				}
			}
			
			lines[i] = line;
		}

		if(conflictCount ==  0 && lineCount > 1)
		{
			System.out.println("AMBIGUOUS");
			failed = true;
		}
		
		//Initialize our queue for source nodes
		Queue<Integer> sources = new ArrayDeque<Integer>();
		for(int i = 0; i < n; i++)
		{
			if(inDegree[i] == 0)
				sources.add(i);
		}
		
		//Initialize our counter for nodes visited so far, and our result ArrayList
		int count = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		while(!sources.isEmpty() && !failed)
		{
			int src = sources.poll();
			res.add(src);
			
			for(int node: adj[src])
			{
				if(--inDegree[node] == 0)
					sources.add(node);
			}
			
			if(sources.size() > 1)
			{
				System.out.println("AMBIGUOUS");
				failed = true;
			}
			
			count++;
		}
		
		
		if(count != n && !failed)
		{
			System.out.println("IMPOSSIBLE");
		}
		else if(!failed)
		{
			for(int v: res)
				System.out.print((char)(v+97));
			System.out.print("\n");
		}
		
		br.close();
	}
}