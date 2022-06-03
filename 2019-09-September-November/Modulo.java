import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Modulo
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		
		HashSet<Integer> uniqueVals = new HashSet<Integer>();
		
		for(int i = 0; i < 10; i++)
		{
			int n = Integer.parseInt(br.readLine()); //Read first line
			uniqueVals.add(n%42);
		}
		
		bw.write(uniqueVals.size() + "\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}