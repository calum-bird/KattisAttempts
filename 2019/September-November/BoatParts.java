import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class BoatParts
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		int P = Integer.parseInt(parts[0]);
		int N = Integer.parseInt(parts[1]);
		
		ArrayList<String> distinct = new ArrayList<String>();
		
		boolean paradox = true;
		int distinctDays = 0;
		
		for(int i = 0; i < N; i++)
		{
			String item = br.readLine();
			if(!distinct.contains(item))
			{
				distinct.add(item);
				if(distinct.size() == P)
				{
					paradox = false;
					distinctDays = i + 1;
					break;
				}
			}
			else
			{
				if(distinct.size() == P)
				{
					paradox = false;
					distinctDays = i;
					break;
				}
			}
		}
		
		if(paradox)
			bw.write("paradox avoided");
		else
			bw.write(Integer.toString(distinctDays));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}