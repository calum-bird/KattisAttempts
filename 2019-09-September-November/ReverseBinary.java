import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class ReverseBinary
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		String binaryNum = Integer.toString(x, 2);
		
		
		String reverse = "";
		for(int i = binaryNum.length() - 1; i >= 0; i--)
		{
			reverse = reverse + binaryNum.charAt(i);
		}
		
		bw.write(Integer.toString(Integer.parseInt(reverse, 2), 10));

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}