import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class RoamingRomans
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		double x = Double.parseDouble(br.readLine()); //Read first line
		
		int result = (int)Math.round(x/4854*5280*1000);
		
		bw.write(Integer.toString(result));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}