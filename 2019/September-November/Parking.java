import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Parking
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int testCases = Integer.parseInt(br.readLine()); //Read first line
		
		for(int i = 0; i < testCases; i++)
		{
			br.readLine();
			String[] parts = br.readLine().split(" ");

			int[] nums = new int[parts.length];
			
			for(int j = 0; j < parts.length; j++)
			{
				nums[j] = Integer.parseInt(parts[j]);
			}
			
			Arrays.sort(nums);
			
			bw.write(Integer.toString((nums[nums.length - 1] - nums[0])*2) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}