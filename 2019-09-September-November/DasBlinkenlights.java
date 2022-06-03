import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DasBlinkenlights
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		
		String[] parts = br.readLine().split(" ");
		int p = Integer.parseInt(parts[0]);
		int q = Integer.parseInt(parts[1]);
		int s = Integer.parseInt(parts[2]);
		
		if(s >= p*q)
			bw.write("yes");
		else
			bw.write("no");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}