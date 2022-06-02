import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class TheColonizationOfElgarizm
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] params = br.readLine().split(" ");
		int islands = Integer.parseInt(params[0]);
		int resources = Integer.parseInt(params[1]);
		
		HashMap<Integer, int[]> resMap = new HashMap<Integer, int[]>();
		
		for(int i = 0; i < islands; i++)
		{
			int[] localResources = new int[resources];
			String[] line = br.readLine().split(" ");
			for(String s: line)
			{
				if(!s.equals("0"))
				{
					int res = Integer.parseInt(s);
					localResources[res] = 1;
				}
			}

			resMap.put(i, localResources);
		}
		
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}