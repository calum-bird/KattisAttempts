import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

//Author: Calum Bird
//Age: 18
//School: Mount Allison University

public class SortOfSorting
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(!line.equals("0"))
		{
			int n = Integer.parseInt(line);
			char[][] lines = new char[n][];
			
			for(int i = 0; i < n; i++)
			{
				lines[i] = br.readLine().toCharArray();
			}
			
			Arrays.sort(lines, new sortOfCompare());
			
			for(int i = 0; i < n; i++)
			{
				bw.write(lines[i]);
				bw.write("\n");
			}
			
			line = br.readLine();
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}

class sortOfCompare implements Comparator<char[]>
{
	@Override
	public int compare(char[] o1, char[] o2)
	{
		return (o1[0] - o2[0] == 0) ?  o1[1] - o2[1] : o1[0] - o2[0];
	}
	
}