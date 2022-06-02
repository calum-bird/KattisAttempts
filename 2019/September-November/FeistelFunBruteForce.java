import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class FeistelFunBruteForce
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		for(int i = 1; i < 40; i++)
		{
			//System.out.println(Integer.toString(getRounds(i)));
			System.out.println(Integer.toString(i, 2));
		}
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	public static int getRounds(int n)
	{
		int res = 0;
		
		
		//Brute force the feistel calculation to find the number of rounds!
		
		/*
		 * Maintain a list of the matrix multiplications in an array for X values
		 * Maintain a list of the matrix multiplications in an array for Y values
		 * Recurse until everything except for x and y = 0
		 */
		
		
		return res;
	}
}