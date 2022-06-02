import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DiagonalCut
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		String[] parts = br.readLine().split(" ");
		long x = Long.parseLong(parts[0]);
		long y = Long.parseLong(parts[1]);
		
		long gcd = gcd(x,y);
		
		long quotient1 = x/gcd;
		long quotient2 = y/gcd;
		
		if(quotient1 % 2 == 0 || quotient2 % 2 == 0)
			bw.write("0\n");
		else
			bw.write(Long.toString(gcd(x,y)) + "\n");

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static long gcd (long a, long b)
	{
		return b == 0 ? ( a < 0 ?- a : a ) : gcd ( b , a % b );
	}
}