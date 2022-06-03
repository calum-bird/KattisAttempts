import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class PickUpSticks
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Take in initial parameters
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0]);
		int lineCount = Integer.parseInt(params[1]);
		
		
		//Initialize adjacency list and inDegree array
		LinkedList<Integer>[] adj = new LinkedList[n];
		for(int i = 0; i < n; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
		int[] inDegree = new int[n];
		
		
		//Take in edge map and increment inDegree as such
		for(int i = 0; i < lineCount; i++)
		{
			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			
			inDegree[y-1]++; //Incoming node to y? Increment the inDegree @ y
			adj[x-1].add(y-1); //Add the edge from x-1 to y to the adjacency list
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
		
		while(!sources.isEmpty())
		{
			int src = sources.poll();
			res.add(src);
			
			for(int node: adj[src])
			{
				if(--inDegree[node] == 0)
					sources.add(node);
			}
			
			count++;
		}
		
		if(count != n)
		{
			System.out.print("IMPOSSIBLE");
		}
		else
		{
			for(int v: res)
				System.out.println((v+1) + "");
		}
		
		br.close();
	}
}