import java.io.*;
import java.util.*;

public class Treasure
{
    static final int plainCost = 1;
    static final int forestCost = 2;
    static final int mountainCost = 3;
    static final int INFINITY = 999999; //Essentially impassable

    private static int numNodes;
    private static List<List<Neighbour>> adjList;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int stamina = Integer.parseInt(params[2]);

        numNodes = n*m;

        adjList = new ArrayList<List<Neighbour>>();
        for(int i = 0; i < numNodes; i++)
        {
            adjList.add(new ArrayList<Neighbour>());
        }

        int startNode = 0;
        int endNode = 0;
        

        //Read in the board and outdegrees
        char[][] board = new char[m][n];
        for(int i = 0; i < n; i++)
        {
            board[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++)
            {
                if(board[i][j] == 'S')
                    startNode = getNodeId(i, j, m);
                else if(board[i][j] == 'G')
                    endNode = getNodeId(i, j, m);
            }
        }
        br.close();

        //Initialize the adjacency matrix with our nodes and weights
        for(int i = 0; i < m; i++)
        {
            char[] row = board[i];
            for(int j = 0; j < n; j++)
            {
                if(i + 1 < m)
                {
                    Neighbour neighbour = new Neighbour(getNodeId(i+1, j, n), plainCost);
                    switch(board[i+1][j])
                    {
                        case '.':
                            neighbour = new Neighbour(getNodeId(i+1, j, n), plainCost);
                            break;
                        case 'F':
                            neighbour = new Neighbour(getNodeId(i+1, j, n), forestCost);
                            break;
                        case 'M':
                            neighbour = new Neighbour(getNodeId(i+1, j, n), mountainCost);
                            break;
                        case '#':
                            neighbour = new Neighbour(getNodeId(i+1, j, n), INFINITY);
                            break;
                        case 'G':
                            neighbour = new Neighbour(getNodeId(i+1, j, n), plainCost);
                            break;
                        case 'S':
                            neighbour = new Neighbour(getNodeId(i+1, j, n), plainCost);
                            break;
                    }

                    adjList.get(getNodeId(i, j, n)).add(neighbour);
                }
                if(i - 1 > 0)
                {
                    Neighbour neighbour = new Neighbour(getNodeId(i-1, j, n), plainCost);
                    switch(board[i-1][j])
                    {
                        case '.':
                            neighbour = new Neighbour(getNodeId(i-1, j, n), plainCost);
                            break;
                        case 'F':
                            neighbour = new Neighbour(getNodeId(i-1, j, n), forestCost);
                            break;
                        case 'M':
                            neighbour = new Neighbour(getNodeId(i-1, j, n), mountainCost);
                            break;
                        case '#':
                            neighbour = new Neighbour(getNodeId(i-1, j, n), INFINITY);
                            break;
                        case 'G':
                            neighbour = new Neighbour(getNodeId(i-1, j, n), plainCost);
                            break;
                        case 'S':
                            neighbour = new Neighbour(getNodeId(i-1, j, n), plainCost);
                            break;
                    }
                    adjList.get(getNodeId(i, j, n)).add(neighbour);
                }
                if(j + 1 < n)
                {
                    Neighbour neighbour = new Neighbour(getNodeId(i, j+1, n), plainCost);
                    switch(board[i][j+1])
                    {
                        case '.':
                            neighbour = new Neighbour(getNodeId(i, j+1, n), plainCost);
                            break;
                        case 'F':
                            neighbour = new Neighbour(getNodeId(i, j+1, n), forestCost);
                            break;
                        case 'M':
                            neighbour = new Neighbour(getNodeId(i, j+1, n), mountainCost);
                            break;
                        case '#':
                            neighbour = new Neighbour(getNodeId(i, j+1, n), INFINITY);
                            break;
                        case 'G':
                            neighbour = new Neighbour(getNodeId(i, j+1, n), plainCost);
                            break;
                        case 'S':
                            neighbour = new Neighbour(getNodeId(i, j+1, n), plainCost);
                            break;
                    }
                    adjList.get(getNodeId(i, j, n)).add(neighbour);
                }
                if(j - 1 > 0)
                {
                    Neighbour neighbour = new Neighbour(getNodeId(i, j-1, n), plainCost);
                    switch(board[i][j-1])
                    {
                        case '.':
                            neighbour = new Neighbour(getNodeId(i, j-1, n), plainCost);
                            break;
                        case 'F':
                            neighbour = new Neighbour(getNodeId(i, j-1, n), forestCost);
                            break;
                        case 'M':
                            neighbour = new Neighbour(getNodeId(i, j-1, n), mountainCost);
                            break;
                        case '#':
                            neighbour = new Neighbour(getNodeId(i, j-1, n), INFINITY);
                            break;
                        case 'G':
                            neighbour = new Neighbour(getNodeId(i, j-1, n), plainCost);
                            break;
                        case 'S':
                            neighbour = new Neighbour(getNodeId(i, j-1, n), plainCost);
                            break;
                    }
                    adjList.get(getNodeId(i, j, n)).add(neighbour);
                }
            }
        }

