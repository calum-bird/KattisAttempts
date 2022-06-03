import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class SimpleAddition
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String l1 = br.readLine(), l2 = br.readLine(); //Read first line
		
		BigInteger res = new BigInteger(l1);
		res = res.add(new BigInteger(l2));
		
		bw.write(res.toString());
		
		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}