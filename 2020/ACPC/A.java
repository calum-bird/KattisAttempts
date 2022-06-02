import java.io.*;
import java.util.*;

public class A
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node[] graph = new Node[n];

        int n = Integer.parseInt(br.readLine());

        String[] taxes = br.readLine().split(" ");

        int[] cityTaxes = new int[n];
        int[] roadTolls = new int[n];

        for(int i = 0; i < n; i++)
        {
            cityTaxes[i] = Integer.parseInt(taxes[i]);

            String[] road = br.readLine().split(" ");
            int nodeId = Integer.parseInt(road[0]);
            int secondNodeId = Integer.parseInt(road[1]);
            int toll = Integer.parseInt(road[2]);

            // Assign our road toll cost for this city to the next
            roadTolls[i] toll;

            // Create our node
            graph[i] = new Node(nodeId, secondNodeId, cityTaxes[i]);
        }

        for(int i = 0; i < n;i++)
        {
            if(graph[i] == null)
            {
                graph[i] = new Node(nodeId, -1, cityTaxes[i]);
            }
        }

        int roadTollCost = 0;
        int nextId = 1;
        Node curr = graph[0];
        while(nextId != -1)
        {
            

            nextId = curr.nextId;
            curr = graph[nextId];
        }


        br.close();
    }
}

class Node
{
    public int id;
    public int nextId;
    public int tax;

    public Node(int id, int nextId = -1, int tax)
    {
        this.id = id;
        this.nextId = nextId;
        this.tax = tax;
    }
}