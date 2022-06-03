import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ABC
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		HashMap<Character, Integer> correlations = new HashMap<Character, Integer>();
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		int[] nums = new int[3];
		nums[0] = Integer.parseInt(parts[0]);
		nums[1] = Integer.parseInt(parts[1]);
		nums[2] = Integer.parseInt(parts[2]);
		
		Arrays.sort(nums);
		
		correlations.put('A', nums[0]);
		correlations.put('B', nums[1]);
		correlations.put('C', nums[2]);
		
		char[] order = br.readLine().toCharArray();
		for(char c: order)
		{
			bw.write(correlations.get(c) + " ");
		}
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}