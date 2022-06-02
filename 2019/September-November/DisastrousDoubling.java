import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class DisastrousDoubling
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		BigInteger[] experiments = new BigInteger[x];
		String[] parts = br.readLine().split(" ");
		
		for(int i = 0; i < parts.length; i++)
		{
			experiments[i] = new BigInteger(parts[i]);
		}
		
		BigInteger counter = BigInteger.valueOf(1);
		
		boolean success = true;
		
		for(int i = 0; i < x; i++)
		{
			counter = counter.multiply(BigInteger.valueOf(2));
			
			counter = counter.subtract(experiments[i]);
			
			if(counter.signum() == -1)
			{
				bw.write("error");
				success = false;
				break;
			}
			
			
		}
		
		if(success)
			bw.write(counter.mod(new BigInteger("1000000007")).toString());

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
}