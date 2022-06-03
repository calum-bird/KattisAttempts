import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class HotHike
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		int[] temps = new int[x];
		
		String[] temperatures = br.readLine().split(" ");
		
		for(int i = 0; i < x; i++)
		{
			temps[i] = Integer.parseInt(temperatures[i]);
		}
		
		int maxTemp = 100;
		int maxIndex = 0;
		
		for(int i = 1; i < x - 1; i++)
		{
			int max = Math.max(temps[i-1], temps[i+1]);
			if(max < maxTemp)
			{
				maxTemp = max;
				maxIndex = i-1;
			}
		}
		
		bw.write(Integer.toString(maxIndex + 1) + " " + maxTemp);

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}