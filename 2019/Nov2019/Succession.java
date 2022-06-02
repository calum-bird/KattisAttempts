import java.io.*;
import java.util.*;

public class Succession
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0]);
		int m = Integer.parseInt(params[1]);
		String founder = br.readLine();
		
		HashMap<String, Tree> heritageTrees = new HashMap<String, Tree>();
		
		Tree founderTree = new Tree(founder);
		founderTree.root.fractionalVal = {1,1};
		heritageTrees.put(founder, founderTree);
		
		for(int i = 0; i < n; i++)
		{
			String[] relationship = br.readLine().split(" ");
			Tree heritage = new Tree(relationship[0]);
			
			Tree foundA = heritageTrees.get(relationship[1]);
			Tree foundB = heritageTrees.get(relationship[2]);
			
			heritage.root.children[0] = foundA;
			heritage.root.children[1] = foundB;
			
			int numerator = 0;
			int denominator = 1;
			if(foundA != null)
			{
				numerator = foundA.root.fractionalVal[0];
				denominator = foundA.root.fractionalVal[1];
			}
			
			if(foundB != null)
			{
				numerator *= foundB.root.fractionalVal[0];
				denominator *= foundB.root.fractionalVal[1];
			}
			
			heritage.root.fractionVal = {numerator, denominator};
			heritageTrees.put(relationship[0], heritage);
		}
		
		double max = 0.0d;
		for(int i = 0; i < m; i++)
		{
			
		}
		
		br.close();
		bw.close();
	}
}

class Tree
{
	Node root;
	
	Tree(String name)
	{
		root = new Node(name);
	}
	
	class Node
	{
		int[] fractionalVal = new int[2];
		String name;
		
		Node[] children = null;
		
		Node(String _name)
		{
			name = _name;
		}
	}
}
