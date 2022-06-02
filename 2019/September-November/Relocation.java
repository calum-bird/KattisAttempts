import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Relocation
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] params = br.readLine().split(" ");
		int n = Integer.parseInt(params[0]);
		int q = Integer.parseInt(params[1]);
		
		int[] companyLocations = new int[n];
		
		String[] locations = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
		{
			companyLocations[i] = Integer.parseInt(locations[i]);
		}
		
		while(q-- > 0)
		{
			String[] query = br.readLine().split(" ");
			if(query[0].equals("1"))
			{
				int company = Integer.parseInt(query[1]);
				companyLocations[company - 1] = Integer.parseInt(query[2]);
			}
			else
			{
				int companyA = Integer.parseInt(query[1]);
				int companyB = Integer.parseInt(query[2]);
				int dist = Math.abs(companyLocations[companyA - 1] - companyLocations[companyB - 1]);
				bw.write(Integer.toString(dist) + "\n");
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}