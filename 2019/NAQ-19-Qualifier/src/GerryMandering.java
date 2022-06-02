import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class GerryMandering
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] firstParts = br.readLine().split(" ");
		int precinctCount = Integer.parseInt(firstParts[0]);
		int districtCount = Integer.parseInt(firstParts[1]);
		
		ArrayList<District> districts = new ArrayList<District>();
		
		int totalVotes = 0, wastedA = 0, wastedB = 0;
		
		for(int i = 0; i < districtCount + 1; i++)
			districts.add(new District());
		
		for(int i = 0; i < precinctCount; i++)
		{
			String line = br.readLine();
			String[] parts = line.split(" ");
			
			int district = Integer.parseInt(parts[0]) - 1;
			
			int votesA = Integer.parseInt(parts[1]);
			int votesB = Integer.parseInt(parts[2]);
			
			totalVotes += (votesA + votesB);

			districts.get(district).votesA += votesA;
			districts.get(district).votesB += votesB;
			
			if(votesA > votesB)
			{
				districts.get(district).precinctWinners.add(0);
			}
			else if(votesB > votesA)
			{
				districts.get(district).precinctWinners.add(1);
			}
			else
			{
				districts.get(district).precinctWinners.add(-1); //tie
			}
		}
		
		for(int i = 0; i < districtCount; i++)
		{
			District d = districts.get(i);
			/*
			int aCount = 0;
			int bCount = 0;
			for(int w: d.precinctWinners)
				if(w == 0)
					aCount++;
				else if(w == 1)
					bCount++;
			*/

			int majority = (int)Math.floor((d.votesA + d.votesB)/2) + 1;
			//bw.write("District " + (i + 1) + " majority: " + majority + "\n");
			
			if(d.votesA > d.votesB)
			{
				int wasted = d.votesA - majority;
				wastedA += wasted;
				wastedB += d.votesB;
				bw.write("A " + Integer.toString(wasted) + " " + Integer.toString(d.votesB) + "\n");
			}
			else
			{
				int wasted = d.votesB - majority;
				wastedA += d.votesA;
				wastedB += wasted;
				bw.write("B " + Integer.toString(d.votesA) + " " + Integer.toString(wasted) + "\n");
			}
		}
		
		
		double efficiency = Math.abs((double)(wastedA-wastedB)/totalVotes);
		
		bw.write(Double.toString(efficiency) + "\n");
		
		br.close();
		bw.close();
	}
}

class District
{
	ArrayList<Integer> precinctWinners = new ArrayList<Integer>();
	int votesA, votesB;
}

class Precinct
{
	int winner;
}

/*
6 3
1 100 200
1 100 100
2 100 99
3 100 50
3 100 50
2 100 98
 */
