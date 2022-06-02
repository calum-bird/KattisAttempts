import java.io.*;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Faktor
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" "); //Read first line
		
		int A = Integer.parseInt(parts[0]);
		int I = Integer.parseInt(parts[1]);
		
		bw.write(Integer.toString((A*I) - (A -1)));
		

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}