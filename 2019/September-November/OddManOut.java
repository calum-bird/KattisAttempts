import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class OddManOut
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < x; i++)
		{
			int c = Integer.parseInt(br.readLine());
			
			String[] parts = br.readLine().split(" ");
			for(int j = 0; j < c; j++)
			{
				if(existsOnce(parts[j], parts))
				{
					bw.write("Case #" + Integer.toString(i + 1) + ": " + parts[j] + "\n");
				}
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static boolean existsOnce(String s, String[] parts)
	{
		int count = 0;
		
		for(String p: parts)
		{
			if(p.equals(s))
				count++;
		}
		
		if(count == 1)
			return true;	
		
		return false;
	}
}