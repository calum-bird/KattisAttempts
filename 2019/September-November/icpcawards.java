import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class icpcawards
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		ArrayList<String> winningTeams = new ArrayList<String>();
		
		int winCount = 0;
		
		for(int i = 0; i < x; i++)
		{
			String line = br.readLine();
			String[] lineParts = line.split(" ");
			
			boolean wonAlready = false;
			
			for(String s: winningTeams)
			{
				if(s.contains(lineParts[0]))
				{
					wonAlready = true;
					break;
				}
			}
			
			if(wonAlready == false && winCount < 12)
			{
				winningTeams.add(lineParts[0]);
				bw.write(line + "\n");
				winCount++;
			}
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}