import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class ResearchProductivityIndex
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		
		double[] acceptanceChances = new double[x];
		double[] sortedChances = new double[x];
		
		String[] vals = br.readLine().split(" ");
		
		for(int i = 0; i < x; i++)
		{
			acceptanceChances[i] = Double.parseDouble(vals[i])/100.0d;
		}
		
		Arrays.sort(acceptanceChances);
		
		for(int i = x-1; i >= 0; i--)
		{
			sortedChances[i] = acceptanceChances[i];
		}
		
		double highest = 0.0d;
		
		for(int i = 1; i <= x; i++)
		{
			double cumulativeChance = 1.0d;
			for(int j = 0; j < i; j++)
			{
				cumulativeChance = cumulativeChance + (sortedChances[j]/Math.pow(cumulativeChance, j+x));
			}
			
			double index = productivityIndex(i, cumulativeChance);
			
			if(index > highest)
				highest = index;
		}
		
		bw.write(Double.toString(highest) + "\n");
		
		br.close();
		bw.close();
	}
	
	static double productivityIndex(double submitted, double acceptanceRate)
	{
		double val = (submitted == 0) ? 0 : Math.pow(submitted * acceptanceRate, (submitted * acceptanceRate)/submitted);
		return val;
	}
}
