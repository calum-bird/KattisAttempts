import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Kornislav
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int[] vals = new int[4];
		String[] params = br.readLine().split(" ");
		for(int i = 0; i < 4; i++)
			vals[i] = Integer.parseInt(params[i]);
		Arrays.sort(vals);
		
		bw.write(Integer.toString(vals[0] * vals[2]));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}