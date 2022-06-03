import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class CardTrick
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		bw.write(Integer.toString(x - 2) + " 1 " + Integer.toString((x%2 == 0) ? x : x-1) + " " + Integer.toString((x-3)-(x+2)) + " " + (x-3));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}