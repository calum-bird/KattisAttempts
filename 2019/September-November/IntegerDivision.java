import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class IntegerDivision
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int x = Integer.parseInt(parts[0]);
		int divisor = Integer.parseInt(parts[1]);
		
		String[] vals = br.readLine().split(" ");
		int[] nums = new int[x];
		for(int i = 0; i < x; i++)
		{
			nums[i] = Integer.parseInt(vals[i]);
		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < x; i++)
		{
			
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}