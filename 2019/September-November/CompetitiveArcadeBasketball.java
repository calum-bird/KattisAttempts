import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class CompetitiveArcadeBasketball
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int p = Integer.parseInt(parts[1]);
		int m = Integer.parseInt(parts[2]);
		
		HashMap<String, Integer> players = new HashMap<String, Integer>();
		HashSet<String> winners = new HashSet<String>();
		
		for(int i = 0; i < n; i++)
		{
			String name = br.readLine();
			players.put(name, 0);
		}

		while(m-- > 0)
		{
			String[] line = br.readLine().split(" ");
			String name = line[0];
			
			if(!winners.contains(name))
			{	
				int score = players.get(name);
				int newScore = score + Integer.parseInt(line[1]);
				
				if(newScore >= p)
				{
					winners.add(name);
					System.out.println(name + " wins!");
				}
				else
				{
					players.put(name, newScore);
				}
			}
		}
		
		if(winners.size() == 0)
			System.out.println("No winner!");
		
		br.close(); //Cleanup the reader
	}
}