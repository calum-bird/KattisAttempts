import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class BabyBites
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		br.readLine(); //Read first line to get rid of it, as it's not necessary
		
		String line = br.readLine();
		String[] parts = line.split(" ");
		
		boolean makesSense = true;
		
		for(int i = 0; i < parts.length; i++)
		{
			String p = parts[i];
			if(!p.contains("mumble"))
			{
				int num = Integer.parseInt(p);
				if(num != i + 1)
					makesSense = false;
			}
		}
		
		if(makesSense)
			bw.write("makes sense\n");
		else
			bw.write("something is fishy\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}