import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SomeSum
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int n = Integer.parseInt(br.readLine()); //Read first line
		
		if(n == 1)
			bw.write("Either");
		else if(n == 2)
			bw.write("Odd");
		else if(n == 3)
			bw.write("Either");
		else if(n == 4)
			bw.write("Even");
		else if(n == 5)
			bw.write("Either");
		else if(n == 6)
			bw.write("Odd");
		else if(n == 7)
			bw.write("Either");
		else if(n == 8)
			bw.write("Even");
		else if(n == 9)
			bw.write("Either");
		else if(n == 10)
			bw.write("Odd");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}