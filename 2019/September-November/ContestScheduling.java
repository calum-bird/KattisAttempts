import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ContestScheduling
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		HashMap<Integer, HashSet<Integer>> forbiddenDates = new HashMap<Integer, HashSet<Integer>>();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		int numViable = 0;
		
		int f = Integer.parseInt(br.readLine());
		while(f-- > 0)
		{
			String[] parts = br.readLine().split(" ");
			int year = Integer.parseInt(parts[0]);
			int date = Integer.parseInt(parts[2]);
			
			if(forbiddenDates.get(year) != null)
			{
				HashSet<Integer> temp = forbiddenDates.get(year);
				temp.add(date);
				forbiddenDates.put(year, temp);
			}
			else
			{
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.add(date);
				forbiddenDates.put(year, temp);
			}
		}
		
		for(int i = 0; i < x; i++)
			if(forbiddenDates.get(2018+i) == null)
				forbiddenDates.put(2018+i, new HashSet<Integer>());
		
		for(int i = 1; i <= x; i++)
		{
			int year = 2018 + i;
			HashSet<Integer> forbidden = forbiddenDates.get(year);
			LocalDate OctFirst = LocalDate.of(year, 10, 1);
			int dayOfWeek = OctFirst.getDayOfWeek().getValue();
			int firstFridayDate = ((5 - dayOfWeek) + 1 <= 0) ? (5 - dayOfWeek + 8) : (5 - dayOfWeek + 1);
			
			if(firstFridayDate - 4 > 0)
			{
				forbidden.add(firstFridayDate);
			}
			else
			{
				forbidden.add(firstFridayDate + 7);
			}
			
			int[] fridays;
			if(firstFridayDate < 4)
				fridays = new int[5];
			else
				fridays = new int[4];
			
			
			for(int j = 0; j < fridays.length; j++)
			{
				int date = firstFridayDate + (7*(j));
				fridays[j] = date;
			}
			
			HashSet<Integer> current = forbiddenDates.get(year);
			
			ArrayList<Integer> viable = new ArrayList<Integer>();
			for(int d: fridays)
			{
				if(!current.contains(d))
				{
					viable.add(d);
					numViable++;
					bw.write(year + " " + d + "\n");
				}
			}
			
			adj.add(viable);
		}
		
		double[][] matrix = new double[numViable][numViable];
		
		
		
		//**************************
		//Use the arraylist of arraylists 'adj' and convert to an adjacency matrix here
		//**************************
		
		
		
		double shortestPath = dijkstra(matrix, 0, matrix.length, x);
		bw.write(Double.toString(shortestPath) + "\n");
		
		//TODO: output all dates used in the path
		/*
		bw.write(Integer.toString(cost));
		for(int i = 0; i < x; i++)
		{
			bw.write(Integer.toString(2019+i) + val[i+1]);
		}
		*/
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static double dijkstra(double[][] adj, int start, int end, int yearCount)
	{
		//TODO: implement outputting the path taken, as well as the total cost
		//double[] val = new double[yearCount+1];
		int n = adj.length;
		boolean[] visited = new boolean[n];
		double[] min = new double[n];
		Arrays.fill(min, Double.POSITIVE_INFINITY);
		Queue<QNode> q = new PriorityQueue<>();
		q.add(new QNode(start, 0));
		min[start] = 0;
		while(!q.isEmpty())
		{
			QNode qNode = q.remove();
			int u = qNode.index;
			
			if(visited[u])
				continue;
			visited[u] = true;
			
			for(int v = 0; v < n; v++)
			{
				double newCost = min[u] + adj[u][v];
				if(newCost < min[v])
				{
					min[v] = newCost;
					q.add(new QNode(v, newCost));
				}
			}
		}
		
		return min[end];
	}
}

class QNode implements Comparable<QNode>
{
	int index;
	double cost;
	public QNode(int index, double cost)
	{
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(QNode other)
	{
		return Double.compare(this.cost, other.cost);
	}
}