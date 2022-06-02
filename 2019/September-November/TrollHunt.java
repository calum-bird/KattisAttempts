import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class TrollHunt
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		int b = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		int g = Integer.parseInt(parts[2]);
		
		int decrement = Math.floorDiv(k,g);
		int ans = 0;
		
		while(b > 1)
		{
			b-=decrement;
			ans++;
		}
		
		bw.write(Integer.toString(ans));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}