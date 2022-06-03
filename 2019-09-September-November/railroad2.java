import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class railroad2
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		
		int Y = Integer.parseInt(parts[1]); //Read second input
		
		if(Y % 2 == 0)
			bw.write("possible");
		else
			bw.write("impossible");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}