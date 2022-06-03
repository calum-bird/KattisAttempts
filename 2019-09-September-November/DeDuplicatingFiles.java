import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Map.Entry;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DeDuplicatingFiles
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		HashSet<String> count = new HashSet<String>();
		
		int x = Integer.parseInt(br.readLine());
		
		while(x != 0)
		{
			int n = x;
			
			while(n-- > 0)
			{
				String file = br.readLine();
				if(!count.contains(file))
				{
					count.add(file);
				}
			}
			/*
			
			int unique = 0;
			int max = 0;
			for(Entry<String, Integer> e: count.entrySet())
			{
				if(e.getValue() > 1 && max < e.getValue())
				{
					max = e.getValue();
				}
				else
				{
					unique++;
				}
			}
			*/
			
			bw.write(count.size() + "\n");
			
			x = Integer.parseInt(br.readLine());
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}