        int[] dist = dijkstra(startNode);
        for(int i: dist)
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.println("Destination: " + dist[endNode]);
        System.out.println("Days: " + ((stamina/dist[endNode]) + (dist[endNode]%stamina)));
    }

    private static int[] dijkstra(int start)
    {
        //Initialize dist array to our "infinity" value
        int[] dist = new int[numNodes];
        Arrays.fill(dist, INFINITY);
        dist[start] = 0;

        //Initialize the marked array to false
        boolean[] marked = new boolean[numNodes];
        Arrays.fill(marked, false);

        //Create a priority queue of type "Entry"
        PriorityQueue<Entry> pq = new PriorityQueue<Entry>();

        //Add our start node
        Entry startEntry = new Entry(start, dist[start]);
        pq.add(startEntry);

        //Iterate through all other nodes
        for(int i = 0; i < numNodes; i++)
        {
            for(int j = 0; j < adjList.get(i).size(); j++)
            {
                //Create an entry for a given node
                Neighbour node = adjList.get(i).get(j);
                int nodeID = node.getNodeID();
                Entry entry = new Entry(nodeID, dist[nodeID]);
                //Add it to the priority queue
                pq.add(entry);
            }
        }

        //While pq is not empty...
        while(pq.peek() != null)
        {
            //Poll the next node entry
            Entry node = pq.poll();
            //Grab nodeID
            int nodeID = node.getNodeID();
            //Ensure it is not "infinity", otherwise, break out of the algorithm per lab suggestion #3
            if(node.getDist() == INFINITY)
                break;
            
            //If it is not marked...
            if(!marked[nodeID])
            {
                //Mark it
                marked[nodeID] = true;

                //Iterate through neighbours
                for(Neighbour neighbour: adjList.get(nodeID))
                {
                    int neighbourID = neighbour.getNodeID();
                    if(!marked[neighbourID])
                    {
                        //Check distances
                        int edgeWeight = neighbour.getWeight();
                        int currDist = dist[neighbourID];

                        int newDist = dist[nodeID] + edgeWeight;
                        //Compare new path to old path
                        if(newDist < currDist)
                        {
                            //If quicker, reassign distance
                            dist[neighbourID] = newDist;

                            //Also, add a new entry to the priority queue
                            Entry entry = new Entry(neighbourID, dist[neighbourID]);
                            pq.add(entry);
                        }
                    }
                }
            }
        }

        //Return our dist array
        return dist;
    }

    private static int getNodeId(int i, int j, int rowLength)
    {
        return i*rowLength + j;
    }
}

class Entry implements Comparable
{
    private int nodeID;
    private int dist;

    public Entry(int _nodeID, int _dist)
    {
        nodeID = _nodeID;
        dist = _dist;
    }

    public int getNodeID()
    {
        return nodeID;
    }
    public int getDist()
    {
        return dist;
    }
    public void setNodeID(int _nodeID)
    {
        nodeID = _nodeID;
    }
    public void setDist(int _dist)
    {
        dist = _dist;
    }

    @Override
    public int compareTo(Object entry)
    {
        int dist2 = ((Entry)entry).getDist();
        int delta = dist-dist2;

        return dist-dist2;
    }
}

class Neighbour
{
    private int nodeID;
    private int weight;

    public Neighbour(int _nodeID, int _weight)
    {
        nodeID = _nodeID;
        weight = _weight;
    }

    public int getNodeID()
    {
        return nodeID;
    }
    public int getWeight()
    {
        return weight;
    }
    public void setNodeID(int _nodeID)
    {
        nodeID = _nodeID;
    }
    public void setWeight(int _weight)
    {
        weight = _weight;
    }
}