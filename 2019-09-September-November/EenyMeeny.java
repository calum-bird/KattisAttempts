import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class EenyMeeny
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int rhymeLength = br.readLine().split(" ").length;
		
		int x = Integer.parseInt(br.readLine());
		
		ArrayList<String> names = new ArrayList<String>();
		
		ArrayList<String> team1 = new ArrayList<String>();
		ArrayList<String> team2 = new ArrayList<String>();
		
		while(x-- > 0)
		{
			names.add(br.readLine());
		}
		
		while(names.size() > (rhymeLength/2) + 1)
		{
			team1.add(names.get(rhymeLength - 1));
			names.remove(rhymeLength - 1);
		}
		
		for(String n: names)
			team2.add(n);
		
		bw.write(Integer.toString(team1.size()) + "\n");
		for(String n: team1)
			bw.write(n + "\n");
		
		bw.write(Integer.toString(team2.size()) + "\n");
		for(String n: team2)
			bw.write(n + "\n");
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}