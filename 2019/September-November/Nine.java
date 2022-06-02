import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class Nine
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Initialize the input reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //Initialize the output writer
		
		int x = Integer.parseInt(br.readLine()); //Read first line
		
		while(x-- > 0)
		{
			int digs = Integer.parseInt(br.readLine());
			BigInteger numberOfNums = BigInteger.TEN.pow(digs).subtract(BigInteger.ONE);
			
			BigInteger d = BigInteger.valueOf(digs);
			BigInteger result;
			result = numberOfNums.subtract(BigInteger.valueOf((long)Math.pow(10, digs) - 1).add(d));
			
			long max = (long)Math.pow(10, digs) - 1;
			long res = max - occurances(max);

			//bw.write(result.mod(new BigInteger("1000000007")).toString() + "\n");
			bw.write(Long.toString(res) + "\n");
		}

		bw.close(); //Cleanup the writer
		br.close(); //Cleanup the reader
	}
	
	static long occurances(long n) 
    {
        long result = 0;
        long itr = 9; 
        
        while (itr <= n)
        {
            if (itr % 10 == 9)
            {
                result++;
            }
            
            if (itr != 0 && itr / 10 == 9)
            {
                result++;
                itr++;
            }
            else if (itr / 10 == 8)
            {
                itr++;
            }
            else
            {
                itr += 10;
            }
        }
        
        return result;
    }
}