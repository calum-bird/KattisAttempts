import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class EqualSumEasy
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		int max = 1 << 20;
		
		for(int i = 1; i <= x; i++)
		{
			String[] parts = br.readLine().split(" ");
			int[] vals = new int[20];
			int s = 0;
			for(int j = 0; j < 20; j++)
			{
				vals[j] = Integer.parseInt(parts[j+1]);
				s += vals[j];
			}
			
			s <<= 1;
			
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			
			for(int subset = 0; subset < max; subset++)
			{
				int sum  = 0;
				for(int h = 0; h < 20; h++)
				{
					if((subset & 1) == 1)
					{
						sum += vals[h];
						subset <<= 1;
					}
					
					if(hm.get(vals[h]) != null)
					{
						bw.write(Integer.toString(hm.get(h)) + "\n");
						bw.write(Integer.toString(sum) + "\n");
						break;
					}
					else if(sum == s)
					{
						hm.put(h, s);
					}
				}
			}
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static int sumDigits(int val)
	{
		int sum = 0;
		while(val > 0)
		{
			sum += val % 10;
			val /= 10;
		}
		
		return sum;
	}
}